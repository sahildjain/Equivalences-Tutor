package dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import equivalence.EquivalenceLinkNode;
import equivalence.NotEquivalence;
import gui.NewPersonalEquivalenceListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import AST.AST;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class NotDialog extends JDialog {
	
	private JFrame frame;
	private JPanel panel;
	private int key;
	private NewPersonalEquivalenceListener listener;
	private boolean side;
	
	public NotDialog(NewPersonalEquivalenceListener listener, int key, boolean side) {
		this.setListener(listener);
		this.setFrame(listener.getFrame());
		this.setKey(key);
		this.setSide(side);
		panel = new JPanel(new MigLayout());
		panel.add(addDoubleNegation(), BorderLayout.NORTH);
		panel.add(addDemorganAnd(), BorderLayout.NORTH);
		panel.add(addDemorganOr(), BorderLayout.NORTH);
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(getFrame());
		setVisible(true);
	}
	
	private JButton addDoubleNegation() {
		JButton button = new JButton("Double Negation: \u00AC\u00ACA = A");
		button.addActionListener(new DoubleNegationListener());
		return button;
	}
	
	private JButton addDemorganAnd() {
		JButton button = new JButton("DeMorgan And: \u00AC(A \u2227 B) = \u00ACA \u2228 \u00ACB");
		button.addActionListener(new DeMorganAndListener());
		return button;
	}
	
	private JButton addDemorganOr() {
		JButton button = new JButton("DeMorgan Or: \u00AC(A \u2228 B) = \u00ACA \u2227 \u00ACB");
		button.addActionListener(new DeMorganOrListener());
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

	private class DoubleNegationListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(isSide()) {
				NotEquivalence eq = new NotEquivalence(getListener().getLeft().getLast().getTree().copy(), getKey());
				AST tree = eq.doubleNegation();
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getLeft().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateLeftList(node);
				getListener().updateEquivalenceLeft();
			}
			if(!isSide()) {
				NotEquivalence eq = new NotEquivalence(getListener().getRight().getLast().getTree().copy(), getKey());
				AST tree = eq.doubleNegation();
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getRight().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateRightList(node);
				getListener().updateEquivalenceRight();
			}
		}
		
	}
	
	private class DeMorganAndListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(isSide()) {
				NotEquivalence eq = new NotEquivalence(getListener().getLeft().getLast().getTree().copy(), getKey());
				AST tree = eq.deMorganAnd();
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getLeft().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateLeftList(node);
				getListener().updateEquivalenceLeft();
			}
			if(!isSide()) {
				NotEquivalence eq = new NotEquivalence(getListener().getRight().getLast().getTree().copy(), getKey());
				AST tree = eq.deMorganAnd();
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getRight().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateRightList(node);
				getListener().updateEquivalenceRight();
			}
		}
		
	}
	
	private class DeMorganOrListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(isSide()) {
				NotEquivalence eq = new NotEquivalence(getListener().getLeft().getLast().getTree().copy(), getKey());
				AST tree = eq.deMorganOr();
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getLeft().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateLeftList(node);
				getListener().updateEquivalenceLeft();
			}
			if(!isSide()) {
				NotEquivalence eq = new NotEquivalence(getListener().getRight().getLast().getTree().copy(), getKey());
				AST tree = eq.deMorganOr();
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getRight().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateRightList(node);
				getListener().updateEquivalenceRight();
			}
		}
		
	}

}
