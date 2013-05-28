package dialogs;

import java.awt.BorderLayout;

import gui.NewPersonalEquivalenceListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class IffDialog extends JDialog {
	
	private JFrame frame;
	private JPanel panel;
	
	private NewPersonalEquivalenceListener listener;
	
	public IffDialog(NewPersonalEquivalenceListener listener) {
		this.setListener(listener);
		this.setFrame(listener.getFrame());
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
		return button;
	}
	
	// A <-> B = (A & B) | (!A & !B)
	private JButton addIffToOr() {
		JButton button = new JButton("A \u2194 B = (A \u2227 B) \u2228 (\u00ACA \u2227 \u00ACB)");
		return button;
	}
	
	// A <-> B = !A <-> !B
	private JButton addNots() {
		JButton button = new JButton("A \u2194 B = \u00ACA \u2194 \u00ACB");
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
