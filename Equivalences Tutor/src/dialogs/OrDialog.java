package dialogs;

import java.awt.BorderLayout;

import gui.NewPersonalEquivalenceListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class OrDialog extends JDialog {
	
	private JFrame frame;
	
	private JPanel panel;
	
	private NewPersonalEquivalenceListener listener;
	
	public OrDialog(NewPersonalEquivalenceListener listener) {
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
		JButton button = new JButton("Idempotence: A \u2228 A = A");
		return button;
	}
	
	private JButton addCommutativity() {
		JButton button = new JButton("Commutativity: A \u2228 B = B \u2228 A");
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

}
