package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import AST.AST;

import eqtutor.PropositionalExpressionGenerator;
import equivalence.EquivalenceLinkNode;
import equivalence.EquivalenceLinkedList;

public class RandomEquivalenceListener implements ActionListener {
	
	private JFrame frame;
	private JPanel menu;
	private int id;
	
	public RandomEquivalenceListener(JFrame frame, JPanel menu, int id) {
		this.setFrame(frame);
		this.setMenu(menu);
		this.setId(id);
	}

	public void actionPerformed(ActionEvent arg0) {
		EasyEquivalence eq = new EasyEquivalence(getFrame(), getMenu(), getId());
		PropositionalExpressionGenerator gen = new PropositionalExpressionGenerator();
		gen.generate();
		AST startState = gen.getStartState();
		AST endState = gen.getEndState();
		EquivalenceLinkedList left = new EquivalenceLinkedList();
		EquivalenceLinkNode start = new EquivalenceLinkNode(left.getSize() + 1, startState, null, null);
		EquivalenceLinkedList right = new EquivalenceLinkedList();
		EquivalenceLinkNode end = new EquivalenceLinkNode(right.getSize() + 1, endState, null, null);
		left.add(start);
		right.add(end);
		eq.getMenu().setVisible(false);
		eq.createButtonsPanel();
		eq.createEquivalencePanel();
		eq.getFrame().add(eq.getEquivalence(), BorderLayout.NORTH);
		eq.getFrame().add(eq.getButtons(), BorderLayout.SOUTH);
		eq.setLeft(left);
		eq.setRight(right);
		eq.updateEquivalenceLeft();
		eq.updateEquivalenceRight();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getMenu() {
		return menu;
	}

	public void setMenu(JPanel menu) {
		this.menu = menu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
