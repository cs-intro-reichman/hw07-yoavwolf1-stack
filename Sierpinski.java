/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		int height = 500;
		int width = 500;
		double ratio = Math.sqrt(3.0 / 4);
		double x1 = width * 0.1, x2 = width / 2.0, x3 = width * 0.9;
		double y1 = height * 0.1, y2 = (width * 0.8) * ratio, y3 = height * 0.1;

		setCanvas(height, width);
		sierpinski(n, x1, x2, x3, y1, y2, y3);
		StdDraw.show();
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if(n == 0) return;
		StdDraw.line(x1, y1, x2, y2);
		StdDraw.line(x1, y1, x3, y3);
		StdDraw.line(x2, y2, x3, y3);

		double newx1 = (x1 + x2)/2,  newy1 = (y1 + y2)/2;
		double newx2 = (x2 + x3)/2, newy2 = (y2 + y3)/2;
		double newx3 = (x3 + x1)/2, newy3 = (y3 + y1)/2;
		
		sierpinski(n-1, newx1, x2, newx2, newy1, y2, newy2);
		sierpinski(n-1, newx2, x3, newx3, newy2, y3, newy3);
		sierpinski(n-1, newx3, x1, newx1, newy3, y1, newy1);
	}

	/** Creates a canvas for the given image. */
	public static void setCanvas(int height, int width) {
		StdDraw.setTitle("Sierpinski's Triangles");
		StdDraw.setCanvasSize(height, width);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
        // Enables drawing graphics in memory and showing it on the screen only when
		// the StdDraw.show function is called.
		StdDraw.enableDoubleBuffering();
	}
}