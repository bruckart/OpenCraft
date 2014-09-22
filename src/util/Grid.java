/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import org.lwjgl.opengl.GL11;


public class Grid
{
   public void render()
   {

      // System.out.println("Draw Grid");
      
      GL11.glLineWidth(1.0f);
      GL11.glColor3f(0.4f, 0.4f, 0.4f);
      
      GL11.glBegin(GL11.GL_LINES);
      GL11.glVertex3f(0.5f,0,-10);
      GL11.glVertex3f(0.5f,0,10);
      GL11.glEnd();

      GL11.glBegin(GL11.GL_LINES);
      GL11.glVertex3f(1.0f,0,-10);
      GL11.glVertex3f(1.0f,0,10);
      GL11.glEnd();

      GL11.glBegin(GL11.GL_LINES);
      GL11.glVertex3f(0f,0,-10);
      GL11.glVertex3f(0f,0,10);
      GL11.glEnd();
      
      GL11.glBegin(GL11.GL_LINES);
      GL11.glVertex3f(-0.5f,0,-10);
      GL11.glVertex3f(-0.5f,0,10);
      GL11.glEnd();
      
      GL11.glBegin(GL11.GL_LINES);
      GL11.glVertex3f(-1.0f,0,-10);
      GL11.glVertex3f(-1.0f,0,10);
      GL11.glEnd();

      //***
      //
      //***
      GL11.glLineWidth(1.0f);
      GL11.glColor3f(0.2f, 0.2f, 0.2f);
      
      GL11.glBegin(GL11.GL_LINES);
      GL11.glVertex3f(-10,0,0.5f);
      GL11.glVertex3f(10,0,0.5f);
      GL11.glEnd();
      
      GL11.glBegin(GL11.GL_LINES);
      GL11.glVertex3f(-10,0,1.0f);
      GL11.glVertex3f(10,0,1.0f);
      GL11.glEnd();
      
      GL11.glBegin(GL11.GL_LINES);
      GL11.glVertex3f(-10,0,0f);
      GL11.glVertex3f(10,0,0f);
      GL11.glEnd();
      
      GL11.glBegin(GL11.GL_LINES);
      GL11.glVertex3f(-10,0,-1.0f);
      GL11.glVertex3f(10,0,-1.0f);
      GL11.glEnd();
      
      GL11.glBegin(GL11.GL_LINES);
      GL11.glVertex3f(-10,0,-0.5f);
      GL11.glVertex3f(10,0,-0.5f);
      GL11.glEnd();
      
      
      
      
      
      
      GL11.glLineWidth(8.0f);
      // OpenGL 1.1 drawing routine
      GL11.glBegin(GL11.GL_POINTS);
      GL11.glVertex3f(0.5f,  0.0f, 0.0f);
      GL11.glVertex3f( 0.0f,  0.5f,  0.0f);
      GL11.glVertex3f(0.0f, -0.5f,  0.0f);
      GL11.glVertex3f(-0.5f, -0.0f,  0.0f);
      GL11.glEnd();
      /*
      
      GL11.glBegin(GL11.GL_POINTS);
      for (int x=-400; x<400; x+=5)
      {
         for (int y=-400; y<400; y+=5)
         {
            GL11.glVertex3f(x,y,0);
         }
      }
      GL11.glEnd(); 
      
      */
      
      /*
      GL11.glBegin(GL11.GL_POLYGON);
      GL11.glVertex3f(0.1f, 0.1f, 0.0f);
      GL11.glVertex3f(0.1f, 0.9f, 0.0f);
      GL11.glVertex3f(0.9f, 0.9f, 0.0f);
      GL11.glVertex3f(0.9f, 0.1f, 0.0f);
      GL11.glEnd();
      */
      
   }
}
