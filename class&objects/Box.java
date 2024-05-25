import java.util.*;

class Box {
   double width;
   double height;
   double depth;

   Box(double width, double height, double depth) {

      this.width = width;
      this.height = height;
      this.depth = depth;
   }

   double volume() {
      return width * height * depth;
   }

   public static void main(String args[]) {
      double w, h, d;
      Scanner input = new Scanner(System.in);
      Box mybox1 = new Box(10, 20, 15);
      Box mybox2 = new Box(3, 6, 9);
      double vol;

      vol = mybox1.volume();
      System.out.println("Volume is " + vol);

      vol = mybox2.volume();
      System.out.println("Volume is " + vol);
      // ''''''''''''''''''''''''''''
      System.out.print("enter width:");
      w = input.nextDouble();
      System.out.print("enter length:");
      h = input.nextDouble();
      System.out.print("enter height:");
      d = input.nextDouble();
      Box nbox = new Box(w, h, d);
      vol = nbox.volume();
      System.out.println("Volume is " + vol);
   }

}
