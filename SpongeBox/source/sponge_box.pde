Box b;
float rot;
int click;
ArrayList<Box> sponge;

void setup() {
  size(700, 700, P3D);
  noStroke();
  fill(255);
  sponge = new ArrayList<Box>();
  b = new Box(0,0,0,300);
  sponge.add(b);
  click = 0;
}

void mousePressed() {
  if(click >= 3) return;
  
  ArrayList<Box> newSponge = new ArrayList<Box>();
  for (Box b : sponge) {
    ArrayList<Box> generation = b.generate();
    newSponge.addAll(generation);
  }
  sponge = newSponge;
  click += 1;
}

void draw() {
  background(51);
  lights();
  
  translate(width/2, height/2);
  rotateX(rot);
  rotateY(rot*0.4);
  rotateZ(rot*0.5);
  for (Box b : sponge) {
    b.show();
  }
  rot += 0.01;
}
