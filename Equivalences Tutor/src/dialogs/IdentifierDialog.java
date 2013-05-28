package dialogs;

import java.awt.BorderLayout;

import gui.NewPersonalEquivalenceListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class IdentifierDialog extends JDialog {
	
	private JFrame frame;
	private JPanel panel;
	
	private NewPersonalEquivalenceListener listener;
	
	public IdentifierDialog(NewPersonalEquivalenceListener listener) {
		this.setListener(listener);
		this.setFrame(listener.getFrame());
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
		return button;
	}
	
	private JButton addAndIdempotence() {
		JButton button = new JButton("And Introduction: A = A \u2227 A");
		return button;
	}
	
	private JButton addOrIdempotence() {
		JButton button = new JButton("And Introduction: A = A \u2228 A");
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

}
