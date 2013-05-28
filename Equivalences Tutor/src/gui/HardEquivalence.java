package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import equivalence.EquivalenceLinkNode;
import equivalence.EquivalenceLinkedList;

import net.miginfocom.swing.MigLayout;

public class HardEquivalence extends NewPersonalEquivalenceListener {
	
	private JTextArea textAreaLeft;
	private JTextArea textAreaRight;

	public HardEquivalence(JFrame frame, JPanel menu) {
		super(frame, menu);
	}
	
	protected void createEquivalencePanel() {
		equivalence = new JPanel(new MigLayout());
		JPanel left = new JPanel(new MigLayout());
		JPanel centre = new JPanel(new MigLayout());
		JPanel right = new JPanel(new MigLayout());
		textAreaLeft = new JTextArea(20, 100);
		textAreaLeft.setEditable(false);
		textAreaRight = new JTextArea(20, 100);
		textAreaRight.setEditable(false);
		textFieldLeft = new JTextField(60);
		textFieldRight = new JTextField(60);
		submitLeft = new JButton("Submit");
		leftListener = new EquivalenceListener(this, "LEFT");
		submitLeft.addActionListener(leftListener);
		undoLeft = new JButton("Undo");
		undoLeftListener = new UndoListener(this, "LEFT");
		undoLeft.addActionListener(undoLeftListener);
		submitRight = new JButton("Submit");
		rightListener = new EquivalenceListener(this, "RIGHT");
		submitRight.addActionListener(rightListener);
		undoRight = new JButton("Undo");
		undoRightListener = new UndoListener(this, "RIGHT");
		undoRight.addActionListener(undoRightListener);
		left.add(textAreaLeft, BorderLayout.NORTH);
		left.add(textFieldLeft, BorderLayout.WEST);
		left.add(submitLeft, BorderLayout.EAST);
		left.add(undoLeft, BorderLayout.EAST);
		right.add(textAreaRight, BorderLayout.NORTH);
		right.add(textFieldRight, BorderLayout.WEST);
		right.add(submitRight, BorderLayout.EAST);
		right.add(undoRight, BorderLayout.EAST);
		equivalence.add(left, BorderLayout.WEST);
		equivalence.add(centre);
		equivalence.add(right, BorderLayout.EAST);
	}
	
	public void updateEquivalenceLeft() {
		JTextArea textArea = getTextAreaLeft();
		textArea.setText("");
		EquivalenceLinkedList list = getLeft();
		EquivalenceLinkNode curr = list.getHead();
		while(curr != null) {
			textArea.append(curr.getLineNumber() + "\t" + curr.getTree().toString());
			textArea.append("\n");
			curr = curr.getNext();
		}
		setTextAreaLeft(textArea);
		if(getLeft().getLast().getTree().toString().equals(getRight().getLast().getTree().toString())) {
			completeEquivalence();
		}
	}
	
	public void updateEquivalenceRight() {
		JTextArea textArea = getTextAreaRight();
		textArea.setText("");
		EquivalenceLinkedList list = getRight();
		EquivalenceLinkNode curr = list.getHead();
		while(curr != null) {
			textArea.append(curr.getLineNumber() + "\t" + curr.getTree().toString());
			textArea.append("\n");
			curr = curr.getNext();
		}
		setTextAreaRight(textArea);
		if(getRight().getLast().getTree().toString().equals(getLeft().getLast().getTree().toString())) {
			completeEquivalence();
		}
	}
	
	protected void completeEquivalence() {
		textFieldLeft.setVisible(false);
		textFieldRight.setVisible(false);
		submitLeft.setVisible(false);
		submitRight.setVisible(false);
	}
	
	public JTextArea getTextAreaLeft() {
		return this.textAreaLeft;
	}
	
	public void setTextAreaLeft(JTextArea left) {
		this.textAreaLeft = left;
	}
	
	public JTextArea getTextAreaRight() {
		return this.textAreaRight;
	}
	
	public void setTextAreaRight(JTextArea right) {
		this.textAreaRight = right;
	}

	protected void hidePanels() {
		getSubmitLeft().setVisible(false);
		getSubmitRight().setVisible(false);
		getTextAreaLeft().setVisible(false);
		getTextAreaRight().setVisible(false);
		getTextFieldLeft().setVisible(false);
		getTextFieldRight().setVisible(false);
		getButtons().setVisible(false);
	}
	

}
