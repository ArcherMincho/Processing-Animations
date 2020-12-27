import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sponge_box extends PApplet {

Box b;
float rot;
int click;
ArrayList<Box> sponge;

public void setup() {
  
  noStroke();
  fill(255);
  sponge = new ArrayList<Box>();
  b = new Box(0,0,0,300);
  sponge.add(b);
  click = 0;
}

public void mousePressed() {
  if(click >= 3) return;
  
  ArrayList<Box> newSponge = new ArrayList<Box>();
  for (Box b : sponge) {
    ArrayList<Box> generation = b.generate();
    newSponge.addAll(generation);
  }
  sponge = newSponge;
  click += 1;
}

public void draw() {
  background(51);
  lights();
  
  translate(width/2, height/2);
  rotateX(rot);
  rotateY(rot*0.4f);
  rotateZ(rot*0.5f);
  for (Box b : sponge) {
    b.show();
  }
  rot += 0.01f;
}
class Box {
  PVector pos;
  float r;
  
 Box(float x, float y, float z, float r_) {
   pos = new PVector(x, y, z);
   r = r_;
 }

public ArrayList<Box> generate() {
   ArrayList<Box> boxes = new ArrayList<Box>();
   float newR = r/3;

   //three dimensional
   for (int x = -1; x < 2; x++) {//0 is the center one
     for (int y = -1; y < 2; y++) {
       for (int z = -1; z < 2; z++) {
         
         int sum = abs(x) + abs(y) + abs(z);
         if (sum > 1) {//if tow of its coordinate is 0 then don't draw
           Box b = new Box(pos.x + x*newR, pos.y + y*newR, 
           pos.z + z*newR, newR);//compared to the father box position
           boxes.add(b);
         }
       }
     }
   }
   return boxes;
 }
 
 public void show() {
   pushMatrix();
   //lights();  lignts can't be put here or you'll see
   translate(pos.x, pos.y, pos.z);
   box(r);
   popMatrix();
 }
}
  public void settings() {  size(700, 700, P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "sponge_box" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
