import peasy.*;

PeasyCam cam;
Lorenz l;
float angle;


void setup() {
  size(800, 800, P3D);
  //cam = new PeasyCam(this, 1000);
  
  l = new Lorenz();
  angle = 0.01;
}

void draw() {
  background(0);
  translate(width/2-70,height/2-70);
  rotate(angle, angle, angle, angle);
  scale(5);
  
  l.show();
  l.equation();
  angle += 0.01;
}
