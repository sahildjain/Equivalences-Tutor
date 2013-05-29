package buttonlisteners;

import gui.NewPersonalEquivalenceListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.IfDialog;

public class IfButtonListener extends AbstractButtonListener implements ActionListener {
	
	private IfDialog dialog;
	
	public IfButtonListener(NewPersonalEquivalenceListener listener, int key) {
		super(listener, key);
	}

	public void actionPerformed(ActionEvent e) {
		setDialog(new IfDialog(getListener(), getKey()));
	}

	public IfDialog getDialog() {
		return dialog;
	}

	public void setDialog(IfDialog dialog) {
		this.dialog = dialog;
	}

}
