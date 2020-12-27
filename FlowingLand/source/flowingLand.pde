Land l;

void setup() {
  size(600, 600, P3D);
  //frameRate(15);
  
  l = new Land();  
}

void draw() {
  background(0);
  //lights();
  
  l.show();
  l.flowing();
}
