/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		int height = 800;
		int width = 800;
		setCanvas(height, width);
		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.
		
        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		*/
		//curve(5,100,100,400,100);
		snowFlake(4);

		StdDraw.show();
	}

	//sets the stage for the main function
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if(n == 1)
			StdDraw.line(x1, y1, x2, y2);
		else
			curve(1, n-1, x1, y1, x2, y2);
	}
	
	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int marker, int n, double x1, double y1, double x2, double y2) {

		double xstart1 = x1, xend1 = (2 * x1 + x2)/3, ystart1 = y1, yend1 = (2 * y1 + y2)/3;
		double xstart2 = xend1, xend2 = (x1 + 2 * x2)/3, ystart2 = yend1, yend2 = (y1 + 2 * y2)/3;
		double xstart3 = xend2, xend3 = x2, ystart3 = yend2, yend3 = y2;
		
		/** a failed attempt to calculate the triangle's peak by myself (and not use the given equation)
		
		double fullLength = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
		double segmentLength = fullLength / 3;
		double angle = Math.PI/3.0 + Math.sinh((y2 - y1) / fullLength);
		
		double xpeak = xstart2 + segmentLength * Math.cos(angle);
		double ypeak = ystart2 + segmentLength * Math.sin(angle);
		*/

		double xpeak = (ystart1 - yend3) * (Math.sqrt(3) / 6) + 0.5 * (xstart1 + xend3);
		double ypeak = (xend3 - xstart1) * (Math.sqrt(3) / 6) + 0.5 * (ystart1 + yend3);

		if(n == 1) {
			StdDraw.line(xstart1, ystart1, xend1, yend1);
			StdDraw.line(xstart2, ystart2, xpeak, ypeak);
			StdDraw.line(xpeak, ypeak, xend2, yend2);
			StdDraw.line(xstart3, ystart3, xend3, yend3);
			return;
		}

		curve(1, n-1, xstart1, ystart1, xend1, yend1);
		curve(1, n-1, xstart2, ystart2, xpeak, ypeak);
		curve(1, n-1, xpeak, ypeak, xend2, yend2);
		curve(1, n-1, xstart3, ystart3, xend3, yend3);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		//StdDraw.setYscale(0, 1.1);
		//StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		curve(6,100,600,700,600);
		curve(6,700,600,400,100);
		curve(6,400,100,100,600);
	}

	/** Creates a canvas for the given image. */
	public static void setCanvas(int height, int width) {
		StdDraw.setTitle("Koch's Snowflake");
		StdDraw.setCanvasSize(height, width);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
        // Enables drawing graphics in memory and showing it on the screen only when
		// the StdDraw.show function is called.
		StdDraw.enableDoubleBuffering();
	}
}
