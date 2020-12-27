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

public class fractalTrees extends PApplet {


int times;
int len;
float hu;
Branch root;
ArrayList<Branch> trees;

public void setup() {
  
  colorMode(HSB);
  frameRate(5);
  
  len = 150;
  times = 9;
  hu = 0;
  
  trees = new ArrayList<Branch>();
  PVector begin = new PVector(width/2.0f, height);
  PVector end = new PVector(width/2.0f, height-len);

  root = new Branch(begin, end, 0);
  trees.add(root);
}

public void mousePressed() {
  ArrayList<Branch> newTrees = new ArrayList<Branch>();
  
  for(Branch b : trees) {
    newTrees.add(b);
    
    if (b.finished == false && b.count < times) {
      b.finished = true;
      
      Branch left = b.createBranch(1, b.count+1);
      Branch right = b.createBranch(-1, b.count+1); 
      newTrees.add(left);
      newTrees.add(right);
    }
  }
  trees = newTrees;

}

public void draw() {
  background(0);
  
  for(Branch b : trees) {
    b.show();
      if (b.count == times) {
      noStroke();
      fill(hu, 255, 255, 180);
      ellipse(b.end.x, b.end.y, 10, 10);
      
      hu += 0.02f;
      if (hu > 255) {
        hu = 0;
      }
    }
  }
}
class Branch {
  
  PVector begin;
  PVector end;
  float angle;
  float rate;
  boolean finished = false;
  int count;

  
  Branch(PVector b, PVector e, int c) {
    begin = new PVector(b.x, b.y);
    end = new PVector(e.x, e.y);
    angle = PI/6;
    rate = 2.3f/3.0f;
    count = c;
  }
  
  public Branch createBranch(int d, int c) {
    PVector dir = end.copy().sub(begin);
    dir.rotate(angle*d);
    dir.mult(rate);//length
    PVector nend = end.copy().add(dir);
    Branch newb = new Branch(end, nend, c);
    return newb;
    
    //translate(0, -l);
    //line(0, 0, 0, -len);
    
    //pushMatrix();
    //rotate(angle+speed);
    //branch(l*rate);
    //popMatrix();
    //pushMatrix();
    //rotate(-angle-speed);
    //branch(l*rate);
    //popMatrix();
    
  }
  
  public void show() {
    stroke(255);
    line(begin.x, begin.y, end.x, end.y);
  }
  
}
  public void settings() {  size(1200, 1000); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "fractalTrees" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
