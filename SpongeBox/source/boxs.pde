class Box {
  PVector pos;
  float r;
  
 Box(float x, float y, float z, float r_) {
   pos = new PVector(x, y, z);
   r = r_;
 }

ArrayList<Box> generate() {
   ArrayList<Box> boxes = new ArrayList<Box>();
   float newR = r/3;

   //three dimensional
   for (int x = -1; x < 2; x++) {//0 is the center one
     for (int y = -1; y < 2; y++) {
       for (int z = -1; z < 2; z++) {
         
         int sum = abs(x) + abs(y) + abs(z);
         if (sum > 1) {//if tow of its coordinate is 0 then don't draw
           Box b = new Box(pos.x + x*newR, pos.y + y*newR, 
           pos.z + z*newR, newR);//compared to the father box position
           boxes.add(b);
         }
       }
     }
   }
   return boxes;
 }
 
 void show() {
   pushMatrix();
   //lights();  lignts can't be put here or you'll see
   translate(pos.x, pos.y, pos.z);
   box(r);
   popMatrix();
 }
}
