package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.EquivalencesDb;

import equivalence.EquivalenceLinkNode;
import equivalence.EquivalenceLinkedList;

public class SaveToDbListener implements ActionListener {
	
	private NewPersonalEquivalenceListener listener;
	private EquivalenceLinkedList left;
	private EquivalenceLinkedList right;
	private StringBuilder leftContent;
	private StringBuilder rightContent;
	private int id;
	
	public SaveToDbListener(NewPersonalEquivalenceListener listener, int id) {
		this.setListener(listener);
		this.setLeft(getListener().getLeft());
		this.setRight(getListener().getRight());
		this.id = id;
	}

	public void actionPerformed(ActionEvent arg0) {
		createLeftContent();
		createRightContent();
		EquivalencesDb.addNewEquivalence(getLeftContent(), getRightContent(), this.id);
	}
	
	private void createLeftContent() {
		StringBuilder leftContent = new StringBuilder();
		EquivalenceLinkedList left = getLeft();
		EquivalenceLinkNode curr = left.getHead();
		while(curr != null) {
			leftContent.append(curr.getTree().toString());
			leftContent.append("\\");
			curr = curr.getNext();
		}
		setLeftContent(leftContent);
	}
	
	private void createRightContent() {
		StringBuilder rightContent = new StringBuilder();
		EquivalenceLinkedList right = getRight();
		EquivalenceLinkNode curr = right.getHead();
		while(curr != null) {
			rightContent.append(curr.getTree().toString());
			rightContent.append("\\");
			curr = curr.getNext();
		}
		setRightContent(rightContent);
	}

	public NewPersonalEquivalenceListener getListener() {
		return listener;
	}

	public void setListener(NewPersonalEquivalenceListener listener) {
		this.listener = listener;
	}

	public EquivalenceLinkedList getLeft() {
		return left;
	}

	public void setLeft(EquivalenceLinkedList left) {
		this.left = left;
	}

	public EquivalenceLinkedList getRight() {
		return right;
	}

	public void setRight(EquivalenceLinkedList right) {
		this.right = right;
	}

	public StringBuilder getLeftContent() {
		return leftContent;
	}

	public void setLeftContent(StringBuilder leftContent) {
		this.leftContent = leftContent;
	}

	public StringBuilder getRightContent() {
		return rightContent;
	}

	public void setRightContent(StringBuilder rightContent) {
		this.rightContent = rightContent;
	}

}
