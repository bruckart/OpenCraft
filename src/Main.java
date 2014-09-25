

import java.awt.event.KeyEvent;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
// import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.glu.GLU;


import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
 
import java.io.IOException;

import org.lwjgl.openal.AL;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.util.ResourceLoader;




//******************************************************************************
// FirstPerson
//
//
//
//******************************************************************************
public class Main
{
   private Texture texture;
   
   
   
   private float xrot = 0.1f;
   private float yrot = 0.1f;
   private float zrot = 0.1f;

   private static boolean gameRunning = true;
   
   private static int targetWidth     = 800;
   private static int targetHeight    = 600;

   camera.FirstPerson camera = new camera.FirstPerson();
      

   /** The ogg sound effect */
   private Audio oggEffect;
   /** The wav sound effect */
   private Audio wavEffect;
   /** The aif source effect */
   private Audio aifEffect;
   /** The ogg stream thats been loaded */
   private Audio oggStream;
   /** The mod stream thats been loaded */
   private Audio modStream;
   
   // the 3d vector to store the camera's position in
   // private Vector3f position = null;
   // the rotation around the Y axis of the camera
   // private float yaw   = 0.0f;
   // the rotation around the X axis of the camera
   // private float pitch = 0.0f;
   
   util.Axis axis = new util.Axis();
   util.Grid grid = new util.Grid();
   // util.Cube cube = new util.Cube();
   
   // TerrainGrid tg = new TerrainGrid();

   /*
   public Main(float x, float y, float z)
   {
      //instantiate position Vector3f to the x y z params.
      position = new Vector3f(x, y, z);
   }
    */
   
   //***************************************************************************
   // Main
   //***************************************************************************
   public Main()
   { 
      // position = new Vector3f(0,0,0);      
   }

   /*
   public void yaw(float amount)
   {
      yaw += amount;
   }

   public void pitch(float amount)
   {
      pitch += amount;
   }
   //moves the camera forward relitive to its current rotation (yaw)

   public void moveForward(float distance)
   {
      position.x -= distance * (float) Math.sin(Math.toRadians(yaw));
      position.z += distance * (float) Math.cos(Math.toRadians(yaw));
   }

   //moves the camera backward relitive to its current rotation (yaw)
   public void moveBackwards(float distance)
   {
      position.x += distance * (float) Math.sin(Math.toRadians(yaw));
      position.z -= distance * (float) Math.cos(Math.toRadians(yaw));
   }

   //strafes the camera left relitive to its current rotation (yaw)
   public void moveLeft(float distance)
   {
      position.x -= distance * (float) Math.sin(Math.toRadians(yaw - 90));
      position.z += distance * (float) Math.cos(Math.toRadians(yaw - 90));
   }

   //strafes the camera right relitive to its current rotation (yaw)
   public void moveRight(float distance)
   {
      position.x -= distance * (float) Math.sin(Math.toRadians(yaw + 90));
      position.z += distance * (float) Math.cos(Math.toRadians(yaw + 90));
   }

   public void moveUp(float distance)
   {
      position.y -= distance;
   }

   public void moveDown(float distance)
   {
      position.y += distance;
   }

   
   //translates and rotate the matrix so that it looks through the camera
   //this dose basic what gluLookAt() does
   public void lookThrough()
   {
      //roatate the pitch around the X axis
      GL11.glRotatef(pitch, 1.0f, 0.0f, 0.0f);
      //roatate the yaw around the Y axis
      GL11.glRotatef(yaw, 0.0f, 1.0f, 0.0f);
      //translate to the position vector's location
      GL11.glTranslatef(position.x, position.y, position.z);
   }
   */
   
   //***************************************************************************
   // initDisplay
   //***************************************************************************
   private static void initDisplay(boolean fullscreen)
   {
      DisplayMode chosenMode = null;

      try
      {
         DisplayMode[] modes = Display.getAvailableDisplayModes();

         for (int i = 0; i < modes.length; i++)
         {
            if ((modes[i].getWidth() == targetWidth) && 
                (modes[i].getHeight() == targetHeight))
            {
               chosenMode = modes[i];
               break;
            }
         }
      }
      catch (LWJGLException e) 
      {
         Sys.alert("Error", "Unable to determine display modes.");
         System.exit(0);
      }

      // at this point if we have no mode there was no appropriate, let the user know
      // and give up
      if (chosenMode == null) {
         Sys.alert("Error", "Unable to find appropriate display mode.");
         System.exit(0);
      }

      try 
      {
         Display.setDisplayMode(chosenMode);
         Display.setFullscreen(fullscreen);
         Display.setTitle("OpenCraft");
         Display.create();

      }
      catch (LWJGLException e)
      {
         Sys.alert("Error", "Unable to create display.");
         System.exit(0);
      }
   }

   //***************************************************************************
   // initGL
   //***************************************************************************
   private static boolean initGL()
   {
      GL11.glMatrixMode(GL11.GL_PROJECTION);
      GL11.glLoadIdentity();

      // Calculate the aspect ratio of the window
      GLU.gluPerspective(
              45.0f, ((float) targetWidth) / ((float) targetHeight), 0.1f, 100.0f);
 
      GL11.glMatrixMode(GL11.GL_MODELVIEW);
      GL11.glLoadIdentity();

      GL11.glEnable(GL11.GL_TEXTURE_2D);
      
      // Enable Texture Mapping (NEW)
      GL11.glShadeModel(GL11.GL_SMOOTH);
      GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
      GL11.glClearDepth(1.0f);
      GL11.glEnable(GL11.GL_DEPTH_TEST);
      GL11.glDepthFunc(GL11.GL_LEQUAL);
      GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
      
      return true;
   }

   /*
   public boolean isKeyPressed(int keyCode)
   {
      switch (keyCode)
      {
         case KeyEvent.VK_SPACE:
            keyCode = Keyboard.KEY_SPACE;
            break;
         case KeyEvent.VK_ESCAPE:
            keyCode = Keyboard.KEY_ESCAPE;
            break;
         case KeyEvent.VK_W:
            keyCode = Keyboard.KEY_W;
            break;
         case KeyEvent.VK_A:
            keyCode = Keyboard.KEY_A;
            break;
         case KeyEvent.VK_S:
            keyCode = Keyboard.KEY_S;
            break;
         case KeyEvent.VK_D:
            keyCode = Keyboard.KEY_D;
            break;
      }

      return org.lwjgl.input.Keyboard.isKeyDown(keyCode);
   }
   */
   
   //***************************************************************************
   // init
   //***************************************************************************
   private void init()
   {
      //load textures here and other things

      try
      {
         // load texture from PNG file
         texture = TextureLoader.getTexture(
                 "JPG",
                 // ResourceLoader.getResourceAsStream("/Users/robert/Desktop/IMG_0994.PNG"));
                 ResourceLoader.getResourceAsStream("/Users/robert/Desktop/edkxryo.jpg"));

         System.out.println("Texture loaded:    "+texture);
         System.out.println(">> Image width:    "+texture.getImageWidth());
         System.out.println(">> Image height:   "+texture.getImageHeight());
         System.out.println(">> Texture width:  "+texture.getTextureWidth());
         System.out.println(">> Texture height: "+texture.getTextureHeight());
         System.out.println(">> Texture ID:     "+texture.getTextureID());
         
         
         // AL

         // you can play oggs by loading the complete thing into
         // a sound
         // oggEffect = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("testdata/restart.ogg"));

         // or setting up a stream to read from. Note that the argument becomes
         // a URL here so it can be reopened when the stream is complete. Probably
         // should have reset the stream by thats not how the original stuff worked
         // oggStream = AudioLoader.getStreamingAudio("OGG", ResourceLoader.getResource("testdata/bongos.ogg"));

         // can load mods (XM, MOD) using ibxm which is then played through OpenAL. MODs
         // are always streamed based on the way IBXM works
         // modStream = AudioLoader.getStreamingAudio("MOD", ResourceLoader.getResource("testdata/SMB-X.XM"));

         // playing as music uses that reserved source to play the sound. The first
         // two arguments are pitch and gain, the boolean is whether to loop the content
         // modStream.playAsMusic(1.0f, 1.0f, true);


         // you can play aifs by loading the complete thing into
         // a sound
         // aifEffect = AudioLoader.getAudio("AIF", ResourceLoader.getResourceAsStream("testdata/burp.aif"));

         // you can play wavs by loading the complete thing into
         // a sound
         // wavEffect = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("testdata/cbrown01.wav"));

      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }

   //***************************************************************************
   // run
   //***************************************************************************
   private void run()
   {
      // Main camera = new Main(0, 0, 0);

      float dx = 0.0f;
      float dy = 0.0f;
      float dt = 0.0f;
      
      float lastTime = 0.0f; // when the last frame was
      float time     = 0.0f;

      float mouseSensitivity = 0.15f;
      float movementSpeed    = 10.0f; //move 10 units per second

      //hide the mouse
      Mouse.setGrabbed(true);


      while ((gameRunning) && 
             (!Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)))
      {
         // update();

         // render();
         GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
         //GL11.glLoadIdentity();
         GL11.glTranslatef(0.0f, 0.0f, -5.0f);
         
         axis.draw();
         grid.render();
         // cube.render();

         /*
         {
            Color.white.bind();
            texture.bind(); // or GL11.glBind(texture.getTextureID());

            GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0,0);
            GL11.glVertex2f(100,100);
            GL11.glTexCoord2f(1,0);
            GL11.glVertex2f(100+texture.getTextureWidth(),100);
            GL11.glTexCoord2f(1,1);
            GL11.glVertex2f(100+texture.getTextureWidth(),100+texture.getTextureHeight());
            GL11.glTexCoord2f(0,1);
            GL11.glVertex2f(100,100+texture.getTextureHeight());
            GL11.glEnd();
         }
         */
         
         Display.update();

         
         //keep looping till the display window is closed the ESC key is down
            /*
         while (!Display.isCloseRequested() ||
         !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
         {
          */
         time = Sys.getTime();

         //here is your movement speed, which can be changed to anything
         dt = 0.0005f;

         lastTime = time;


         //distance in mouse movement from the last getDX() call.
         dx = Mouse.getDX();
         //distance in mouse movement from the last getDY() call.
         dy = Mouse.getDY();

         //control camera yaw from x movement from the mouse
         camera.yaw(dx * mouseSensitivity);
         //control camera pitch from y movement from the mouse
         camera.pitch(-dy * mouseSensitivity);


         //when passing in the distrance to move
         //we times the movementSpeed with dt this is a time scale
         //so if its a slow frame u move more then a fast frame
         //so on a slow computer you move just as fast as on a fast computer

         if (Keyboard.isKeyDown(Keyboard.KEY_W))
         {
            camera.moveForward(movementSpeed * dt);
         }
         if (Keyboard.isKeyDown(Keyboard.KEY_S))
         {
            camera.moveBackwards(movementSpeed * dt);
         }
         if (Keyboard.isKeyDown(Keyboard.KEY_A))
         {
            camera.moveLeft(movementSpeed * dt);
         }
         if (Keyboard.isKeyDown(Keyboard.KEY_D))
         {
            camera.moveRight(movementSpeed * dt);
         }
         if (Keyboard.isKeyDown(Keyboard.KEY_D))
         {
            camera.moveRight(movementSpeed * dt);
         }

         
         if (Keyboard.isKeyDown(Keyboard.KEY_SPACE))
         {
            camera.moveUp(movementSpeed * dt);
         }
         
         
         
         if (Keyboard.isKeyDown(Keyboard.KEY_P))
         {
            
            // camera.moveRight(movementSpeed * dt);
         }

         //set the modelview matrix back to the identity
         GL11.glLoadIdentity();
         //look through the camera before you draw anything
         camera.lookThrough();
         
         
         // you would draw your scene here.

         
         if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
         {
            Sys.alert(
              "Close",
              "To continue, press ESCAPE on your keyboard or OK on the screen.");
            System.exit(0);
         }
      }
   }
   
   /*
   private void update()
   {
      xrot += 0.1f;
      yrot += 0.1f;
      zrot += 0.1f;
   }


   private void render()
   {
      GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
      //GL11.glLoadIdentity();

      GL11.glTranslatef(0.0f, 0.0f, -5.0f);                              
      // Move Into The Screen 5 Units

//        
//        drawAxis();
//        
//        drawGrid();
   }
   */

   public static void main(String[] args)
   {
      Main main = new Main();
      initDisplay(false);
      initGL();

      
      // main.init();
      main.run();
      
      AL.destroy();
   }
}
