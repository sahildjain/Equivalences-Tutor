package buttonlisteners;

import gui.NewPersonalEquivalenceListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.NotDialog;

public class NotButtonListener extends AbstractButtonListener implements ActionListener {
	
	private NotDialog dialog;
	
	public NotButtonListener(NewPersonalEquivalenceListener listener, int key, boolean side) {
		super(listener, key, side);
	}

	public void actionPerformed(ActionEvent e) {
		setDialog(new NotDialog(getListener(), getKey(), getSide()));
	}

	public NotDialog getDialog() {
		return dialog;
	}

	public void setDialog(NotDialog dialog) {
		this.dialog = dialog;
	}

}
