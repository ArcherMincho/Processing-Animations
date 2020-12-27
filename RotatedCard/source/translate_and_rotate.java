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

public class translate_and_rotate extends PApplet {

float angle = 0.0f;

public void setup() {
  
  //smooth();
}

public void draw() {
  //pushMatrix();
  translate(mouseX, mouseY);
  rotate(angle);
  scale(sin(angle) + 2);
  rect(-15, -15, 30, 30);
  //popMatrix();
  translate(35, 10);
  rect(0, 0, 15, 15);
  angle += 0.1f;
}
  public void settings() {  size(400, 400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "translate_and_rotate" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
