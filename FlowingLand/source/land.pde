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
    flow = 0.0;
    
  }
  
  void flowing() {
    float yoff = flow;
    
    for (int y=0; y < rows; y++) {
      float xoff = 0.0;
      for (int x=0; x < cols; x++) {
        terrain[x][y] = map(noise(xoff,yoff), 0, 1, -90, 90);
        xoff += 0.2;
      }
      yoff += 0.2;
    }
    
    flow -= 0.1;
  }
  
  void show() {
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
