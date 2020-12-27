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
  
  void update() {
    z = z-speed;
    if(z<1){
      z = random(0,width);
      pz = z;
    }
  }
  
  void show() {
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
