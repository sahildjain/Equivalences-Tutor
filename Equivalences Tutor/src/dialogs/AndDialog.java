package dialogs;

import gui.NewPersonalEquivalenceListener;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class AndDialog extends JDialog {
	
	private JFrame frame;
	
	private JPanel panel;
	
	private NewPersonalEquivalenceListener listener;
	
	public AndDialog(NewPersonalEquivalenceListener listener) {
		this.setListener(listener);
		this.setFrame(listener.getFrame());
		panel = new JPanel(new MigLayout());
		panel.add(addIdempotence(), BorderLayout.NORTH);
		panel.add(addCommutativity(), BorderLayout.NORTH);
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(getFrame());
		setVisible(true);
	}
	
	private JButton addIdempotence() {
		JButton button = new JButton("Idempotence: A \u2227 A = A");
		return button;
	}
	
	private JButton addCommutativity() {
		JButton button = new JButton("Commutativity: A \u2227 B = B \u2227 A");
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
