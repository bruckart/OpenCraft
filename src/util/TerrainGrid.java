/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import org.lwjgl.opengl.GL11;


import javax.vecmath.Vector3f;


public class TerrainGrid 
{
   // int theFloorWidth;
   // int theFloorLength;

   int tileSize;
   
   float theSpacing;
   
   float theHeightRange;
   
   public TerrainGrid()
   {
      // this.theFloorWidth  = w;
      // this.theFloorLength = l;
      
      this.tileSize  = 1;
      
      this.theHeightRange = 0.20f;
      
      
      int[][] multD = new int[5][10];
      
      // Build some sort of 3D data structure matrix so that you can
      // iterate through the rows and columns and observe the info.
      
      // Colorize each cell based upon whether it's toggled.
      
      // Each Polygon will have an ON or OFF state. While on, 
      // it can play a chime.
      
      // int numQuadsX = this.theFloorWidth / this.tileSize;
      // int numQuadsY = this.theFloorLength / this.tileSize;
      
      
      // int[][] coords = new int[numQuadsX][numQuadsY];
//
//      for (int x = 0; x < numQuadsX; x += this.tileSize)
//      {  
//         for (int y = 0; y < numQuadsY; y += this.tileSize)
//         {
//            // int[x][y] = new Vertex(x,y,0);
//            Vector3f pos = new Vector3f(x,y,0);
//         }
//         
//      }
      
      
      
   }
   
   public void renderQuard()
   {
      GL11.glBegin(GL11.GL_QUADS); // Start drawing a quad primitive  

      GL11.glVertex3f(-1.0f, -1.0f, 0.0f); // The bottom left corner  
      GL11.glVertex3f(-1.0f, 1.0f, 0.0f); // The top left corner  
      GL11.glVertex3f(1.0f, 1.0f, 0.0f); // The top right corner  
      GL11.glVertex3f(1.0f, -1.0f, 0.0f); // The bottom right corner  

      GL11.glEnd();  
}  

   public void render()
   {
      // for (int i = 0; i < this.theBoxes.size(); i++)
      // {
      // }
      
      
   }
}
