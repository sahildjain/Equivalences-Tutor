package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class gui {
	
	private JFrame frame;
	private JPanel buttonsPanel;
	private JButton quit;
	final QuitListener quitListen = new QuitListener();

	public void createGui(int size) {
		frame = new JFrame("Equivalences Tutor");
		frame.setSize(size * 10, size * 20);
		buttonsPanel = new JPanel();
		quit = new JButton("Quit");
		buttonsPanel.add(quit);
		quit.addActionListener(quitListen);
		frame.add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	private class QuitListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
    }
}
