package buttonlisteners;

import gui.NewPersonalEquivalenceListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.IdentifierDialog;

public class IdentifierButtonListener extends AbstractButtonListener implements ActionListener {
	
	private IdentifierDialog dialog;
	
	public IdentifierButtonListener(NewPersonalEquivalenceListener listener, int key) {
		super(listener, key);
	}

	public void actionPerformed(ActionEvent e) {
		setDialog(new IdentifierDialog(getListener(), getKey()));
	}

	public IdentifierDialog getDialog() {
		return dialog;
	}

	public void setDialog(IdentifierDialog dialog) {
		this.dialog = dialog;
	}

}
