package buttonlisteners;

import gui.NewPersonalEquivalenceListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.IffDialog;

public class IffButtonListener extends AbstractButtonListener implements ActionListener {
	
	private IffDialog dialog;
	
	public IffButtonListener(NewPersonalEquivalenceListener listener, int key, boolean side) {
		super(listener, key, side);
	}

	public void actionPerformed(ActionEvent e) {
		setDialog(new IffDialog(getListener(), getKey(), getSide()));
	}

	public IffDialog getDialog() {
		return dialog;
	}

	public void setDialog(IffDialog dialog) {
		this.dialog = dialog;
	}

}
