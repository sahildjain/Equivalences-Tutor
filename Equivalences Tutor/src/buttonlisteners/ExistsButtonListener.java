package buttonlisteners;

import gui.NewPersonalEquivalenceListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.ExistsDialog;


public class ExistsButtonListener extends AbstractButtonListener implements ActionListener {
	
	private ExistsDialog dialog;
	
	public ExistsButtonListener(NewPersonalEquivalenceListener listener, int key, boolean side) {
		super(listener, key, side);
	}

	public void actionPerformed(ActionEvent e) {
		setDialog(new ExistsDialog(getListener(), getKey(), getSide()));
	}

	public ExistsDialog getDialog() {
		return dialog;
	}

	public void setDialog(ExistsDialog dialog) {
		this.dialog = dialog;
	}

}
