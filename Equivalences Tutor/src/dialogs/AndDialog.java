package dialogs;

import gui.NewPersonalEquivalenceListener;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	
	private JPanel addIdempotence() {
		JPanel tempPanel = new JPanel(new MigLayout());
		JLabel tempLabel = new JLabel("Idempotence: A \u2227 A = A");
		JButton select = new JButton("Select");
		tempPanel.add(tempLabel, BorderLayout.WEST);
		tempPanel.add(new JPanel(new MigLayout()), BorderLayout.CENTER);
		tempPanel.add(select, BorderLayout.EAST);
		return tempPanel;
	}
	
	private JPanel addCommutativity() {
		JPanel tempPanel = new JPanel(new MigLayout());
		JLabel tempLabel = new JLabel("Commutativity: A \u2227 B = B \u2227 A");
		JButton select = new JButton("Select");
		tempPanel.add(tempLabel, BorderLayout.WEST);
		tempPanel.add(new JPanel(new MigLayout()), BorderLayout.CENTER);
		tempPanel.add(select, BorderLayout.EAST);
		return tempPanel;
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
