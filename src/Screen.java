import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Screen {
   private JFrame frame;
   private int size;
   private BufferedImage img;
   private boolean closeOnExit;
   private int color;

   public Screen(int size, int color, boolean closeOnExit) {
      this.size = size;
      this.color = color;
      this.closeOnExit = closeOnExit;
      this.frame = new JFrame();
      if (closeOnExit) {
         this.frame.setDefaultCloseOperation(3);
      }

      this.img = new BufferedImage(size, size, 1);
   }

   public void setCloseOnExit(boolean closeOnExit) {
      if (closeOnExit) {
         this.frame.setDefaultCloseOperation(3);
      } else {
         this.frame.setDefaultCloseOperation(2);
      }

   }

   public void refresh() {
      this.img = new BufferedImage(this.size, this.size, 1);
   }

   public void setPixel(int x, int y) {
      this.img.setRGB(x, this.size - y, this.color);
   }

   public void drawLine(int ax, int ay, int bx, int by) {
      int xDif = bx - ax;
      int yDif = by - ay;
      double len = Math.sqrt((double)(xDif * xDif + yDif * yDif));
      double xStep = (double)xDif / len;
      double yStep = (double)yDif / len;
      double a = (double)ax;
      double b = (double)ay;

      for(int var17 = 0; (double)var17 < len; ++var17) {
         if (a > 1.0 && a < (double)(this.size - 1) && b > 1.0 && b < (double)(this.size - 1)) {
            this.setPixel((int)a, (int)b);
         }

         a += xStep;
         b += yStep;
      }

   }

   public void drawLine(int[] a, int[] b) {
      this.drawLine(a[0], a[1], b[0], b[1]);
   }

   public void show() {
      this.frame.getContentPane().removeAll();
      this.frame.repaint();
      this.frame.getContentPane().add(new JLabel(new ImageIcon(this.img)));
      this.frame.pack();
      this.frame.repaint();
      this.frame.setVisible(true);
   }
}
