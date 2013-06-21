package dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import equivalence.EquivalenceLinkNode;
import equivalence.IfEquivalence;
import gui.NewPersonalEquivalenceListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import AST.AST;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class IfDialog extends JDialog {
	
	private JFrame frame;
	private JPanel panel;
	private NewPersonalEquivalenceListener listener;
	private int key;
	private boolean side;
	
	public IfDialog(NewPersonalEquivalenceListener listener, int key, boolean side) {
		this.setListener(listener);
		this.setFrame(listener.getFrame());
		this.setKey(key);
		this.setSide(side);
		panel = new JPanel(new MigLayout());
		panel.add(addIfToOr(), BorderLayout.NORTH);
		panel.add(addIfToAnd(), BorderLayout.NORTH);
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(getFrame());
		setVisible(true);
	}
	
	private JButton addIfToOr() {
		JButton button = new JButton("A \u2192 B = !A \u2228 B");
		button.addActionListener(new IfToOrListener());
		return button;
	}
	
	private JButton addIfToAnd() {
		JButton button = new JButton("A \u2192 B = \u00AC(A \u2227 !B)");
		button.addActionListener(new IfToAndListener());
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

	private class IfToOrListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				IfEquivalence eq = new IfEquivalence(getListener().getLeft().getLast().getTree().copy(), getKey());
				AST tree = eq.ifToOrEquivalence();
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
				IfEquivalence eq = new IfEquivalence(getListener().getRight().getLast().getTree().copy(), getKey());
				AST tree = eq.ifToOrEquivalence();
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
	
	private class IfToAndListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				IfEquivalence eq = new IfEquivalence(getListener().getLeft().getLast().getTree().copy(), getKey());
				AST tree = eq.ifToAndEquivalence();
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
				IfEquivalence eq = new IfEquivalence(getListener().getRight().getLast().getTree().copy(), getKey());
				AST tree = eq.ifToAndEquivalence();
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
