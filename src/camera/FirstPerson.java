
package camera;


import org.lwjgl.util.vector.Vector3f;


import org.lwjgl.opengl.GL11;


//******************************************************************************
// FirstPerson
//
//
//
//******************************************************************************
public class FirstPerson
{
   private Vector3f position = null;

   // the rotation around the Y axis of the camera
   private float yaw   = 0.0f;
   // the rotation around the X axis of the camera
   private float pitch = 0.0f;
   
   
   
   public FirstPerson(float x, float y, float z)
   {
      this.position = new Vector3f(x, y, z);
   }

   public FirstPerson()
   { 
      this.position = new Vector3f(0,0,0);
   }

   
   public void yaw(float amount)
   {
      this.yaw += amount;
   }

   public void pitch(float amount)
   {
      this.pitch += amount;
   }
   
   public void lookThrough()
   {
      //roatate the pitch around the X axis
      GL11.glRotatef(pitch, 1.0f, 0.0f, 0.0f);
      //roatate the yaw around the Y axis
      GL11.glRotatef(yaw, 0.0f, 1.0f, 0.0f);
      //translate to the position vector's location
      GL11.glTranslatef(position.x, position.y, position.z);
   }
   
   public void moveForward(float distance)
   {
      this.position.x -= distance*(float) Math.sin(Math.toRadians(yaw));
      this.position.z += distance*(float) Math.cos(Math.toRadians(yaw));
   }

   //moves the camera backward relitive to its current rotation (yaw)
   public void moveBackwards(float distance)
   {
      this.position.x += distance*(float) Math.sin(Math.toRadians(yaw));
      this.position.z -= distance*(float) Math.cos(Math.toRadians(yaw));
   }

   //strafes the camera left relitive to its current rotation (yaw)
   public void moveLeft(float distance)
   {
      this.position.x -= distance*(float) Math.sin(Math.toRadians(yaw - 90));
      this.position.z += distance*(float) Math.cos(Math.toRadians(yaw - 90));
   }

   //strafes the camera right relitive to its current rotation (yaw)
   public void moveRight(float distance)
   {
      this.position.x -= distance*(float) Math.sin(Math.toRadians(yaw + 90));
      this.position.z += distance*(float) Math.cos(Math.toRadians(yaw + 90));
   }

   public void moveUp(float distance)
   {
      this.position.y -= distance;
   }

   public void moveDown(float distance)
   {
      this.position.y += distance;
   }

}
