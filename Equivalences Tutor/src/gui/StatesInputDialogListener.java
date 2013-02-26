package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import eqtutor.EQTutor;
import eqtutor.LogicParser;

import AST.AST;

public class StatesInputDialogListener implements ActionListener{
	
	private String startState;
	private String endState;
	private AST startTree;
	private AST endTree;

	public void actionPerformed(ActionEvent arg0) {
		String startState = JOptionPane.showInputDialog("Enter Start State");
		String endState = JOptionPane.showInputDialog("Enter End State");
		setStartState(startState);
		setEndState(endState);
	}

	public String getStartState() {
		return startState;
	}

	public void setStartState(String startState) {
		this.startState = startState;
		setStartTree();
	}
	
	public AST getStartTree() {
		return this.startTree;
	}

	private void setStartTree() {
		EQTutor eqtutor = new EQTutor();
		LogicParser parser = eqtutor.getParser(getStartState());
		AST tree = eqtutor.getTree(parser);
		this.startTree = tree;
	}

	public String getEndState() {
		return endState;
	}

	public void setEndState(String endState) {
		this.endState = endState;
		setEndTree();
	}
	
	public AST getEndTree() {
		return this.endTree;
	}
	
	private void setEndTree() {
		EQTutor eqtutor = new EQTutor();
		LogicParser parser = eqtutor.getParser(getStartState());
		AST tree = eqtutor.getTree(parser);
		this.endTree = tree;
	}
	
}
