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
    rate = 2.3/3.0;
    count = c;
  }
  
  Branch createBranch(int d, int c) {
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
  
  void show() {
    stroke(255);
    line(begin.x, begin.y, end.x, end.y);
  }
  
}
