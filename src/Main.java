import Complex.Complex;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
   private static final int SCREEN_SIZE = 1000;
   private static Screen scrn = new Screen(1000, rgbPoint(255, 255, 255), true);
   private static double fi = Math.PI/4;
   private static int rgbPoint(int r, int g, int b) {
      return r << 16 | g << 8 | b;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("1-animate; 0-input");
      String command = "";

      try {
         command = sc.nextLine();
      } catch (NoSuchElementException e) {
      }

      if (!command.equals("1")) {
         scrn.setCloseOnExit(false);

         while(true) {
            try {
               command = sc.nextLine();
            } catch (NoSuchElementException var6) {
            }

            fi = Math.PI / Double.parseDouble(command);
            Tree.drawTree();
         }
      }

      double scale = 1000;

      for(double i = 2*Math.PI; i > Math.PI; i -= Math.PI / scale) {
         fi = i;
         Tree.drawTree();
      }

   }
   public static Screen getScreen(){return scrn;}
   public static double getFi(){return fi;}
}
