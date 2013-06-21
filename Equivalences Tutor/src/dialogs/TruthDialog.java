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
import equivalence.TruthEquivalence;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class TruthDialog extends JDialog {
	
	private JFrame frame;
	private JPanel panel;
	private int key;
	private NewPersonalEquivalenceListener listener;
	private boolean side;
	
	public TruthDialog(NewPersonalEquivalenceListener listener, int key, boolean side) {
		this.setListener(listener);
		this.setFrame(listener.getFrame());
		this.setKey(key);
		this.setSide(side);
		panel = new JPanel(new MigLayout());
		panel.add(addImplicationIntroduction(), BorderLayout.NORTH);
		panel.add(addImplicationIntroduction2(), BorderLayout.NORTH);
		panel.add(addImplicationIntroduction3(), BorderLayout.NORTH);
		panel.add(addFalsityIntroduction(), BorderLayout.NORTH);
		panel.add(addOrIntroduction1(), BorderLayout.NORTH);
		panel.add(addOrIntroduction2(), BorderLayout.NORTH);
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(getFrame());
		setVisible(true);
	}
	
	private JButton addImplicationIntroduction() {
		JButton button = new JButton("\u22A4 = A \u2192 A");
		button.addActionListener(new ImplicationIntroductionListener());
		return button;
	}
	
	private JButton addImplicationIntroduction2() {
		JButton button = new JButton("\u22A4 = A \u2192 \u22A4");
		button.addActionListener(new ImplicationIntroduction2Listener());
		return button;
	}
	
	private JButton addImplicationIntroduction3() {
		JButton button = new JButton("\u22A4 = \u22A5 \u2192 \u22A4");
		button.addActionListener(new ImplicationIntroduction3Listener());
		return button;
	}
	
	private JButton addFalsityIntroduction() {
		JButton button = new JButton("\u22A4 = \u00AC\u22A5");
		button.addActionListener(new FalsityIntroductionListener());
		return button;
	}
	
	private JButton addOrIntroduction1() {
		JButton button = new JButton("\u22A4 = A \u2228 \u00ACA");
		button.addActionListener(new OrIntroduction1Listener());
		return button;
	}
	
	private JButton addOrIntroduction2() {
		JButton button = new JButton("\u22A4 = A \u2228 \u22A4");
		button.addActionListener(new OrIntroduction2Listener());
		return button;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public NewPersonalEquivalenceListener getListener() {
		return listener;
	}

	public void setListener(NewPersonalEquivalenceListener listener) {
		this.listener = listener;
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
	
	private class ImplicationIntroductionListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				TruthEquivalence eq = new TruthEquivalence(temp, getKey());
				AST tree = eq.implicationIntroduction();
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
				AST temp = getListener().getRight().getLast().getTree().copy();
				TruthEquivalence eq = new TruthEquivalence(temp, getKey());
				AST tree = eq.implicationIntroduction();
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
	
	private class ImplicationIntroduction2Listener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				TruthEquivalence eq = new TruthEquivalence(temp, getKey());
				AST tree = eq.implicationIntroduction2();
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
				AST temp = getListener().getRight().getLast().getTree().copy();
				TruthEquivalence eq = new TruthEquivalence(temp, getKey());
				AST tree = eq.implicationIntroduction2();
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
	
	private class ImplicationIntroduction3Listener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				TruthEquivalence eq = new TruthEquivalence(temp, getKey());
				AST tree = eq.implicationIntroduction3();
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
				AST temp = getListener().getRight().getLast().getTree().copy();
				TruthEquivalence eq = new TruthEquivalence(temp, getKey());
				AST tree = eq.implicationIntroduction3();
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

		public void actionPerformed(ActionEvent arg0) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				TruthEquivalence eq = new TruthEquivalence(temp, getKey());
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
				AST temp = getListener().getRight().getLast().getTree().copy();
				TruthEquivalence eq = new TruthEquivalence(temp, getKey());
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
	
	private class OrIntroduction1Listener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				TruthEquivalence eq = new TruthEquivalence(temp, getKey());
				AST tree = eq.orIntroduction1();
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
				AST temp = getListener().getRight().getLast().getTree().copy();
				TruthEquivalence eq = new TruthEquivalence(temp, getKey());
				AST tree = eq.orIntroduction1();
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
	
	private class OrIntroduction2Listener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				TruthEquivalence eq = new TruthEquivalence(temp, getKey());
				AST tree = eq.orIntroduction2();
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
				AST temp = getListener().getRight().getLast().getTree().copy();
				TruthEquivalence eq = new TruthEquivalence(temp, getKey());
				AST tree = eq.orIntroduction2();
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
