package gui;

import java.awt.BorderLayout;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class Gui {
	
	private JFrame frame;
	
	private JPanel menu;
	
	private JButton hardEquivalence;
	private JButton easyEquivalence;
	private JButton quit;
	private JButton loadEquivalence;
	
	public void createGui(int size) {
		createFrame("Equivalences Tutor", size);
		createMenuPanel();
		addToFrame();
	}

	private void addToFrame() {
		frame.add(menu, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void createMenuPanel() {
		menu = new JPanel(new MigLayout());
		hardEquivalence = new JButton("Hard Personal Equivalence");
		HardEquivalence listener = new HardEquivalence(frame, menu);
		hardEquivalence.addActionListener(listener);
		easyEquivalence = new JButton("Easy Personal Equivalence");
		EasyEquivalence easyListener = new EasyEquivalence(frame, menu);
		easyEquivalence.addActionListener(easyListener);
		loadEquivalence = new JButton("Load Equivalence From File");
		LoadEquivalenceListener loadListener = new LoadEquivalenceListener(loadEquivalence);
		loadEquivalence.addActionListener(loadListener);
		quit = new JButton("Quit");
		QuitListener quitListener = new QuitListener();
		quit.addActionListener(quitListener);
		menu.add(easyEquivalence, BorderLayout.NORTH);
		menu.add(hardEquivalence, BorderLayout.NORTH);
		menu.add(loadEquivalence, BorderLayout.NORTH);
		menu.add(quit, BorderLayout.SOUTH);
	}

	private void createFrame(String string, int size) {
		frame = new JFrame(string);
		frame.setSize(size * 50, size * 40);
	}

}
