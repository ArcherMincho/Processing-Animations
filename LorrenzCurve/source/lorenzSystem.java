import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import peasy.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class lorenzSystem extends PApplet {



PeasyCam cam;
Lorenz l;
float angle;


public void setup() {
  
  //cam = new PeasyCam(this, 1000);
  
  l = new Lorenz();
  angle = 0.01f;
}

public void draw() {
  background(0);
  translate(width/2-70,height/2-70);
  rotate(angle, angle, angle, angle);
  scale(5);
  
  l.show();
  l.equation();
  angle += 0.01f;
}
class Lorenz {
  float x;//for more accuration, use double
  float y;
  float z;
  //constants
  float a;
  float b;
  float c;
  ArrayList<PVector> points;
  
  Lorenz() {
    a = 10;
    b = 28;
    c = 8.0f/3.0f;
    colorMode(HSB);
    
    points = new ArrayList<PVector>();
    x = 0.01f;
    y = 0.0f;
    z = 0.0f;
    points.add(new PVector(0.01f, 0.0f, 0.0f));
  }
  
  public void equation() {
    float dt = 0.01f;//frame
    float dx = (a * (y - x))*dt;
    float dy = (x * (b - z) - y)*dt;
    float dz = (x * y - c * z)*dt;
    x += dx;
    y += dy;
    z += dz;
    points.add(new PVector(x, y, z));
  }
  
  public void show() {
    stroke(255);
    noFill();
    
    float hu = 0;
    beginShape();
    for (PVector v : points) {
      stroke(hu, 255, 255);
      vertex(v.x, v.y, v.z);

      //tremble
      //PVector offset = PVector.random3D();
      //offset.mult(0.1);
      //v.add(offset);
      
      hu += 0.1f;
      if (hu > 255) {
        hu = 0;
      }
    }
    endShape();
    
  }
  
  
}
  public void settings() {  size(800, 800, P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "lorenzSystem" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
