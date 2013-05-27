package buttonlisteners;

import gui.NewPersonalEquivalenceListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.NotDialog;

public class NotButtonListener implements ActionListener {
	
	private int key;
	private NewPersonalEquivalenceListener listener;
	private NotDialog dialog;
	
	public NotButtonListener(NewPersonalEquivalenceListener listener, int key) {
		this.setListener(listener);
		this.setKey(key);
	}

	public void actionPerformed(ActionEvent e) {
		setDialog(new NotDialog(listener));
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

	public NotDialog getDialog() {
		return dialog;
	}

	public void setDialog(NotDialog dialog) {
		this.dialog = dialog;
	}

}
