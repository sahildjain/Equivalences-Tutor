package dialogs;

import gui.NewPersonalEquivalenceListener;

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
		//panel.add(addIdempotence(), BorderLayout.NORTH);
		//panel.add(addCommutativity(), BorderLayout.NORTH);
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(getFrame());
		setVisible(true);
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
