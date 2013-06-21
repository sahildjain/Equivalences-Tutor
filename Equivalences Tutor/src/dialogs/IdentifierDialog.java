package dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import equivalence.EquivalenceLinkNode;
import equivalence.IdentifierEquivalence;
import gui.NewPersonalEquivalenceListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import AST.AST;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class IdentifierDialog extends JDialog {
	
	private JFrame frame;
	private JPanel panel;
	private NewPersonalEquivalenceListener listener;
	private int key;
	private boolean side;
	
	public IdentifierDialog(NewPersonalEquivalenceListener listener, int key, boolean side) {
		this.setListener(listener);
		this.setFrame(listener.getFrame());
		this.setKey(key);
		this.setSide(side);
		panel = new JPanel(new MigLayout());
		panel.add(addDoubleNegation(), BorderLayout.NORTH);
		panel.add(addAndIdempotence(), BorderLayout.NORTH);
		panel.add(addOrIdempotence(), BorderLayout.NORTH);
		panel.add(addFalsityIntroduction(), BorderLayout.NORTH);
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(getFrame());
		setVisible(true);
	}
	
	private JButton addDoubleNegation() {
		JButton button = new JButton("Double Negation: A = \u00AC\u00ACA");
		button.addActionListener(new DoubleNegationListener());
		return button;
	}
	
	private JButton addAndIdempotence() {
		JButton button = new JButton("And Idempotence: A = A \u2227 A");
		button.addActionListener(new AndIdempotenceListener());
		return button;
	}
	
	private JButton addOrIdempotence() {
		JButton button = new JButton("Or Idempotence: A = A \u2228 A");
		button.addActionListener(new OrIdempotenceListener());
		return button;
	}
	
	private JButton addFalsityIntroduction() {
		JButton button = new JButton("A = A \u2228 \u22A5");
		button.addActionListener(new FalsityIntroductionListener());
		return button;
	}

	public NewPersonalEquivalenceListener getListener() {
		return listener;
	}

	public void setListener(NewPersonalEquivalenceListener listener) {
		this.listener = listener;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public boolean isSide() {
		return side;
	}

	public void setSide(boolean side) {
		this.side = side;
	}

	private class DoubleNegationListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				IdentifierEquivalence eq = new IdentifierEquivalence(getListener().getLeft().getLast().getTree().copy(), getKey());
				AST tree = eq.doubleNegation();
				if(tree == null) {
					JLabel label2 = new JLabel("Please try another equivalence!");
					feedback.add(label2, BorderLayout.SOUTH);
					getListener().setFeedback(feedback);
					getListener().getEquivalence().updateUI();
					return;
				}
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getLeft().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateLeftList(node);
				getListener().updateEquivalenceLeft();
			}
			if(!isSide()) {
				IdentifierEquivalence eq = new IdentifierEquivalence(getListener().getRight().getLast().getTree().copy(), getKey());
				AST tree = eq.doubleNegation();
				if(tree == null) {
					JLabel label2 = new JLabel("Please try another equivalence!");
					feedback.add(label2, BorderLayout.SOUTH);
					getListener().setFeedback(feedback);
					getListener().getEquivalence().updateUI();
					return;
				}
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getRight().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateRightList(node);
				getListener().updateEquivalenceRight();
			}
		}
		
	}
	
	private class AndIdempotenceListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				IdentifierEquivalence eq = new IdentifierEquivalence(getListener().getLeft().getLast().getTree().copy(), getKey());
				AST tree = eq.andIdempotence();
				if(tree == null) {
					JLabel label2 = new JLabel("Please try another equivalence!");
					feedback.add(label2, BorderLayout.SOUTH);
					getListener().setFeedback(feedback);
					getListener().getEquivalence().updateUI();
					return;
				}
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getLeft().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateLeftList(node);
				getListener().updateEquivalenceLeft();
			}
			if(!isSide()) {
				IdentifierEquivalence eq = new IdentifierEquivalence(getListener().getRight().getLast().getTree().copy(), getKey());
				AST tree = eq.andIdempotence();
				if(tree == null) {
					JLabel label2 = new JLabel("Please try another equivalence!");
					feedback.add(label2, BorderLayout.SOUTH);
					getListener().setFeedback(feedback);
					getListener().getEquivalence().updateUI();
					return;
				}
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getRight().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateRightList(node);
				getListener().updateEquivalenceRight();
			}
		}
		
	}
	
	private class OrIdempotenceListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				IdentifierEquivalence eq = new IdentifierEquivalence(getListener().getLeft().getLast().getTree().copy(), getKey());
				AST tree = eq.orIdempotence();
				if(tree == null) {
					JLabel label2 = new JLabel("Please try another equivalence!");
					feedback.add(label2, BorderLayout.SOUTH);
					getListener().setFeedback(feedback);
					getListener().getEquivalence().updateUI();
					return;
				}
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getLeft().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateLeftList(node);
				getListener().updateEquivalenceLeft();
			}
			if(!isSide()) {
				IdentifierEquivalence eq = new IdentifierEquivalence(getListener().getRight().getLast().getTree().copy(), getKey());
				AST tree = eq.orIdempotence();
				if(tree == null) {
					JLabel label2 = new JLabel("Please try another equivalence!");
					feedback.add(label2, BorderLayout.SOUTH);
					getListener().setFeedback(feedback);
					getListener().getEquivalence().updateUI();
					return;
				}
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getRight().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateRightList(node);
				getListener().updateEquivalenceRight();
			}
		}
		
	}
	
	private class FalsityIntroductionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				IdentifierEquivalence eq = new IdentifierEquivalence(getListener().getLeft().getLast().getTree().copy(), getKey());
				AST tree = eq.falsityIntroduction();
				if(tree == null) {
					JLabel label2 = new JLabel("Please try another equivalence!");
					feedback.add(label2, BorderLayout.SOUTH);
					getListener().setFeedback(feedback);
					getListener().getEquivalence().updateUI();
					return;
				}
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getLeft().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateLeftList(node);
				getListener().updateEquivalenceLeft();
			}
			if(!isSide()) {
				IdentifierEquivalence eq = new IdentifierEquivalence(getListener().getRight().getLast().getTree().copy(), getKey());
				AST tree = eq.falsityIntroduction();
				if(tree == null) {
					JLabel label2 = new JLabel("Please try another equivalence!");
					feedback.add(label2, BorderLayout.SOUTH);
					getListener().setFeedback(feedback);
					getListener().getEquivalence().updateUI();
					return;
				}
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getRight().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateRightList(node);
				getListener().updateEquivalenceRight();
			}
		}
		
	}

}
