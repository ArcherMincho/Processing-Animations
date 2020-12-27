float angle = 0.0;

void setup() {
  size(400, 400);
  //smooth();
}

void draw() {
  //pushMatrix();
  translate(mouseX, mouseY);
  rotate(angle);
  scale(sin(angle) + 2);
  rect(-15, -15, 30, 30);
  //popMatrix();
  translate(35, 10);
  rect(0, 0, 15, 15);
  angle += 0.1;
}
