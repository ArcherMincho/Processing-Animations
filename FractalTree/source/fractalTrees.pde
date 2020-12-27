
int times;
int len;
float hu;
Branch root;
ArrayList<Branch> trees;

void setup() {
  size(1200, 1000);
  colorMode(HSB);
  frameRate(5);
  
  len = 150;
  times = 9;
  hu = 0;
  
  trees = new ArrayList<Branch>();
  PVector begin = new PVector(width/2.0, height);
  PVector end = new PVector(width/2.0, height-len);

  root = new Branch(begin, end, 0);
  trees.add(root);
}

void mousePressed() {
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

void draw() {
  background(0);
  
  for(Branch b : trees) {
    b.show();
      if (b.count == times) {
      noStroke();
      fill(hu, 255, 255, 180);
      ellipse(b.end.x, b.end.y, 10, 10);
      
      hu += 0.02;
      if (hu > 255) {
        hu = 0;
      }
    }
  }
}
