package buttonlisteners;

import gui.NewPersonalEquivalenceListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.ForAllDialog;

public class ForAllButtonListener extends AbstractButtonListener implements ActionListener {

	private ForAllDialog dialog;
	
	public ForAllButtonListener(NewPersonalEquivalenceListener listener, int key, boolean side) {
		super(listener, key, side);
	}

	public void actionPerformed(ActionEvent e) {
		setDialog(new ForAllDialog(getListener(), getKey(), getSide()));
	}

	public ForAllDialog getDialog() {
		return dialog;
	}

	public void setDialog(ForAllDialog dialog) {
		this.dialog = dialog;
	}


}
