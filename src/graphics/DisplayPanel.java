package graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DisplayPanel extends JPanel {
	
	private Display display;
	
	private double[][][] truckInt;
	private Color[][][] truck;
	private int height, width, depth; //the number of cubes in the x, y and z directions
	
	private static final int D_W = 500;
    private static final int D_H = 500; 
    
    public DisplayPanel(double[][][] truck, int H, int W, int D) {
    	truckInt = truck;
    	height = H;
    	width = W;
    	depth = D;
    	this.truck = new Color[width][height][depth];
    	convertTruck();
    	display = new Display(this.truck, height, width, depth);
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
    
    public void RotateLeft() {
        Color[][][] newTruck = new Color[height][width][depth];
        for (int z = 0; z < depth; z++) {
        	for(int x = 0; x < width; x++) {
        		for (int y = 0; y < height; y++) {
        			newTruck[y][(width - 1) - x][z] = truck[x][y][z];
        		}
        	}
        }
        truck = newTruck;
        int tmp = height;
        height = width;
        width = tmp;
        display.setDims(this.truck, height, width, depth);
        repaint();
    }
    
    public void RotateRight() {
        Color[][][] newTruck = new Color[height][width][depth];
        for (int z = 0; z < depth; z++) {
        	for(int x = 0; x < width; x++) {
        		for (int y = 0; y < height; y++) {
        			newTruck[height - 1 - y][x][z] = truck[x][y][z];
        		}
        	}
        }
        truck = newTruck;
        int tmp = height;
        height = width;
        width = tmp;
        display.setDims(this.truck, height, width, depth);
        repaint();
    }
    
    public void RotateDown() {
        Color[][][] newTruck = new Color[width][depth][height];
        for (int x = 0; x < width; x++) {
        	for(int y = 0; y < height; y++) {
        		for (int z = 0; z < depth; z++) {
        			newTruck[x][z][height - 1 - y] = truck[x][y][z];
        		}
        	}
        }
        truck = newTruck;
        int tmp = height;
        height = depth;
        depth = tmp;
        display.setDims(this.truck, height, width, depth);
        repaint();
    }
    
    public void RotateUp() {
        Color[][][] newTruck = new Color[width][depth][height];
        for (int x = 0; x < width; x++) {
        	for(int y = 0; y < height; y++) {
        		for (int z = 0; z < depth; z++) {
        			newTruck[x][(depth - 1) - z][y] = truck[x][y][z];
        		}
        	}
        }
        truck = newTruck;
        int tmp = height;
        height = depth;
        depth = tmp;
        display.setDims(this.truck, height, width, depth);
        repaint();
    }
    
    public void convertTruck() {
    	for (int x = 0; x < width; x++) {
    		for (int y = 0; y < height; y++) {
    			for (int z = 0; z < depth; z++) {
    				if ((int)truckInt[x][y][z] == 3) truck[x][y][z] = Color.RED;
    				else if ((int)truckInt[x][y][z] == 4) truck[x][y][z] = Color.GREEN;
    				else if ((int)truckInt[x][y][z] == 5) truck[x][y][z] = Color.BLUE;
    				else truck[x][y][z] = Color.GRAY;
    			}
    		}
    	}
    }
    
}
