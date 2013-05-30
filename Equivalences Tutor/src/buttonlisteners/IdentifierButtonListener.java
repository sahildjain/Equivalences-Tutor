package buttonlisteners;

import gui.NewPersonalEquivalenceListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.IdentifierDialog;

public class IdentifierButtonListener extends AbstractButtonListener implements ActionListener {
	
	private IdentifierDialog dialog;
	
	public IdentifierButtonListener(NewPersonalEquivalenceListener listener, int key, boolean side) {
		super(listener, key, side);
	}

	public void actionPerformed(ActionEvent e) {
		setDialog(new IdentifierDialog(getListener(), getKey(), getSide()));
	}

	public IdentifierDialog getDialog() {
		return dialog;
	}

	public void setDialog(IdentifierDialog dialog) {
		this.dialog = dialog;
	}

}
