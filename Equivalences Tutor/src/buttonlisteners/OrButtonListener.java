package buttonlisteners;

import gui.NewPersonalEquivalenceListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.OrDialog;

public class OrButtonListener implements ActionListener {
	
	private NewPersonalEquivalenceListener listener;
	private int key;
	
	public OrButtonListener(NewPersonalEquivalenceListener listener, int key) {
		this.setListener(listener);
		this.setKey(key);
	}

	public void actionPerformed(ActionEvent e) {
		OrDialog dialog = new OrDialog(listener);
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public NewPersonalEquivalenceListener getListener() {
		return listener;
	}

	public void setListener(NewPersonalEquivalenceListener listener) {
		this.listener = listener;
	}

}
