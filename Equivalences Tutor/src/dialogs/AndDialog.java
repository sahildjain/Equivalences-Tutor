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
import javax.swing.JPanel;

import AST.AST;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class AndDialog extends JDialog {
	
	private JFrame frame;
	private JPanel panel;
	private NewPersonalEquivalenceListener listener;
	private int key;
	
	public AndDialog(NewPersonalEquivalenceListener listener, int key) {
		this.setListener(listener);
		this.setFrame(listener.getFrame());
		this.setKey(key);
		panel = new JPanel(new MigLayout());
		panel.add(addIdempotence(), BorderLayout.NORTH);
		panel.add(addCommutativity(), BorderLayout.NORTH);
		panel.add(addAssociaticityLeft(), BorderLayout.NORTH);
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
	
	private class IdempotenceListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			AndEquivalence eq = new AndEquivalence(getListener().getLeft().getLast().getTree(), getKey());
			AST tree = eq.idempotence();
			EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getLeft().getLast().getLineNumber() + 1, tree, null, null);
			getListener().updateLeftList(node);
			getListener().updateEquivalenceLeft();
		}
		
	}
	
	private class CommutativityListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			AndEquivalence eq = new AndEquivalence(getListener().getLeft().getLast().getTree(), getKey());
			AST tree = eq.commutativity();
			EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getLeft().getLast().getLineNumber() + 1, tree, null, null);
			getListener().updateLeftList(node);
			getListener().updateEquivalenceLeft();
		}
		
	}
	
	private class AssociativityLeftListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			AndEquivalence eq = new AndEquivalence(getListener().getLeft().getLast().getTree(), getKey());
			AST tree = eq.associativityLeft();
			EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getLeft().getLast().getLineNumber() + 1, tree, null, null);
			getListener().updateLeftList(node);
			getListener().updateEquivalenceLeft();
		}
		
	}

}
