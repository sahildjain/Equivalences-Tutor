package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import eqtutor.EQTutor;
import eqtutor.LogicParser;
import equivalence.EquivalenceLinkNode;

import AST.AST;

public class StatesInputDialogListener implements ActionListener{
	
	private String startState;
	private String endState;
	private AST startTree;
	private AST endTree;
	private NewPersonalEquivalenceListener listener;

	public StatesInputDialogListener(NewPersonalEquivalenceListener listener) {
		this.setListener(listener);
	}

	public void actionPerformed(ActionEvent e) {
		String startState = JOptionPane.showInputDialog("Enter Start State");
		String endState = JOptionPane.showInputDialog("Enter End State");
		setStartState(startState);
		setEndState(endState);
		updateLists();
		getListener().updateEquivalenceLeft();
		getListener().updateEquivalenceRight();
	}

	private void updateLists() {
		getListener().updateLeftList(new EquivalenceLinkNode(1, getStartTree(), null, null));
		getListener().updateRightList(new EquivalenceLinkNode(1, getEndTree(), null, null));
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

	public NewPersonalEquivalenceListener getListener() {
		return listener;
	}

	public void setListener(NewPersonalEquivalenceListener listener) {
		this.listener = listener;
	}
	
}
