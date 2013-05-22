package gui;

import java.awt.BorderLayout;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class Gui {
	
	private JFrame frame;
	private JPanel menu;
	private JButton newEquivalence;
	private JButton quit;
	
	public void createGui(int size) {
		createFrame("Equivalences Tutor", size);
		createMenuPanel();
		addToFrame();
	}

	private void addToFrame() {
		frame.add(menu, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void createMenuPanel() {
		menu = new JPanel(new MigLayout());
		newEquivalence = new JButton("New Personal Equivalence");
		NewPersonalEquivalenceListener listener = new NewPersonalEquivalenceListener(frame, menu);
		newEquivalence.addActionListener(listener);
		quit = new JButton("Quit");
		QuitListener quitListener = new QuitListener();
		quit.addActionListener(quitListener);
		menu.add(newEquivalence, BorderLayout.CENTER);
	}

	private void createFrame(String string, int size) {
		frame = new JFrame(string);
		frame.setSize(size * 50, size * 40);
	}

}
