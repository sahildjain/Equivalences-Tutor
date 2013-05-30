package dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import equivalence.EquivalenceLinkNode;
import equivalence.OrEquivalence;
import gui.NewPersonalEquivalenceListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import AST.AST;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class OrDialog extends JDialog {
	
	private JFrame frame;
	private JPanel panel;
	private NewPersonalEquivalenceListener listener;
	private int key;
	private boolean side;
	
	public OrDialog(NewPersonalEquivalenceListener listener, int key, boolean side) {
		this.setListener(listener);
		this.setFrame(listener.getFrame());
		this.setKey(key);
		this.setSide(side);
		panel = new JPanel(new MigLayout());
		panel.add(addIdempotence(), BorderLayout.NORTH);
		panel.add(addCommutativity(), BorderLayout.NORTH);
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(getFrame());
		setVisible(true);
	}
	
	private JButton addIdempotence() {
		JButton button = new JButton("Idempotence: A \u2228 A = A");
		button.addActionListener(new IdempotenceListener());
		return button;
	}
	
	private JButton addCommutativity() {
		JButton button = new JButton("Commutativity: A \u2228 B = B \u2228 A");
		button.addActionListener(new CommutativityListener());
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

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
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
			if(isSide()) {
				OrEquivalence eq = new OrEquivalence(getListener().getLeft().getLast().getTree(), getKey());
				AST tree = eq.idempotence();
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getLeft().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateLeftList(node);
				getListener().updateEquivalenceLeft();
			}
			if(!isSide()) {
				OrEquivalence eq = new OrEquivalence(getListener().getRight().getLast().getTree(), getKey());
				AST tree = eq.idempotence();
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getRight().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateRightList(node);
				getListener().updateEquivalenceRight();
			}
		}
		
	}
	
	private class CommutativityListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(isSide()) {
				OrEquivalence eq = new OrEquivalence(getListener().getLeft().getLast().getTree(), getKey());
				AST tree = eq.commutativity();
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getLeft().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateLeftList(node);
				getListener().updateEquivalenceLeft();
			}
			if(!isSide()) {
				OrEquivalence eq = new OrEquivalence(getListener().getRight().getLast().getTree(), getKey());
				AST tree = eq.commutativity();
				EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getRight().getLast().getLineNumber() + 1, tree, null, null);
				getListener().updateRightList(node);
				getListener().updateEquivalenceRight();
			}
		}
		
	}

}
