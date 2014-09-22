/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.lwjgl.opengl.GL11;


public class Axis
{
   public void draw()
   {
      GL11.glLineWidth(3.0f);

      // x (red)
      GL11.glColor3f(1.0f, 0.3f, 0.3f);
      GL11.glBegin(GL11.GL_LINES);
      GL11.glVertex3f(0,0,0);
      GL11.glVertex3f(5,0,0);
      GL11.glEnd();

      // z (green)
      GL11.glColor3f(0.3f, 1.0f, 0.3f);
      GL11.glBegin(GL11.GL_LINES);
      GL11.glVertex3f(0,0,0);
      GL11.glVertex3f(0,5,0);
      GL11.glEnd();
      
      // y (blue)
      GL11.glColor3f(0.3f, 0.3f, 1.0f);
      GL11.glBegin(GL11.GL_LINES);
      GL11.glVertex3f(0,0,0);
      GL11.glVertex3f(0,0,5);
      GL11.glEnd();
   }         
}
