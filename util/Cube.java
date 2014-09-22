/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import org.lwjgl.opengl.GL11;


public class Cube 
{
   public void render()
   {
      
      GL11.glBegin(GL11.GL_QUADS);
      //HERE IS WHERE YOU BIND A TEXTURE
      // Front Face
      GL11.glTexCoord2f(0.0f, 0.0f);
      GL11.glVertex3f(-1.0f, -1.0f, 1.0f);   // Bottom Left Of The Texture and Quad
      GL11.glTexCoord2f(1.0f, 0.0f);
      GL11.glVertex3f(1.0f, -1.0f, 1.0f);   // Bottom Right Of The Texture and Quad
      GL11.glTexCoord2f(1.0f, 1.0f);
      GL11.glVertex3f(1.0f, 1.0f, 1.0f);   // Top Right Of The Texture and Quad
      GL11.glTexCoord2f(0.0f, 1.0f);
      GL11.glVertex3f(-1.0f, 1.0f, 1.0f);   // Top Left Of The Texture and Quad

      // Back Face
      GL11.glTexCoord2f(1.0f, 0.0f);
      GL11.glVertex3f(-1.0f, -1.0f, -1.0f);   // Bottom Right Of The Texture and Quad
      GL11.glTexCoord2f(1.0f, 1.0f);
      GL11.glVertex3f(-1.0f, 1.0f, -1.0f);   // Top Right Of The Texture and Quad
      GL11.glTexCoord2f(0.0f, 1.0f);
      GL11.glVertex3f(1.0f, 1.0f, -1.0f);   // Top Left Of The Texture and Quad
      GL11.glTexCoord2f(0.0f, 0.0f);
      GL11.glVertex3f(1.0f, -1.0f, -1.0f);   // Bottom Left Of The Texture and Quad

      // Top Face
      GL11.glTexCoord2f(0.0f, 1.0f);
      GL11.glVertex3f(-1.0f, 1.0f, -1.0f);   // Top Left Of The Texture and Quad
      GL11.glTexCoord2f(0.0f, 0.0f);
      GL11.glVertex3f(-1.0f, 1.0f, 1.0f);   // Bottom Left Of The Texture and Quad
      GL11.glTexCoord2f(1.0f, 0.0f);
      GL11.glVertex3f(1.0f, 1.0f, 1.0f);   // Bottom Right Of The Texture and Quad
      GL11.glTexCoord2f(1.0f, 1.0f);
      GL11.glVertex3f(1.0f, 1.0f, -1.0f);   // Top Right Of The Texture and Quad

      // Bottom Face
      GL11.glTexCoord2f(1.0f, 1.0f);
      GL11.glVertex3f(-1.0f, -1.0f, -1.0f);   // Top Right Of The Texture and Quad
      GL11.glTexCoord2f(0.0f, 1.0f);
      GL11.glVertex3f(1.0f, -1.0f, -1.0f);   // Top Left Of The Texture and Quad
      GL11.glTexCoord2f(0.0f, 0.0f);
      GL11.glVertex3f(1.0f, -1.0f, 1.0f);   // Bottom Left Of The Texture and Quad
      GL11.glTexCoord2f(1.0f, 0.0f);
      GL11.glVertex3f(-1.0f, -1.0f, 1.0f);   // Bottom Right Of The Texture and Quad

      // Right face
      GL11.glTexCoord2f(1.0f, 0.0f);
      GL11.glVertex3f(1.0f, -1.0f, -1.0f);   // Bottom Right Of The Texture and Quad
      GL11.glTexCoord2f(1.0f, 1.0f);
      GL11.glVertex3f(1.0f, 1.0f, -1.0f);   // Top Right Of The Texture and Quad
      GL11.glTexCoord2f(0.0f, 1.0f);
      GL11.glVertex3f(1.0f, 1.0f, 1.0f);   // Top Left Of The Texture and Quad
      GL11.glTexCoord2f(0.0f, 0.0f);
      GL11.glVertex3f(1.0f, -1.0f, 1.0f);   // Bottom Left Of The Texture and Quad

      // Left Face
      GL11.glTexCoord2f(0.0f, 0.0f);
      GL11.glVertex3f(-1.0f, -1.0f, -1.0f);   // Bottom Left Of The Texture and Quad
      GL11.glTexCoord2f(1.0f, 0.0f);
      GL11.glVertex3f(-1.0f, -1.0f, 1.0f);   // Bottom Right Of The Texture and Quad
      GL11.glTexCoord2f(1.0f, 1.0f);
      GL11.glVertex3f(-1.0f, 1.0f, 1.0f);   // Top Right Of The Texture and Quad
      GL11.glTexCoord2f(0.0f, 1.0f);
      GL11.glVertex3f(-1.0f, 1.0f, -1.0f);   // Top Left Of The Texture and Quad
      GL11.glEnd();
   }
}
