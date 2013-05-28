package dialogs;

import java.awt.BorderLayout;

import gui.NewPersonalEquivalenceListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class IfDialog extends JDialog {
	
	private JFrame frame;
	private JPanel panel;
	
	private NewPersonalEquivalenceListener listener;
	
	public IfDialog(NewPersonalEquivalenceListener listener) {
		this.setListener(listener);
		this.setFrame(listener.getFrame());
		panel = new JPanel(new MigLayout());
		panel.add(addIfToOr(), BorderLayout.NORTH);
		panel.add(addIfToAnd(), BorderLayout.NORTH);
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(getFrame());
		setVisible(true);
	}
	
	private JButton addIfToOr() {
		JButton button = new JButton("A \u2192 B = !A \u2228 B");
		return button;
	}
	
	private JButton addIfToAnd() {
		JButton button = new JButton("A \u2192 B = \u00AC(A \u2227 !B)");
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
