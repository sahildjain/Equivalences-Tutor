package buttonlisteners;

import gui.NewPersonalEquivalenceListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.AndDialog;

public class AndButtonListener implements ActionListener {
	
	private int key;
	private NewPersonalEquivalenceListener listener;
	private AndDialog dialog;
	
	public AndButtonListener(NewPersonalEquivalenceListener listener, int key) {
		this.setKey(key);
		this.listener = listener;
	}

	public void actionPerformed(ActionEvent e) {
		setDialog(new AndDialog(listener));
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public AndDialog getDialog() {
		return dialog;
	}

	public void setDialog(AndDialog dialog) {
		this.dialog = dialog;
	}

}
