package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import equivalence.EquivalenceLinkNode;
import equivalence.EquivalenceLinkedList;

import net.miginfocom.swing.MigLayout;

public abstract class NewPersonalEquivalenceListener implements ActionListener {
	
	private JFrame frame;
	
	private JPanel menu;
	private JPanel buttons;
	protected JPanel equivalence;
	
	private JButton quit;
	private JButton states;
	protected JButton saveButton;
	private JButton menuButton;
	protected JButton submitLeft;
	protected JButton submitRight;
	protected JButton undoLeft;
	protected JButton undoRight;
	
	private StatesInputDialogListener inputListener;
	
	protected EquivalenceListener leftListener;
	protected EquivalenceListener rightListener;
	
	private EquivalenceLinkedList left = new EquivalenceLinkedList();
	private EquivalenceLinkedList right = new EquivalenceLinkedList();
	
	private SaveListener saveListener;
	
	protected JTextField textFieldLeft;
	protected JTextField textFieldRight;
	
	protected UndoListener undoLeftListener;
	protected UndoListener undoRightListener;
	

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
	
	protected abstract void createEquivalencePanel();

	private void createButtonsPanel() {
		buttons = new JPanel(new MigLayout());
		
		//Add the New Equivalence Button
		states = new JButton("New Equivalence");
	    inputListener = new StatesInputDialogListener(this);
		states.addActionListener(inputListener);
		
		//Add the Back to Menu Button
		menuButton = new JButton("Back to Menu");
		//hidePanels();
		//getMenu().setVisible(true);
		
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
	
	public abstract void updateEquivalenceLeft();
	
	public abstract void updateEquivalenceRight(); 
	
	protected abstract void completeEquivalence();
	
	protected abstract void hidePanels();
	
	public void updateLeftList(EquivalenceLinkNode node) {
		getLeft().add(node);
	}

	public void updateRightList(EquivalenceLinkNode node) {
		getRight().add(node);
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
	
	public JPanel getButtons() {
		return this.buttons;
	}
	
}
