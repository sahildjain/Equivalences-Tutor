package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import AST.AST;
import AST.ASTProgramNode;
import AST.ASTPropositionalBinaryNode;
import AST.ASTPropositionalNode;

import eqtutor.EQTutor;
import eqtutor.LogicParser;
import equivalence.EquivalenceLinkNode;
import equivalence.EquivalenceLinkedList;
import equivalence.NodeEquivalence;

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
		AST last = getListener().getLeft().getLast().getTree();
		boolean comparison = compare(last, tree);
		if(comparison) {
			EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getLeft().getSize() + 1, tree, null, null);
			getListener().updateLeftList(node);
			getListener().updateEquivalenceLeft();
			getListener().getTextFieldLeft().setText("");
		}
	}
	
	private void right() {
		EQTutor eqtutor = new EQTutor();
		LogicParser parser = eqtutor.getParser(getListener().getTextFieldRight().getText());
		AST tree = eqtutor.getTree(parser);
		AST last = getListener().getRight().getLast().getTree();
		boolean comparison = compare(last, tree);
		if(comparison) {
			EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getRight().getSize() + 1, tree, null, null);
			getListener().updateRightList(node);
			getListener().updateEquivalenceRight();
			getListener().getTextFieldRight().setText("");
		}
	}
	
	/*
	 * TODO
	 */
	private boolean compare(AST tree1, AST tree2) {
		ASTPropositionalNode node1 = tree1.getRoot().getLeaf();
		ASTPropositionalNode node2 = tree2.getRoot().getLeaf();
		NodeEquivalence eq = new NodeEquivalence(node1, node2);
		if(eq.isEquivalent()) {
			return true;
		}
		if(node1 instanceof ASTPropositionalBinaryNode && node2 instanceof ASTPropositionalBinaryNode) {
			ASTPropositionalBinaryNode binary1 = (ASTPropositionalBinaryNode) node1;
			ASTPropositionalBinaryNode binary2 = (ASTPropositionalBinaryNode) node2;
			AST temp1 = new AST(tree1.getKey(), null);
			//ASTProgramNode program1 = new ASTProgramNode(key, doubleConditional)
		}
		return false;
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
