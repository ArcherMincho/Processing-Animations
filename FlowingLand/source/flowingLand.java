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

public class flowingLand extends PApplet {

Land l;

public void setup() {
  
  //frameRate(15);
  
  l = new Land();  
}

public void draw() {
  background(0);
  //lights();
  
  l.show();
  l.flowing();
}
class Land {
  
  int w, h;
  int cols, rows;
  int scl;
  float[][] terrain;//z cordinary
  float flow;
  
  Land() {
    scl = 20;  
    w = 2000;
    h = 1600;
    cols = w/scl;
    rows = h/scl;
    terrain = new float[cols][rows];
    flow = 0.0f;
    
  }
  
  public void flowing() {
    float yoff = flow;
    
    for (int y=0; y < rows; y++) {
      float xoff = 0.0f;
      for (int x=0; x < cols; x++) {
        terrain[x][y] = map(noise(xoff,yoff), 0, 1, -90, 90);
        xoff += 0.2f;
      }
      yoff += 0.2f;
    }
    
    flow -= 0.1f;
  }
  
  public void show() {
    //noStroke();
    //fill(255,200);
    stroke(255, 180);
    noFill();
    
    //attention!
    translate(width/2, height/2);
    rotateX(PI/3);
    translate(-w/2, -h/2);
    
    for (int y=0; y < rows-1; y++) {
      beginShape(TRIANGLE_STRIP);
      for (int x=0; x < cols; x++) {
        vertex(x*scl, y*scl, terrain[x][y]);
        vertex(x*scl, (y+1)*scl, terrain[x][y+1]);
      }
      endShape();
    }
  }
  
}
  public void settings() {  size(600, 600, P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "flowingLand" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
