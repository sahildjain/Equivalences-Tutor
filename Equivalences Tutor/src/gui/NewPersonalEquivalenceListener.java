package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import equivalence.EquivalenceLinkNode;
import equivalence.EquivalenceLinkedList;

import net.miginfocom.swing.MigLayout;

public class NewPersonalEquivalenceListener implements ActionListener {
	
	private JFrame frame;
	
	private JPanel menu;
	private JPanel buttons;
	private JPanel equivalence;
	
	private JButton quit;
	private JButton states;
	protected JButton saveButton;
	private JButton menuButton;
	private JButton submitLeft;
	private JButton submitRight;
	
	private JTextArea textAreaLeft;
	private JTextArea textAreaRight;
	
	private JTextField textFieldLeft;
	private JTextField textFieldRight;
	
	private StatesInputDialogListener inputListener;
	
	private EquivalenceListener leftListener;
	private EquivalenceListener rightListener;
	
	private EquivalenceLinkedList left = new EquivalenceLinkedList();
	private EquivalenceLinkedList right = new EquivalenceLinkedList();
	
	private SaveListener saveListener;
	

	public NewPersonalEquivalenceListener(JFrame frame, JPanel menu) {
		this.setMenu(menu);
		this.setFrame(frame);
	}

	public void actionPerformed(ActionEvent e) {
		getMenu().setVisible(false);
		createEquivalencePanel();
		createButtonsPanel();
		frame.add(buttons, BorderLayout.SOUTH);
		frame.add(equivalence, BorderLayout.NORTH);
	}
	
	private void createEquivalencePanel() {
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
		submitRight = new JButton("Submit");
		rightListener = new EquivalenceListener(this, "RIGHT");
		submitRight.addActionListener(rightListener);
		left.add(textAreaLeft, BorderLayout.NORTH);
		left.add(textFieldLeft, BorderLayout.WEST);
		left.add(submitLeft, BorderLayout.EAST);
		right.add(textAreaRight, BorderLayout.NORTH);
		right.add(textFieldRight, BorderLayout.WEST);
		right.add(submitRight, BorderLayout.EAST);
		equivalence.add(left, BorderLayout.WEST);
		equivalence.add(centre);
		equivalence.add(right, BorderLayout.EAST);
	}

	private void createButtonsPanel() {
		buttons = new JPanel(new MigLayout());
		
		//Add the New Equivalence Button
		states = new JButton("New Equivalence");
	    inputListener = new StatesInputDialogListener(this);
		states.addActionListener(inputListener);
		
		//Add the Back to Menu Button
		menuButton = new JButton("Back to Menu");
		
		//Add the Save Button
		saveButton = new JButton("Save");
		saveListener = new SaveListener(this);
		saveButton.addActionListener(saveListener);
		
		//Add the Quit Button
		quit = new JButton("Quit");
		QuitListener quitListener = new QuitListener();
		quit.addActionListener(quitListener);
		
		buttons.add(states, BorderLayout.WEST);
		buttons.add(menuButton, BorderLayout.WEST);
		buttons.add(saveButton, BorderLayout.WEST);
		buttons.add(quit, BorderLayout.EAST);
		
	}
	
	protected void updateEquivalenceLeft() {
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
	
	protected void updateEquivalenceRight() {
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
	
	protected void updateLeftList(EquivalenceLinkNode node) {
		getLeft().add(node);
	}

	protected void updateRightList(EquivalenceLinkNode node) {
		getRight().add(node);
	}
	
	private void completeEquivalence() {
		textFieldLeft.setVisible(false);
		textFieldRight.setVisible(false);
		submitLeft.setVisible(false);
		submitRight.setVisible(false);
	}

	public JPanel getMenu() {
		return menu;
	}

	public void setMenu(JPanel menu) {
		this.menu = menu;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public EquivalenceLinkedList getLeft() {
		return this.left;
	}
	
	public EquivalenceLinkedList getRight() {
		return this.right;
	}
	
	public void setLeft(EquivalenceLinkedList left) {
		this.left = left;
	}
	
	public void setRight(EquivalenceLinkedList right) {
		this.right = right;
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

	public JTextField getTextFieldLeft() {
		return textFieldLeft;
	}

	public void setTextFieldLeft(JTextField textFieldLeft) {
		this.textFieldLeft = textFieldLeft;
	}

	public JTextField getTextFieldRight() {
		return textFieldRight;
	}

	public void setTextFieldRight(JTextField textFieldRight) {
		this.textFieldRight = textFieldRight;
	}

	public JButton getSubmitLeft() {
		return submitLeft;
	}

	public void setSubmitLeft(JButton submitLeft) {
		this.submitLeft = submitLeft;
	}

	public JButton getSubmitRight() {
		return submitRight;
	}

	public void setSubmitRight(JButton submitRight) {
		this.submitRight = submitRight;
	}
	
}
