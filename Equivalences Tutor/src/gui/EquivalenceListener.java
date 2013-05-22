package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import AST.AST;

import eqtutor.EQTutor;
import eqtutor.LogicParser;
import equivalence.EquivalenceLinkNode;
import equivalence.EquivalenceLinkedList;

public class EquivalenceListener implements ActionListener{
	
	private NewPersonalEquivalenceListener listener;
	private EquivalenceLinkedList list;
	private String eq;

	public EquivalenceListener(NewPersonalEquivalenceListener listener, String eq) {
		this.setListener(listener);
		this.setEq(eq);
		if(eq.equals("LEFT")) {
			this.setList(getListener().getLeft());
		}
		if(eq.equals("RIGHT")) {
			this.setList(getListener().getRight());
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(eq.equals("LEFT")) {
			left();
		}
		if(eq.equals("RIGHT")) {
			right();
		}
	}
	
	private void left() {
		EQTutor eqtutor = new EQTutor();
		LogicParser parser = eqtutor.getParser(getListener().getTextFieldLeft().getText());
		AST tree = eqtutor.getTree(parser);
		EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getLeft().getSize() + 1, tree, null, null);
		getListener().updateLeftList(node);
		getListener().updateEquivalenceLeft();
		getListener().getTextFieldLeft().setText("");
	}
	
	private void right() {
		EQTutor eqtutor = new EQTutor();
		LogicParser parser = eqtutor.getParser(getListener().getTextFieldRight().getText());
		AST tree = eqtutor.getTree(parser);
		EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getRight().getSize() + 1, tree, null, null);
		getListener().updateRightList(node);
		getListener().updateEquivalenceRight();
		getListener().getTextFieldRight().setText("");
	}

	public void setList(EquivalenceLinkedList list) {
		this.list = list;
	}

	public EquivalenceLinkedList getList() {
		return this.list;
	}

	public NewPersonalEquivalenceListener getListener() {
		return listener;
	}

	public void setListener(NewPersonalEquivalenceListener listener) {
		this.listener = listener;
	}

	public String getEq() {
		return eq;
	}

	public void setEq(String eq) {
		this.eq = eq;
	}

}
