import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DisplayPanel extends JPanel {
	
	private Display display;
	
	private double[][][] truckInt;
	private Color[][][] truckNew;
	private int height, width, depth; //the number of cubes in the x, y and z directions
	
	private static final int D_W = 500;
    private static final int D_H = 500; 
    
    public DisplayPanel(double[][][] truck) {
    	truckInt = truck;
    	height = truck[0].length;
    	width = truck.length;
    	depth = truck[0][0].length;
    	truckNew = new Color[width][height][depth];
    	convertTruck();
    	display = new Display(truckNew, height, width, depth);
    	repaint();
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // paints the cube component
        display.draw(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H); // sets the dimensions
    }
    
    public void convertTruck() {
    	for (int x = 0; x < truckInt.length; x++) {
    		for (int y = 0; y < truckInt[0].length; y++) {
    			for (int z = 0; z < truckInt[0][0].length; z++) {
					if (truckInt[x][y][z] == 1.01) {
						truckNew[x][y][z] = Color.GREEN;
					}
					else if (truckInt[x][y][z] == 1.02) {
						truckNew[x][y][z] = Color.red;
					}
					else if (truckInt[x][y][z] == 1.03) {
						truckNew[x][y][z] = Color.YELLOW;
					}
					else if (truckInt[x][y][z] == 3.01) {
						truckNew[x][y][z] = Color.BLUE;
					}
					else if (truckInt[x][y][z] == 2.01) {
						truckNew[x][y][z] = Color.CYAN;
					}
					else if (truckInt[x][y][z] == 2.02) {
						truckNew[x][y][z] = Color.orange;
					}
					else if (truckInt[x][y][z] == 2.03) {
						truckNew[x][y][z] = Color.MAGENTA;
					}
					else if (truckInt[x][y][z] == 2.04) {
						truckNew[x][y][z] = Color.BLACK;
					}
					else if (truckInt[x][y][z] == 2.05) {
						truckNew[x][y][z] = Color.ORANGE;
					}
					else if (truckInt[x][y][z] == 2.06) {
						truckNew[x][y][z] = Color.PINK;
					}


				}
    		}
    	}
    }
    
}
