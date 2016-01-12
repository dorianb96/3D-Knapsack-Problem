import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame{
	private JFrame mainFrame = new JFrame("Homepage");
	
	public MainFrame() {
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel titlePanel = CreateTitlePanel();
		JPanel imagePanel = CreateImagePanel();
		JPanel buttonsPanel = CreateButtonsPanel();
		mainFrame.add(titlePanel, BorderLayout.NORTH);
		mainFrame.add(imagePanel, BorderLayout.CENTER);
		mainFrame.add(buttonsPanel, BorderLayout.SOUTH);
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
	
	public JPanel CreateTitlePanel() {
		JPanel titlePanel = new JPanel();
		titlePanel.setPreferredSize(new Dimension(400, 100));
		JLabel titleLabel = new JLabel("Knapsack Solver");
		titleLabel.setFont(new Font("Serif", Font.BOLD, 50));
		titlePanel.add(titleLabel);
		return titlePanel;
	}
	
	public JPanel CreateImagePanel() {
		JPanel imagePanel = new JPanel();
		imagePanel.setPreferredSize(new Dimension(400, 250));
		JLabel imageLabel = new JLabel(new ImageIcon("logo.png"));
		imagePanel.add(imageLabel);
		return imagePanel;
	}
	
	public JPanel CreateButtonsPanel() {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setPreferredSize(new Dimension(400, 70));
		JButton button1 = new JButton("Greedy Algoirthm Standard");
		class GAS implements ActionListener {
	    	public void actionPerformed(ActionEvent event) {
	    		mainFrame.setVisible(false);
	    		FinalFrame finalFrame = new FinalFrame();
	    	}
	    }
		button1.addActionListener(new GAS());
		JButton button2 = new JButton("BackTracking Standard");
		JButton button3 = new JButton("Greedy Algoirthm Pento");
		JButton button4 = new JButton("BackTracking Pento");
		buttonsPanel.add(button1);buttonsPanel.add(button2);
		buttonsPanel.add(button3);buttonsPanel.add(button4);
		return buttonsPanel;
	}
}
