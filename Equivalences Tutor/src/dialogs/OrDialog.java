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
	
	private JPanel addIdempotence() {
		JPanel tempPanel = new JPanel(new MigLayout());
		JLabel tempLabel = new JLabel("Idempotence: A \u2228 A = A");
		JButton select = new JButton("Select");
		tempPanel.add(tempLabel, BorderLayout.WEST);
		tempPanel.add(new JPanel(new MigLayout()), BorderLayout.CENTER);
		tempPanel.add(select, BorderLayout.EAST);
		return tempPanel;
	}
	
	private JPanel addCommutativity() {
		JPanel tempPanel = new JPanel(new MigLayout());
		JLabel tempLabel = new JLabel("Commutativity: A \u2228 B = B \u2228 A");
		JButton select = new JButton("Select");
		tempPanel.add(tempLabel, BorderLayout.WEST);
		tempPanel.add(new JPanel(new MigLayout()), BorderLayout.CENTER);
		tempPanel.add(select, BorderLayout.EAST);
		return tempPanel;
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
