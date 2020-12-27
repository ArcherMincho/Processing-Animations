Star[] stars = new Star[400];
float speed;

void setup() {
  size(600, 600);
  for(int i = 0;i<stars.length;i++){
    stars[i] = new Star();
  }
}

void draw() {
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
