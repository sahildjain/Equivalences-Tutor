package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import AST.AST;

import eqtutor.EQTutor;
import eqtutor.LogicParser;

import net.miginfocom.swing.MigLayout;

public class Gui {
	
	private JFrame frame;
	private JPanel buttons;
	private JPanel inputField;
	private JButton quit;
	private JButton submitStart;
	private JButton states;
	private JTextField startState;
	
	public void createGui(int size) {
		createFrame("Equivalences Tutor", size);
		createButtonsPanel();
		createEquivalencePanel();
		addToFrame();
	}

	private void addToFrame() {
		frame.add(buttons, BorderLayout.SOUTH);
		frame.add(inputField, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private void createEquivalencePanel() {
		inputField = new JPanel(new MigLayout());
		startState = new JTextField(40);
		inputField.add(startState, BorderLayout.NORTH);
		submitStart = new JButton("Submit Start State");
		StartStateSubmitListener startListener = new StartStateSubmitListener(startState);
		submitStart.addActionListener(startListener);
		inputField.add(submitStart, BorderLayout.NORTH);
	}

	private void createButtonsPanel() {
		buttons = new JPanel(new MigLayout());
		
		states = new JButton("New Equivalence");
		
		
		quit = new JButton("Quit");
		QuitListener quitListener = new QuitListener();
		quit.addActionListener(quitListener);
		
		buttons.add(states, BorderLayout.WEST);
		buttons.add(quit, BorderLayout.EAST);
		
	}

	private void createFrame(String string, int size) {
		frame = new JFrame(string);
		frame.setSize(size * 20, size * 20);
	}

}
