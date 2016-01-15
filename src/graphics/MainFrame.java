package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame{
	private JFrame mainFrame = new JFrame("Homepage");
	
	public MainFrame() {
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel titlePanel = CreateTitlePanel(); // the top panel of the frame, which will have the title
		JPanel imagePanel = CreateImagePanel(); // the middle of the frame, which will have a picture of the university's logo
		JPanel buttonsPanel = CreateButtonsPanel(); // the bottom of the frame, which will have a combo box and a button to run the selected algo
		mainFrame.add(titlePanel, BorderLayout.NORTH);
		mainFrame.add(imagePanel, BorderLayout.CENTER);
		mainFrame.add(buttonsPanel, BorderLayout.SOUTH);
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
	
	public JPanel CreateTitlePanel() { // creates a panel with a custom text
		JPanel titlePanel = new JPanel();
		titlePanel.setPreferredSize(new Dimension(400, 100));
		JLabel titleLabel = new JLabel("Knapsack Solver");
		titleLabel.setFont(new Font("Serif", Font.BOLD, 50));
		titlePanel.add(titleLabel);
		return titlePanel;
	}
	
	public JPanel CreateImagePanel() { //  creates a panel with an image in it
		JPanel imagePanel = new JPanel();
		imagePanel.setPreferredSize(new Dimension(400, 250));
		JLabel imageLabel = new JLabel(new ImageIcon("logo.png"));
		imagePanel.add(imageLabel);
		return imagePanel;
	}
	
	public JPanel CreateButtonsPanel() { // creates a panel with a combo box and a button in it
		String[] algoTypes = {"Greedy Algo Standard", "Greedy Algo Pento", "Backtracking Standard Fill", "BackTracking Standard Time", "Backtracking Standard Combos",
							  "BackTracking Pento Fill" , "BackTracking Pento 2D Time", "BackTracking Pento 2D Combos", "BackTracking Pento 3D Time", "Backtracking Pento 3D Combos"};
		// an array with all the different types of algos we have
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setPreferredSize(new Dimension(400, 70));
		JRadioButton radioButton1 = new JRadioButton("Time",false);
		JRadioButton radioButton2 = new JRadioButton("Combinations",false);
		JComboBox algoList = new JComboBox(algoTypes);
		algoList.setSelectedIndex(0);
		JButton button = new JButton("Run Algoirthm");
		class algoStart implements ActionListener {
	    	public void actionPerformed(ActionEvent event) {
	    		mainFrame.setVisible(false);
	    		FinalFrame finalFrame = new FinalFrame(algoList.getSelectedIndex()); // creates the final frame using the index of the selected algo
	    	}
	    }
		button.addActionListener(new algoStart());
		buttonsPanel.add(radioButton1);
		buttonsPanel.add(radioButton2);
		buttonsPanel.add(algoList); buttonsPanel.add(button);
		return buttonsPanel;
	}
}
