package dialogs;

import gui.NewPersonalEquivalenceListener;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import AST.AST;

import equivalence.EquivalenceLinkNode;
import equivalence.ForAllEquivalence;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class ForAllDialog extends JDialog {
	
	private JFrame frame;
	private JPanel panel;
	private int key;
	private NewPersonalEquivalenceListener listener;
	private boolean side;
	
	public ForAllDialog(NewPersonalEquivalenceListener listener, int key, boolean side) {
		this.setListener(listener);
		this.setFrame(listener.getFrame());
		this.setKey(key);
		this.setSide(side);
		panel = new JPanel(new MigLayout());
		panel.add(addEquivalence1(), BorderLayout.NORTH);
		panel.add(addEquivalence2(), BorderLayout.NORTH);
		panel.add(addEquivalence3(), BorderLayout.NORTH);
		panel.add(addEquivalence4(), BorderLayout.NORTH);
		panel.add(addEquivalence5(), BorderLayout.NORTH);
		panel.add(addEquivalence6(), BorderLayout.NORTH);
		panel.add(addEquivalence7(), BorderLayout.NORTH);
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(getFrame());
		setVisible(true);
	}
	
	private JButton addEquivalence1() {
		JButton button = new JButton("\u2200x\u2200yA = \u2200y\u2200xA");
		button.addActionListener(new Equivalence1Listener());
		return button;
	}
	
	private JButton addEquivalence2() {
		JButton button = new JButton("\u2200x(A \u2227 B) = \u2200xA \u2227 \u2200xB");
		button.addActionListener(new Equivalence2Listener());
		return button;
	}
	
	private JButton addEquivalence3() {
		JButton button = new JButton("\u2200x\u00ACA = \u00AC\u2203xA");
		button.addActionListener(new Equivalence3Listener());
		return button;
	}
	
	private JButton addEquivalence4() {
		JButton button = new JButton("If x does not occur free in A, then \u2200xA = \u2203xA");
		button.addActionListener(new Equivalence4Listener());
		return button;
	}
	
	private JButton addEquivalence5() {
		JButton button = new JButton("If x does not occur free in A, then \u2200x(A \u2228 B) = A \u2228 \u2200xB");
		button.addActionListener(new Equivalence5Listener());
		return button;
	}
	
	private JButton addEquivalence6() {
		JButton button = new JButton("If x does not occur free in A, then \u2200x(A \u2192 B) = A \u2192 \u2200xB");
		button.addActionListener(new Equivalence6Listener());
		return button;
	}
	
	private JButton addEquivalence7() {
		JButton button = new JButton("If x does not occur free in B, then \u2200x(A \u2192 B) = \u2203xA \u2192 B");
		button.addActionListener(new Equivalence7Listener());
		return button;
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

	public NewPersonalEquivalenceListener getListener() {
		return listener;
	}

	public void setListener(NewPersonalEquivalenceListener listener) {
		this.listener = listener;
	}

	public boolean isSide() {
		return side;
	}

	public void setSide(boolean side) {
		this.side = side;
	}
	
	private class Equivalence1Listener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				ForAllEquivalence eq = new ForAllEquivalence(temp, getKey());
				AST tree = eq.equivalence1();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this And connective. Please try another equivalence!");
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
				AST temp = getListener().getRight().getLast().getTree().copy();
				ForAllEquivalence eq = new ForAllEquivalence(temp, getKey());
				AST tree = eq.equivalence1();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this And connective. Please try another equivalence!");
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
	
	private class Equivalence2Listener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				ForAllEquivalence eq = new ForAllEquivalence(temp, getKey());
				AST tree = eq.equivalence2();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this And connective. Please try another equivalence!");
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
				AST temp = getListener().getRight().getLast().getTree().copy();
				ForAllEquivalence eq = new ForAllEquivalence(temp, getKey());
				AST tree = eq.equivalence2();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this And connective. Please try another equivalence!");
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
	
	private class Equivalence3Listener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				ForAllEquivalence eq = new ForAllEquivalence(temp, getKey());
				AST tree = eq.equivalence3();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this And connective. Please try another equivalence!");
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
				AST temp = getListener().getRight().getLast().getTree().copy();
				ForAllEquivalence eq = new ForAllEquivalence(temp, getKey());
				AST tree = eq.equivalence3();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this And connective. Please try another equivalence!");
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
	
	private class Equivalence4Listener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				ForAllEquivalence eq = new ForAllEquivalence(temp, getKey());
				AST tree = eq.equivalence4();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this And connective. Please try another equivalence!");
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
				AST temp = getListener().getRight().getLast().getTree().copy();
				ForAllEquivalence eq = new ForAllEquivalence(temp, getKey());
				AST tree = eq.equivalence4();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this And connective. Please try another equivalence!");
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
	
	private class Equivalence5Listener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				ForAllEquivalence eq = new ForAllEquivalence(temp, getKey());
				AST tree = eq.equivalence5();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this And connective. Please try another equivalence!");
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
				AST temp = getListener().getRight().getLast().getTree().copy();
				ForAllEquivalence eq = new ForAllEquivalence(temp, getKey());
				AST tree = eq.equivalence5();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this And connective. Please try another equivalence!");
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
	
	private class Equivalence6Listener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				ForAllEquivalence eq = new ForAllEquivalence(temp, getKey());
				AST tree = eq.equivalence6();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this And connective. Please try another equivalence!");
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
				AST temp = getListener().getRight().getLast().getTree().copy();
				ForAllEquivalence eq = new ForAllEquivalence(temp, getKey());
				AST tree = eq.equivalence6();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this And connective. Please try another equivalence!");
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
	
	private class Equivalence7Listener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				ForAllEquivalence eq = new ForAllEquivalence(temp, getKey());
				AST tree = eq.equivalence7();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this And connective. Please try another equivalence!");
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
				AST temp = getListener().getRight().getLast().getTree().copy();
				ForAllEquivalence eq = new ForAllEquivalence(temp, getKey());
				AST tree = eq.equivalence7();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this And connective. Please try another equivalence!");
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