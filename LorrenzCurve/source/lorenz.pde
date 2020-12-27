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
    c = 8.0/3.0;
    colorMode(HSB);
    
    points = new ArrayList<PVector>();
    x = 0.01;
    y = 0.0;
    z = 0.0;
    points.add(new PVector(0.01, 0.0, 0.0));
  }
  
  void equation() {
    float dt = 0.01;//frame
    float dx = (a * (y - x))*dt;
    float dy = (x * (b - z) - y)*dt;
    float dz = (x * y - c * z)*dt;
    x += dx;
    y += dy;
    z += dz;
    points.add(new PVector(x, y, z));
  }
  
  void show() {
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
      
      hu += 0.1;
      if (hu > 255) {
        hu = 0;
      }
    }
    endShape();
    
  }
  
  
}
