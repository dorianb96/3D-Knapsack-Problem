import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FinalFrame {
	
	private final static int W = 5;
	private final static int H = 8;
	private final static int D = 33;
	
	private int[][][] truck = new int[W][H][D];
	private JFrame finalFrame = new JFrame("Results");
	
	public FinalFrame() {
		Application app = new Application();
		app.fillTruck(new Truck(),1);
		Truck mostValuableTruck = app.getMostFilledTruck();

		int score = mostValuableTruck.truckValue();
		finalFrame.setLayout(new BorderLayout());
		finalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel DisplayPanel = new DisplayPanel(mostValuableTruck.getCargoSpace());
		System.out.println(mostValuableTruck.truckValue());
		System.out.println(app.getSolutionCounter());
		finalFrame.add(DisplayPanel, BorderLayout.CENTER);
		finalFrame.pack();
		finalFrame.setLocationRelativeTo(null);
		finalFrame.setVisible(true);
		
	}
	
}
