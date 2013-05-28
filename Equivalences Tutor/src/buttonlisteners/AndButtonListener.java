package buttonlisteners;

import gui.NewPersonalEquivalenceListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.AndDialog;

public class AndButtonListener extends AbstractButtonListener implements ActionListener {
	
	private AndDialog dialog;
	
	public AndButtonListener(NewPersonalEquivalenceListener listener, int key) {
		super(listener, key);
	}

	public void actionPerformed(ActionEvent e) {
		setDialog(new AndDialog(getListener()));
	}

	public AndDialog getDialog() {
		return dialog;
	}

	public void setDialog(AndDialog dialog) {
		this.dialog = dialog;
	}

}
