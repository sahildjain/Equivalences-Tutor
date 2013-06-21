package buttonlisteners;

import gui.NewPersonalEquivalenceListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.TruthDialog;

public class TruthButtonListener extends AbstractButtonListener implements ActionListener {

	private TruthDialog dialog;
	
	public TruthButtonListener(NewPersonalEquivalenceListener listener, int key, boolean side) {
		super(listener, key, side);
	}

	public void actionPerformed(ActionEvent e) {
		setDialog(new TruthDialog(getListener(), getKey(), getSide()));
	}

	public TruthDialog getDialog() {
		return dialog;
	}

	public void setDialog(TruthDialog dialog) {
		this.dialog = dialog;
	}
	
}
