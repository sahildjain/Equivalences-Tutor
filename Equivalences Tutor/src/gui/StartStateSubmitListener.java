package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import AST.AST;
import eqtutor.EQTutor;
import eqtutor.LogicParser;

public class StartStateSubmitListener implements ActionListener {
	
	private JTextField startState;
	
	public StartStateSubmitListener(JTextField startState) {
		this.startState = startState;
	}
	
	public void actionPerformed(ActionEvent event) {
		String text = startState.getText();
		EQTutor eqtutor = new EQTutor();
		LogicParser parser = eqtutor.getParser(text);
		AST tree = eqtutor.getTree(parser);
		eqtutor.printTreeToConsole(tree);
	}

}
