import Complex.Complex;

public class Tree {
    private static final double SCALE = 250.0;
    private static final int ITERATION_COUNT = 15;
    private static double len = 0.7;
    private static Complex RROT;
    private static Complex LROT;
    private static PntFormatConverter pfc = new PntFormatConverter() {
        public int[] convertComplexToPixel(Complex c) {
            int[] ret = new int[]{(int)(c.getReal() * 250.0 + 500.0), (int)(c.getImag() * 250.0)};
            return ret;
        }
    };
    public static void drawTree() {
        Main.getScreen().refresh();
        updateRots();
        Complex[] cPrev = new Complex[]{new Complex(0.0, 1.0)};
        Complex[] zPrev = new Complex[]{new Complex(0.0, 1.0)};
        Main.getScreen().drawLine(pfc.convertComplexToPixel(new Complex(0.0, 0.0)), pfc.convertComplexToPixel(cPrev[0]));

        for(int i = 0; i < 15; ++i) {
            Complex[] cNext = new Complex[cPrev.length * 2];
            Complex[] zNext = new Complex[zPrev.length * 2];

            for(int j = 0; j < cPrev.length; ++j) {
                cNext[2 * j] = cPrev[j].mult(RROT);
                cNext[2 * j + 1] = cPrev[j].mult(LROT);
                zNext[2 * j] = zPrev[j].add(cNext[2 * j]);
                zNext[2 * j + 1] = zPrev[j].add(cNext[2 * j + 1]);
                int[] points = pfc.convertComplexToPixel(zPrev[j]);
                Main.getScreen().drawLine(points, pfc.convertComplexToPixel(zNext[2 * j]));
                Main.getScreen().drawLine(points, pfc.convertComplexToPixel(zNext[2 * j + 1]));
            }

            cPrev = cNext;
            zPrev = zNext;
        }

        Main.getScreen().show();
    }

    private static void updateRots() {
        RROT = new Complex(Math.cos(Main.getFi()) * len, Math.sin(Main.getFi()) * len);
        LROT = new Complex(Math.cos(-1.0 * Main.getFi()) * len, Math.sin(-1.0 * Main.getFi()) * len);
    }
}
