package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import equivalence.EquivalenceLinkedList;

public class UndoListener implements ActionListener {
	
	private NewPersonalEquivalenceListener listener;
	private String side;

	public UndoListener(NewPersonalEquivalenceListener listener, String side) {
		this.setListener(listener);
		this.setSide(side);
	}

	public void actionPerformed(ActionEvent e) {
		if(getSide().equals("LEFT")) {
			undoLeft();
		}
		else {
			undoRight();
		}
	}

	private void undoRight() {
		EquivalenceLinkedList list = getListener().getRight();
		list.removeLast();
		getListener().updateEquivalenceRight();
	}

	private void undoLeft() {
		EquivalenceLinkedList list = getListener().getLeft();
		list.removeLast();
		getListener().updateEquivalenceLeft();
	}

	public NewPersonalEquivalenceListener getListener() {
		return listener;
	}

	public void setListener(NewPersonalEquivalenceListener listener) {
		this.listener = listener;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}
	
}
