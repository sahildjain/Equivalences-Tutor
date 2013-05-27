package buttonlisteners;

import gui.NewPersonalEquivalenceListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.IdentifierDialog;

public class IdentifierButtonListener implements ActionListener {
	
	private int key;
	private NewPersonalEquivalenceListener listener;
	private IdentifierDialog dialog;
	
	public IdentifierButtonListener(NewPersonalEquivalenceListener listener, int key) {
		this.setListener(listener);
		this.setKey(key);
	}

	public void actionPerformed(ActionEvent e) {
		setDialog(new IdentifierDialog(listener));
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

	public IdentifierDialog getDialog() {
		return dialog;
	}

	public void setDialog(IdentifierDialog dialog) {
		this.dialog = dialog;
	}

}
