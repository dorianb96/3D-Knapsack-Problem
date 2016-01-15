package graphics;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import part1ab.Application;
import part1ab.Truck;
import part2ab.Application2;
import part2ab.Board;
import part2b.Application3;
import part2b.Pento3DTruck;


public class FinalFrame {
	
	private int W = 33;
	private int H = 5;
	private int D = 8;
	
	private double[][][] truck = new double[W][H][D];
	private JFrame finalFrame = new JFrame("Results");
	private DisplayPanel DisplayPanel;
	private int score;
	
	public FinalFrame(int algoType, double timeLimit, int combinationLimit) {
		System.out.println(timeLimit);
		System.out.println(timeLimit);
		if (algoType == 0) {
			GreedyAlgorithmStandard algo = new GreedyAlgorithmStandard();
			score = algo.getGreedy(truck);
		} else if (algoType == 1) {
			GreedyAlgorithmPento algo = new GreedyAlgorithmPento();
			score = algo.getGreedy(truck);
		} else if (algoType == 2) {
			timeLimit =5;
			Application app = new Application();
			if(timeLimit != 0.0d) {
				app.setTimeLimit(timeLimit);
			}
			if(combinationLimit != 0) {
				app.setTimeLimit(combinationLimit);
			}
			app.fillTruck(new Truck());
			truck = app.getMostFilledTruck().getCargoSpace();
			score = app.getMostFilledTruck().truckValue();
			W = 5;
			H = 8;
			D = 33;
		} else if (algoType == 3) {
			Application app = new Application();
			app.setTimeLimit(10);
			app.greedyFillTruck(new Truck());
			truck = app.getMostValuableTruck().getCargoSpace();
			score = app.getMostValuableTruck().truckValue();
			W = 5;
			H = 8;
			D = 33;
		} else if (algoType == 4) {
			Application app = new Application();
			app.setCombinationLimit(50000);
			app.greedyFillTruck(new Truck());
			truck = app.getMostValuableTruck().getCargoSpace();
			score = app.getMostValuableTruck().truckValue();
			W = 5;
			H = 8;
			D = 33;
		} else if (algoType == 5) {
			Application3 app = new Application3();
			app.setTimeLimit(10);
			app.fillTruck(new Pento3DTruck());
			//truck = app.getMostValuableTruck().getCargoSpace();
			//score = app.get().truckValue();
			W = 5;
			H = 8;
			D = 33;
		} else if (algoType == 6) {
			Application2 app = new Application2();
			app.setTimeLimit(10);
			app.boardFill(new Board());
			truck = app.createValuableTruck().getCargoSpace();
			W = 5;
			H = 8;
			D = 33;
		} else if (algoType == 7) {
			Application2 app = new Application2();
			app.setCombinationLimit(50000);
			app.boardFill(new Board());
			//truck = app
			//score = app.getMostFilledTruck().truckValue();
			W = 5;
			H = 8;
			D = 33;

		} else if (algoType == 8) {
			Application3 app = new Application3();
			app.setTimeLimit(10);
			app.fillTruck(new Pento3DTruck());
			//truck = app
			//score = app.getMostFilledTruck().truckValue();
			W = 5;
			H = 8;
			D = 33;
		} else if (algoType == 9) {
			Application3 app = new Application3();
			app.setCombinationLimit(50000);
			app.fillTruck(new Pento3DTruck());
			//truck = app
			//score = app.getMostFilledTruck().truckValue();
			W = 5;
			H = 8;
			D = 33;
		}
		
		finalFrame.setLayout(new BorderLayout());
		finalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DisplayPanel = new DisplayPanel(truck, H, W, D);
		JPanel BotPanel = createBotPanel(score);
		JPanel TopPanel = createTopPanel();
		JPanel RightPanel = createRightPanel();
		JPanel LeftPanel = createLeftPanel();
		JPanel CentrePanel = new JPanel ();
		CentrePanel.add(LeftPanel, BorderLayout.WEST);
		CentrePanel.add(DisplayPanel, BorderLayout.CENTER);
		CentrePanel.add(RightPanel, BorderLayout.EAST);
		finalFrame.add(BotPanel, BorderLayout.SOUTH);
		finalFrame.add(CentrePanel, BorderLayout.CENTER);
		finalFrame.add(TopPanel, BorderLayout.NORTH);
		finalFrame.pack();
		finalFrame.setLocationRelativeTo(null);
		finalFrame.setVisible(true);
	}
	
	public JPanel createBotPanel(int score) {
		JPanel botPanel = new JPanel();
		JLabel scoreLbl = new JLabel("Score: " + Integer.toString(score));
		JButton rotateDown = new JButton("Rotate Down");
		class down implements ActionListener {
	    	public void actionPerformed(ActionEvent event) {
	    		DisplayPanel.RotateDown();
	    	}
	    }
		rotateDown.addActionListener(new down());
		JButton home = new JButton("Homepage");
		class home implements ActionListener {
	    	public void actionPerformed(ActionEvent event) {
	    		finalFrame.setVisible(false);
	    		MainFrame newFrame = new MainFrame();
	    	}
	    }
		home.addActionListener(new home());
		botPanel.add(rotateDown);
		botPanel.add(scoreLbl);
		botPanel.add(home);
		return botPanel;
	}
	
	public JPanel createTopPanel() {
		JPanel topPanel = new JPanel();
		JButton rotateUp = new JButton("Rotate Up");
		class up implements ActionListener {
	    	public void actionPerformed(ActionEvent event) {
	    		DisplayPanel.RotateUp();
	    	}
	    }
		rotateUp.addActionListener(new up());
		topPanel.add(rotateUp);
		return topPanel;
	}
	
	public JPanel createRightPanel() {
		JPanel rightPanel = new JPanel();
		JButton rotateRight = new JButton("Rotate Right");
		class right implements ActionListener {
	    	public void actionPerformed(ActionEvent event) {
	    		DisplayPanel.RotateRight();
	    	}
	    }
		rotateRight.addActionListener(new right());
		rightPanel.add(rotateRight);
		return rightPanel;
	}
	
	public JPanel createLeftPanel() {
		JPanel leftPanel = new JPanel();
		JButton rotateLeft = new JButton("Rotate Left");
		class left implements ActionListener {
	    	public void actionPerformed(ActionEvent event) {
	    		DisplayPanel.RotateLeft();
	    	}
	    }
		rotateLeft.addActionListener(new left());
		leftPanel.add(rotateLeft);
		return leftPanel;
	}
	
}
