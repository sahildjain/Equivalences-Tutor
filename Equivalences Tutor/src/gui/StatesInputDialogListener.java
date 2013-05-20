package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import eqtutor.EQTutor;
import eqtutor.LogicParser;

import AST.AST;

public class StatesInputDialogListener implements ActionListener{
	
	private String startState;
	private String endState;
	private AST startTree;
	private AST endTree;
	private LinkedList<String> attempt;
	private JTextArea textArea;

	public StatesInputDialogListener(JTextArea textArea, LinkedList<String> attempt) {
		this.setAttempt(attempt);
		this.setTextArea(textArea);
	}

	public void actionPerformed(ActionEvent e) {
		String startState = JOptionPane.showInputDialog("Enter Start State");
		String endState = JOptionPane.showInputDialog("Enter End State");
		setStartState(startState);
		setEndState(endState);
		updateAttempt(getStartState(), getEndState());
		updateEquivalence();
	}

	private void updateEquivalence() {
		JTextArea textArea = getTextArea();
		LinkedList<String> list = getAttempt();
		for(String s : list) {
			textArea.append(s);
			textArea.append("\n");
		}
	}

	private void updateAttempt(String startState, String endState) {
		attempt.addFirst(startState);
		attempt.addLast(endState);
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
		this.startState = this.startTree.toString();
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
		LogicParser parser = eqtutor.getParser(getEndState());
		AST tree = eqtutor.getTree(parser);
		this.endTree = tree;
		this.endState = this.endTree.toString();
	}

	public LinkedList<String> getAttempt() {
		return attempt;
	}

	public void setAttempt(LinkedList<String> attempt) {
		this.attempt = attempt;
	}

	public JTextArea getTextArea() {
		return this.textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	
}
