package util;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;


public class FPS 
{
   /** time at last frame */
   long lastFrame;
	
   /** frames per second */
   int fps;
   /** last fps time */
   long lastFPS;

   // http://lwjgl.org/wiki/index.php?title=LWJGL_Basics_4_%28Timing%29
   public FPS()
   {
   }


   /** 
   * Calculate how many milliseconds have passed 
   * since last frame.
   * 
   * @return milliseconds passed since last frame 
   */
   public int getDelta()
   {
      long time = getTime();
      int delta = (int) (time - lastFrame);
      lastFrame = time;

      return delta;
   }

   /**
   * Get the accurate system time
   * 
   * @return The system time in milliseconds
   */
   public long getTime()
   {
      return (Sys.getTime() * 1000) / Sys.getTimerResolution();
   }

   /**
   * Calculate the FPS and set it in the title bar
   */
   public void updateFPS()
   {
      if (getTime() - lastFPS > 1000)
      {
         Display.setTitle("Game - FPS: " + fps);
         fps = 0;
         lastFPS += 1000;
      }
      fps++;
   }
}
