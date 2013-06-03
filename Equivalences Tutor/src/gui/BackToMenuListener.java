package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackToMenuListener implements ActionListener {
	
	private NewPersonalEquivalenceListener listener;
	
	public BackToMenuListener(NewPersonalEquivalenceListener listener) {
		this.setListener(listener);
	}

	public void actionPerformed(ActionEvent arg0) {
		getListener().getEquivalence().setVisible(false);
		getListener().getButtons().setVisible(false);
		getListener().getMenu().setVisible(true);
	}

	public NewPersonalEquivalenceListener getListener() {
		return listener;
	}

	public void setListener(NewPersonalEquivalenceListener listener) {
		this.listener = listener;
	}

}
