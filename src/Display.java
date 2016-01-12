import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class Display {
	
	private Color[][][] truck;
	private int height, width, depth; //the number of cubes in the x, y and z directions
	
	private Point[] cubeOnePoints; // hold points for the first square for non coloured grids
    private Point[] cubeTwoPoints; // hold points for the second square for non coloured grids
    private Polygon roof; // holds the polygon for the roof of the shape
    private Polygon side; // holds the polygon for the side of the shape
    
	final int size = 12; // the height and width of one cube
	final int shift = (int)(size / 2); // the perceived depth of the cube
	final int x = 10; // the starting x coordinate
	final int y = 10; // the starting y coordinate
	
	public Display(Color[][][] truck, int H, int W, int D) {
		this.truck = truck;
		height = H;
		width = W;
		depth = D;
	}
	
	public void draw(Graphics g) {
		for (int k = 0; k < depth; k++) { // depth first, starting at the back
        	for (int i = 0; i < width; i++) {
        		for (int j = 0; j < height; j++) {
        			roof = getRoofPoly(i, k);
		        	side = getSidePoly(j, k);
		        	g.setColor(truck[i][j][k]);
		        	g.fillRect(x + (shift * k) + shift + (size * i), y + (shift * k) + shift + (size * j), size, size);
		            g.setColor(Color.BLACK);
		            g.drawRect(x + (shift * k) + shift + (size * i), y + (shift * k) + shift + (size * j), size, size);
		            if (j == 0) { // if on the top row, draw the roof
			        	g.setColor(truck[i][j][k]);
			            g.fillPolygon(roof);
			            g.setColor(Color.BLACK);
			            g.drawPolygon(roof);
		            }
		            if (i == 0) { // if in the left column, draw the side
			        	g.setColor(truck[i][j][k]);
			            g.fillPolygon(side);
			            g.setColor(Color.BLACK);
			            g.drawPolygon(side);
		            }
        		}
        	}
		}
	}
	
	 private Polygon getRoofPoly(int i, int k) { //gets points for roof of cube
	        int newX = x + shift;
	        int newY = y + shift;
	        Polygon roof = new Polygon();
	        roof.addPoint(x + (size * i) + (shift * k), y + (shift * k));
	        roof.addPoint(x + size + (size * i) + (shift * k), y + (shift * k));
	        roof.addPoint(newX + size + (size * i) + (shift * k), newY + (shift * k));
	        roof.addPoint(newX + (size * i) + (shift * k), newY + (shift * k));
	        return roof;
	    }
	    
	    private Polygon getSidePoly(int j, int k) { // gets points for side of cube
	        int newX = x + shift;
	        int newY = y + shift;
	        Polygon side = new Polygon();
	        side.addPoint(x + (shift * k), y + (size * j) + (shift * k));
	        side.addPoint(x + (shift * k), y + size + (size * j) + (shift * k));
	        side.addPoint(newX + (shift * k), newY + size + (size * j) + (shift * k));
	        side.addPoint(newX + (shift * k), newY + (size * j) + (shift * k));
	        return side;
	    }
}
