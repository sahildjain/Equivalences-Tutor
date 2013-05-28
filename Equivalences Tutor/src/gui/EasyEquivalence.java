package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import equivalence.EquivalenceLinkNode;
import equivalence.EquivalenceLinkedList;

import net.miginfocom.swing.MigLayout;

public class EasyEquivalence extends NewPersonalEquivalenceListener {
	
	private JPanel leftPanel;
	private JPanel rightPanel;

	public EasyEquivalence(JFrame frame, JPanel menu) {
		super(frame, menu);
	}

	protected void createEquivalencePanel() {
		equivalence = new JPanel(new MigLayout());
		JPanel left = new JPanel(new MigLayout());
		JPanel centre = new JPanel(new MigLayout());
		JPanel right = new JPanel(new MigLayout());
		leftPanel = new JPanel(new MigLayout("debug"));
		rightPanel = new JPanel(new MigLayout("debug"));
		textFieldLeft = new JTextField(60);
		textFieldRight = new JTextField(60);
		submitLeft = new JButton("Submit");
		leftListener = new EquivalenceListener(this, "LEFT");
		submitLeft.addActionListener(leftListener);
		submitRight = new JButton("Submit");
		rightListener = new EquivalenceListener(this, "RIGHT");
		submitRight.addActionListener(rightListener);
		left.add(leftPanel, BorderLayout.NORTH);
		left.add(textFieldLeft, BorderLayout.WEST);
		left.add(submitLeft, BorderLayout.EAST);
		right.add(rightPanel, BorderLayout.NORTH);
		right.add(textFieldRight, BorderLayout.WEST);
		right.add(submitRight, BorderLayout.EAST);
		equivalence.add(left, BorderLayout.WEST);
		equivalence.add(centre);
		equivalence.add(right, BorderLayout.EAST);
	}
	
	public void updateEquivalenceLeft() {
		JPanel leftPanel = getLeftPanel();
		leftPanel.removeAll();
		EquivalenceLinkedList list = getLeft();
		EquivalenceLinkNode curr = list.getHead();
		while(curr != null) {	
			JPanel panel = curr.getTree().getRoot().createJPanel(this);
			leftPanel.add(panel, BorderLayout.NORTH);
			leftPanel.updateUI();
			curr = curr.getNext();
		}
		setLeftPanel(leftPanel);
	}

	public void updateEquivalenceRight() {
		JPanel rightPanel = getRightPanel();
		EquivalenceLinkedList list = getRight();
		EquivalenceLinkNode curr = list.getHead();
		while(curr != null) {
			JPanel panel = curr.getTree().getRoot().createJPanel(this);
			rightPanel.add(panel, BorderLayout.CENTER);
			rightPanel.updateUI();
			curr = curr.getNext();
		}
		setRightPanel(rightPanel);
	}
	
	//TODO
	protected void completeEquivalence() {
		
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
		getTextFieldLeft().setVisible(false);
		getTextFieldRight().setVisible(false);
		getSubmitLeft().setVisible(false);
		getSubmitRight().setVisible(false);
		getButtons().setVisible(false);
	}

}
