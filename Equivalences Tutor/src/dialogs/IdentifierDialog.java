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
import javax.swing.JPanel;

import AST.AST;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class IdentifierDialog extends JDialog {
	
	private JFrame frame;
	private JPanel panel;
	private NewPersonalEquivalenceListener listener;
	private int key;
	
	public IdentifierDialog(NewPersonalEquivalenceListener listener, int key) {
		this.setListener(listener);
		this.setFrame(listener.getFrame());
		this.setKey(key);
		panel = new JPanel(new MigLayout());
		panel.add(addDoubleNegation(), BorderLayout.NORTH);
		panel.add(addAndIdempotence(), BorderLayout.NORTH);
		panel.add(addOrIdempotence(), BorderLayout.NORTH);
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

	private class DoubleNegationListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			IdentifierEquivalence eq = new IdentifierEquivalence(getListener().getLeft().getLast().getTree(), getKey());
			AST tree = eq.doubleNegation();
			EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getLeft().getLast().getLineNumber() + 1, tree, null, null);
			getListener().updateLeftList(node);
			getListener().updateEquivalenceLeft();
		}
		
	}
	
	private class AndIdempotenceListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			IdentifierEquivalence eq = new IdentifierEquivalence(getListener().getLeft().getLast().getTree(), getKey());
			AST tree = eq.andIdempotence();
			EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getLeft().getLast().getLineNumber() + 1, tree, null, null);
			getListener().updateLeftList(node);
			getListener().updateEquivalenceLeft();
		}
		
	}
	
	private class OrIdempotenceListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			IdentifierEquivalence eq = new IdentifierEquivalence(getListener().getLeft().getLast().getTree(), getKey());
			AST tree = eq.orIdempotence();
			EquivalenceLinkNode node = new EquivalenceLinkNode(getListener().getLeft().getLast().getLineNumber() + 1, tree, null, null);
			getListener().updateLeftList(node);
			getListener().updateEquivalenceLeft();
		}
		
	}

}
