package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import equivalence.EquivalenceLinkNode;
import equivalence.EquivalenceLinkedList;

import net.miginfocom.swing.MigLayout;

public class EasyEquivalence extends NewPersonalEquivalenceListener {
	
	private JPanel leftPanel;
	private JPanel rightPanel;

	public EasyEquivalence(JFrame frame, JPanel menu, int id) {
		super(frame, menu, id);
		if(textAreaLeft != null) {
			textAreaLeft.removeAll();
		}
		if(textAreaRight != null) {
			textAreaRight.removeAll();
		}
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
		leftPanel = new JPanel(new MigLayout());
		leftPanel.setSize(100, 100);
		leftPanel.setAutoscrolls(true);
		rightPanel = new JPanel(new MigLayout());
		rightPanel.setSize(100, 100);
		rightPanel.setAutoscrolls(true);
		
		JButton undoLeft = new JButton("Undo");
		undoLeftListener = new UndoListener(this, "LEFT");
		undoLeft.addActionListener(undoLeftListener);
		JButton undoRight = new JButton("Undo");
		undoRightListener = new UndoListener(this, "RIGHT");
		undoRight.addActionListener(undoRightListener);
		
		left.add(textAreaLeft, BorderLayout.NORTH);
		left.add(leftPanel, BorderLayout.NORTH);
		left.add(undoLeft, BorderLayout.NORTH);
		
		right.add(textAreaRight, BorderLayout.NORTH);
		right.add(rightPanel, BorderLayout.NORTH);
		right.add(undoRight, BorderLayout.NORTH);
		
		JPanel north = new JPanel(new MigLayout());
		north.add(left, BorderLayout.WEST);
		north.add(centre);
		north.add(right, BorderLayout.EAST);
		equivalence.add(north, BorderLayout.NORTH);
		if(getFeedback() == null) {
			createFeedbackPanel();
		}
		equivalence.add(getFeedback(), BorderLayout.SOUTH);
	}
	
	public void updateEquivalenceLeft() {
		leftPanel.removeAll();
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
		JPanel panel = list.getLast().getTree().getRoot().createJPanel(this, true);
		leftPanel.add(panel, BorderLayout.NORTH);
		leftPanel.updateUI();
		setLeftPanel(leftPanel);
		if(list.getLast().getTree().toString().equals(getRight().getLast().getTree().toString())) {
			completeEquivalence();
		}
		/*
		JPanel leftPanel = getLeftPanel();
		leftPanel.removeAll();
		EquivalenceLinkedList list = getLeft();
		EquivalenceLinkNode curr = list.getHead();
		EquivalenceLinkNode next = curr.getNext();
		while(next != null) {	
			JTextArea textArea = new JTextArea(1,1);
			textArea.setEditable(false);
			textArea.setText("");
			textArea.append(curr.getLineNumber() + "\t" + curr.getTree().toString());
			textArea.append("\n");
			leftPanel.add(textArea, BorderLayout.NORTH);
			curr = curr.getNext();
			next = curr.getNext();
		}
		JPanel panel = curr.getTree().getRoot().createJPanel(this, true);
		leftPanel.add(panel, BorderLayout.NORTH);
		leftPanel.updateUI();
		setLeftPanel(leftPanel);
		if(list.getLast().getTree().toString().equals(getRight().getLast().getTree().toString())) {
			completeEquivalence();
		}
		*/
	}

	public void updateEquivalenceRight() {
		rightPanel.removeAll();
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
		JPanel panel = list.getLast().getTree().getRoot().createJPanel(this, false);
		rightPanel.add(panel, BorderLayout.NORTH);
		rightPanel.updateUI();
		setRightPanel(rightPanel);
		if(list.getLast().getTree().toString().equals(getLeft().getLast().getTree().toString())) {
			completeEquivalence();
		}
		/*
		JPanel rightPanel = getRightPanel();
		rightPanel.removeAll();
		EquivalenceLinkedList list = getRight();
		EquivalenceLinkNode curr = list.getHead();
		EquivalenceLinkNode next = curr.getNext();
		while(next != null) {	
			JTextArea textArea = new JTextArea(1,1);
			textArea.setEditable(false);
			textArea.setText("");
			textArea.append(curr.getLineNumber() + "\t" + curr.getTree().toString());
			textArea.append("\n");
			rightPanel.add(textArea, BorderLayout.NORTH);
			curr = curr.getNext();
			next = curr.getNext();
		}
		JPanel panel = curr.getTree().getRoot().createJPanel(this, false);
		rightPanel.add(panel, BorderLayout.NORTH);
		rightPanel.updateUI();
		setRightPanel(rightPanel);
		if(list.getLast().getTree().toString().equals(getLeft().getLast().getTree().toString())) {
			completeEquivalence();
		}
		*/
	}
	
	protected void completeEquivalence() {
		getEquivalence().setVisible(false);
		getButtons().setVisible(false);
		HardEquivalence hardEquivalence = new HardEquivalence(getFrame(), getMenu(), getId());
		hardEquivalence.createEquivalencePanel();
		hardEquivalence.createButtonsPanel();
		hardEquivalence.getFrame().add(hardEquivalence.getEquivalence(), BorderLayout.NORTH);
		hardEquivalence.getFrame().add(hardEquivalence.getButtons(), BorderLayout.SOUTH);
		hardEquivalence.setLeft(getLeft());
		hardEquivalence.setRight(getRight());
		hardEquivalence.updateEquivalenceLeft();
		hardEquivalence.updateEquivalenceRight();
	}

	public JPanel getLeftPanel() {
		return leftPanel;
	}

	public void setLeftPanel(JPanel leftPanel) {
		this.leftPanel = leftPanel;
	}

	public JPanel getRightPanel() {
		return rightPanel;
	}

	public void setRightPanel(JPanel rightPanel) {
		this.rightPanel = rightPanel;
	}

	protected void hidePanels() {
		getLeftPanel().setVisible(false);
		getRightPanel().setVisible(false);
		getButtons().setVisible(false);
	}

}
