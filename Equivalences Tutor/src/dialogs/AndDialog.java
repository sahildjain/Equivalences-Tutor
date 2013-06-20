package dialogs;

import equivalence.AndEquivalence;
import equivalence.EquivalenceLinkNode;
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

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class AndDialog extends JDialog {
	
	private JFrame frame;
	private JPanel panel;
	private NewPersonalEquivalenceListener listener;
	private int key;
	private boolean side;
	
	public AndDialog(NewPersonalEquivalenceListener listener, int key, boolean side) {
		this.setListener(listener);
		this.setFrame(listener.getFrame());
		this.setKey(key);
		this.setSide(side);
		//AndEquivalence eq;
		/*if(isSide()) {
			AST temp = getListener().getLeft().getLast().getTree().copy();
			//eq = new AndEquivalence(temp, getKey());
		}
		else {
			AST temp = getListener().getRight().getLast().getTree().copy();
			//eq = new AndEquivalence(temp, getKey());
		}*/
		panel = new JPanel(new MigLayout());
		//if(eq.idempotence() != null) {
			panel.add(addIdempotence(), BorderLayout.NORTH);
		//}
		//if(eq.commutativity() != null) {
			panel.add(addCommutativity(), BorderLayout.NORTH);
		//}
		//if(eq.associativityLeft() != null) {
			panel.add(addAssociaticityLeft(), BorderLayout.NORTH);
		//}
		//if(eq.associativityRight() != null) {
			panel.add(addAssociaticityRight(), BorderLayout.NORTH);
		//}
		//if(eq.deMorgan() != null) {
			panel.add(addDeMorgan(), BorderLayout.NORTH);
		//}
		//if(eq.iff() != null) {
			panel.add(addIff(), BorderLayout.NORTH);
		//}
			panel.add(addDistributivityDiff(), BorderLayout.NORTH);
			panel.add(addDistributivityBack(), BorderLayout.NORTH);
			panel.add(addDistributivitySame(), BorderLayout.NORTH);
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(getFrame());
		setVisible(true);
	}
	
	private JButton addIdempotence() {
		JButton button = new JButton("Idempotence: A \u2227 A = A");
		button.addActionListener(new IdempotenceListener());
		return button;
	}
	
	private JButton addCommutativity() {
		JButton button = new JButton("Commutativity: A \u2227 B = B \u2227 A");
		button.addActionListener(new CommutativityListener());
		return button;
	}
	
	private JButton addAssociaticityLeft() {
		JButton button = new JButton("Associativity: (A \u2227 B) \u2227 C = A \u2227 (B \u2227 C)");
		button.addActionListener(new AssociativityLeftListener());
		return button;
	}
	
	private JButton addAssociaticityRight() {
		JButton button = new JButton("Associativity: A \u2227 (B \u2227 C) = (A \u2227 B) \u2227 C");
		button.addActionListener(new AssociativityRightListener());
		return button;
	}
	
	private JButton addDeMorgan() {
		JButton button = new JButton("De Morgan's: A \u2227 B = \u00AC(\u00ACA \u2228 \u00ACB)");
		button.addActionListener(new DeMorganListener());
		return button;
	}
	
	private JButton addIff() {
		JButton button = new JButton("(A \u2192 B) \u2227 (B \u2192 A) = (A \u2194 B)");
		button.addActionListener(new IffListener());
		return button;
	}
	
	private JButton addDistributivityDiff() {
		JButton button = new JButton("Distributivity: A \u2227 (B \u2228 C) = (A \u2227 B) \u2228 (A \u2227 C)");
		button.addActionListener(new DistributivityDiffListener());
		return button;
	}
	
	private JButton addDistributivityBack() {
		JButton button = new JButton("Distributivity: (A \u2228 B) \u2227 (A \u2228 C) = A \u2228 (B \u2227 C)");
		button.addActionListener(new DistributivityBackwardsListener());
		return button;
	}
	
	private JButton addDistributivitySame() {
		JButton button = new JButton("Distributivity: A \u2227 (A \u2228 B) = A");
		button.addActionListener(new DistributivitySameListener());
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

	private class IdempotenceListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				AndEquivalence eq = new AndEquivalence(temp, getKey());
				AST tree = eq.idempotence();
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
				AndEquivalence eq = new AndEquivalence(temp, getKey());
				AST tree = eq.idempotence();
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
	
	private class CommutativityListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				AndEquivalence eq = new AndEquivalence(temp, getKey());
				AST tree = eq.commutativity();
				if(tree == null) {
					JLabel label2 = new JLabel("Commutativity cannot be applied to this And connective. Please try another equivalence!");
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
				AndEquivalence eq = new AndEquivalence(temp, getKey());
				AST tree = eq.commutativity();
				if(tree == null) {
					JLabel label2 = new JLabel("Commutativity cannot be applied to this And connective. Please try another equivalence!");
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
	
	private class AssociativityLeftListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				AndEquivalence eq = new AndEquivalence(temp, getKey());
				AST tree = eq.associativityLeft();
				if(tree == null) {
					JLabel label2 = new JLabel("This Associativity equivalence cannot be applied to this And connective. Please try another equivalence!");
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
				AndEquivalence eq = new AndEquivalence(temp, getKey());
				AST tree = eq.associativityLeft();
				if(tree == null) {
					JLabel label2 = new JLabel("This Associativity equivalence cannot be applied to this And connective. Please try another equivalence!");
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
	
	private class AssociativityRightListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				AndEquivalence eq = new AndEquivalence(temp, getKey());
				AST tree = eq.associativityRight();
				if(tree == null) {
					JLabel label2 = new JLabel("This Associativity equivalence cannot be applied to this And connective. Please try another equivalence!");
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
				AndEquivalence eq = new AndEquivalence(temp, getKey());
				AST tree = eq.associativityRight();
				if(tree == null) {
					JLabel label2 = new JLabel("This Associativity equivalence cannot be applied to this And connective. Please try another equivalence!");
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
	
	private class DeMorganListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				AndEquivalence eq = new AndEquivalence(temp, getKey());
				AST tree = eq.deMorgan();
				if(tree == null) {
					JLabel label2 = new JLabel("You cannot apply DeMorgan's law to this And connective. Please try another equivalence!");
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
				AndEquivalence eq = new AndEquivalence(temp, getKey());
				AST tree = eq.deMorgan();
				if(tree == null) {
					JLabel label2 = new JLabel("You cannot apply DeMorgan's law to this And connectiver. Please try another equivalence!");
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
	
	private class IffListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				AndEquivalence eq = new AndEquivalence(temp, getKey());
				AST tree = eq.iff();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this node. Please try another equivalence!");
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
				AndEquivalence eq = new AndEquivalence(temp, getKey());
				AST tree = eq.iff();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this node. Please try another equivalence!");
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
	
	private class DistributivityDiffListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				AndEquivalence eq = new AndEquivalence(temp, getKey());
				AST tree = eq.distdiff();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this node. Please try another equivalence!");
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
				AndEquivalence eq = new AndEquivalence(temp, getKey());
				AST tree = eq.distdiff();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this node. Please try another equivalence!");
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
	
	private class DistributivityBackwardsListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				AndEquivalence eq = new AndEquivalence(temp, getKey());
				AST tree = eq.distback();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this node. Please try another equivalence!");
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
				AndEquivalence eq = new AndEquivalence(temp, getKey());
				AST tree = eq.distback();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this node. Please try another equivalence!");
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
	
	private class DistributivitySameListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			JPanel feedback = getListener().getFeedback();
			feedback.removeAll();
			JLabel label1 = new JLabel("Feedback");
			feedback.add(label1, BorderLayout.NORTH);
			getListener().setFeedback(feedback);
			getListener().getEquivalence().updateUI();
			if(isSide()) {
				AST temp = getListener().getLeft().getLast().getTree().copy();
				AndEquivalence eq = new AndEquivalence(temp, getKey());
				AST tree = eq.distsame();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this node. Please try another equivalence!");
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
				AndEquivalence eq = new AndEquivalence(temp, getKey());
				AST tree = eq.distsame();
				if(tree == null) {
					JLabel label2 = new JLabel("Idempotence cannot be applied to this node. Please try another equivalence!");
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
