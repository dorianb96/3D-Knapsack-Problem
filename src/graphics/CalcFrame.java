package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CalcFrame {
	
	private JFrame frame;
	private JLabel comboLabel, timeLabel;
	private int timeCtr = 0;
	MyTimer timerTask = new MyTimer();
	Timer timer = new Timer(1000, timerTask);
	
	public CalcFrame() {
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel calcPanel = createCalcPanel();
		JPanel comboPanel = createComboPanel();
		JPanel timerPanel = createTimePanel();
		frame.add(calcPanel, BorderLayout.NORTH);
		frame.add(comboPanel, BorderLayout.CENTER);
		frame.add(timerPanel, BorderLayout.SOUTH);
		frame.pack();
		frame.revalidate();
		frame.setVisible(true);
	}
	
	public JPanel createCalcPanel() {
		JPanel calcPanel = new JPanel();
		calcPanel.setPreferredSize(new Dimension(200, 30));
		JLabel calcLabel = new JLabel("Calculating...");
		calcPanel.add(calcLabel);
		return calcPanel;
	}
	
	public JPanel createComboPanel() {
		JPanel comboPanel = new JPanel();
		comboPanel.setPreferredSize(new Dimension(200, 30));
		comboLabel = new JLabel("0");
		comboPanel.add(comboLabel);
		return comboPanel;
	}
	
	public JPanel createTimePanel() {
		JPanel timePanel = new JPanel();
		timePanel.setPreferredSize(new Dimension(200, 30));
		timeLabel = new JLabel("0");
		timePanel.add(timeLabel);
		timer.start();
		return timePanel;
	}
	
	public void updateCombos(int ctr) {
		comboLabel.setText(Integer.toString(ctr));
	}
	
	public void hideFrame() {
		timer.stop();
		frame.setVisible(false);
	}
	
	class MyTimer implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			timeCtr++;
			timeLabel.setText(Integer.toString(timeCtr));
		}
	}
}
