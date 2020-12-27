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

public class starField extends PApplet {

Star[] stars = new Star[400];
float speed;

public void setup() {
  
  for(int i = 0;i<stars.length;i++){
    stars[i] = new Star();
  }
}

public void draw() {
  background(0);
  translate(width/2, height/2);
  //println(mouseX);//mouseX isn't related to translated cordinary
  speed = map(mouseX, 0, width, -25, 25);
  //println(speed);
  speed = abs(speed);
    
  for(int i=0;i<stars.length;i++){
    stars[i].update();
    stars[i].show();
  }
}
class Star {
  float x;
  float y;
  float z;
  float pz;
  float diameter;
  
  Star(){
    x = random(-width/2, width/2);
    y = random(-height/2, height/2);
    z = random(0, width);
    pz = z;
    diameter = map(z, 0, width, 8, 0);
  }
  
  public void update() {
    z = z-speed;
    if(z<1){
      z = random(0,width);
      pz = z;
    }
  }
  
  public void show() {
    fill(255);
    noStroke();
    
    float sx = map(x/z, 0, 1, 0, width);
    float sy = map(y/z, 0, 1, 0, height);
    //float sx = x/(z/width);
    //float sy = y/(z/width);
    
    //ellipse(sx, sy, diameter, diameter);
    
    float px = map(x/pz, 0, 1, 0, width);
    float py = map(y/pz, 0, 1, 0, height);
    
    stroke(255);
    line(px, py, sx, sy);
    
    pz = z;
    
  }
  
}
  public void settings() {  size(600, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "starField" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
