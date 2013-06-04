package dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import equivalence.EquivalenceLinkNode;
import equivalence.IffEquivalence;
import gui.NewPersonalEquivalenceListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import AST.AST;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class IffDialog extends JDialog {
	
	private JFrame frame;
	private JPanel panel;
	private int key;
	private NewPersonalEquivalenceListener listener;
	private boolean side;
	
	public IffDialog(NewPersonalEquivalenceListener listener, int key, boolean side) {
		this.setListener(listener);
		this.setFrame(listener.getFrame());
		this.setKey(key);
		this.setSide(side);
		panel = new JPanel(new MigLayout());
		panel.add(addIffToAnd(), BorderLayout.NORTH);
		panel.add(addIffToOr(), BorderLayout.NORTH);
		panel.add(addNots(), BorderLayout.NORTH);
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(getFrame());
		setVisible(true);
	}
	
	// A <-> B = (A -> B) & (B -> A)
	private JButton addIffToAnd() {
		JButton button = new JButton("A \u2194 B = (A \u2192 B) \u2227 (B \u2192 A)");
		button.addActionListener(new IffToAndListener());
		return button;
	}
	
	// A <-> B = (A & B) | (!A & !B)
	private JButton addIffToOr() {
		JButton button = new JButton("A \u2194 B = (A \u2227 B) \u2228 (\u00ACA \u2227 \u00ACB)");
		button.addActionListener(new IffToOrListener());
		return button;
	}
	
	// A <-> B = !A <-> !B
	private JButton addNots() {
		JButton button = new JButton("A \u2194 B = \u00ACA \u2194 \u00ACB");
		button.addActionListener(new NotsListener());
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

	private class IffToAndListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(isSide()) {
				IffEquivalence eq = new IffEquivalence(getListener().getLeft().getLast().getTree().copy(), getKey());
				AST tree = eq.iffToAndEquivalence();
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getLeft().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateLeftList(node);
				getListener().updateEquivalenceLeft();
			}
			if(!isSide()) {
				IffEquivalence eq = new IffEquivalence(getListener().getRight().getLast().getTree().copy(), getKey());
				AST tree = eq.iffToAndEquivalence();
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getRight().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateRightList(node);
				getListener().updateEquivalenceRight();
			}
		}
		
	}
	
	private class IffToOrListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(isSide()) {
				IffEquivalence eq = new IffEquivalence(getListener().getLeft().getLast().getTree().copy(), getKey());
				AST tree = eq.iffToOrEquivalence();
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getLeft().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateLeftList(node);
				getListener().updateEquivalenceLeft();
			}
			if(!isSide()) {
				IffEquivalence eq = new IffEquivalence(getListener().getRight().getLast().getTree().copy(), getKey());
				AST tree = eq.iffToOrEquivalence();
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getRight().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateRightList(node);
				getListener().updateEquivalenceRight();
			}
		}
		
	}
	
	private class NotsListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(isSide()) {
				IffEquivalence eq = new IffEquivalence(getListener().getLeft().getLast().getTree().copy(), getKey());
				AST tree = eq.negate();
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getLeft().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateLeftList(node);
				getListener().updateEquivalenceLeft();
			}
			if(!isSide()) {
				IffEquivalence eq = new IffEquivalence(getListener().getRight().getLast().getTree().copy(), getKey());
				AST tree = eq.negate();
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getRight().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateRightList(node);
				getListener().updateEquivalenceRight();
			}
		}
		
	}

}
