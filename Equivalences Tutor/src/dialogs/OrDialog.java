package dialogs;

import java.awt.BorderLayout;

import gui.NewPersonalEquivalenceListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class OrDialog extends JDialog {
	
	private JFrame frame;
	
	private JPanel panel;
	private JPanel filler;
	
	private NewPersonalEquivalenceListener listener;
	
	public OrDialog(NewPersonalEquivalenceListener listener) {
		this.setListener(listener);
		this.setFrame(listener.getFrame());
		filler = new JPanel(new MigLayout());
		panel = new JPanel(new MigLayout());
		panel.add(addIdempotence());
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(getFrame());
		setVisible(true);
	}
	
	private JPanel addIdempotence() {
		JPanel idempotencePanel = new JPanel(new MigLayout());
		JLabel idempotenceLabel = new JLabel("Idempotence: A | A = A");
		JButton idempotenceButton = new JButton("SELECT");
		idempotencePanel.add(idempotenceLabel, BorderLayout.WEST);
		idempotencePanel.add(filler, BorderLayout.CENTER);
		idempotencePanel.add(idempotenceButton, BorderLayout.EAST);
		return idempotencePanel;
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
