package dialogs;

import java.awt.BorderLayout;

import gui.NewPersonalEquivalenceListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class NotDialog extends JDialog {
	
	private JFrame frame;
	private JPanel panel;
	
	private NewPersonalEquivalenceListener listener;
	
	public NotDialog(NewPersonalEquivalenceListener listener) {
		this.setListener(listener);
		this.setFrame(listener.getFrame());
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
		return button;
	}
	
	private JButton addDemorganAnd() {
		JButton button = new JButton("DeMorgan And: \u00AC(A \u2227 B) = \u00ACA \u2228 \u00ACB");
		return button;
	}
	
	private JButton addDemorganOr() {
		JButton button = new JButton("DeMorgan Or: \u00AC(A \u2228 B) = \u00ACA \u2227 \u00ACB");
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

}
