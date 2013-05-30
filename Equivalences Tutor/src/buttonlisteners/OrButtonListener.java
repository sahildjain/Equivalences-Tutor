package buttonlisteners;

import gui.NewPersonalEquivalenceListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.OrDialog;

public class OrButtonListener extends AbstractButtonListener implements ActionListener {

	private OrDialog dialog;
	
	public OrButtonListener(NewPersonalEquivalenceListener listener, int key, boolean side) {
		super(listener, key, side);
	}

	public void actionPerformed(ActionEvent e) {
		setDialog(new OrDialog(getListener(), getKey(), getSide()));
	}

	public OrDialog getDialog() {
		return dialog;
	}

	public void setDialog(OrDialog dialog) {
		this.dialog = dialog;
	}

}
