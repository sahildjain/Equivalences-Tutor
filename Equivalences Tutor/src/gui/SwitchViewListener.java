package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchViewListener implements ActionListener {
	
	private NewPersonalEquivalenceListener listener;
	private boolean easy;
	
	public SwitchViewListener(NewPersonalEquivalenceListener listener) {
		this.setListener(listener);
		if(listener instanceof HardEquivalence) {
			this.setEasy(false);
		}
		if(listener instanceof EasyEquivalence) {
			this.setEasy(true);
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		NewPersonalEquivalenceListener eq;
		if(isEasy()) {
			eq = new HardEquivalence(getListener().getFrame(), getListener().getMenu(), getListener().getId());
		}
		else {
			eq = new EasyEquivalence(getListener().getFrame(), getListener().getMenu(), getListener().getId());
		}
		getListener().getEquivalence().setVisible(false);
		getListener().getButtons().setVisible(false);
		eq.createEquivalencePanel();
		eq.createButtonsPanel();
		getListener().getFrame().add(eq.getEquivalence(), BorderLayout.NORTH);
		getListener().getFrame().add(eq.getButtons(), BorderLayout.SOUTH);
		eq.setLeft(getListener().getLeft());
		eq.setRight(getListener().getRight());
		eq.updateEquivalenceLeft();
		eq.updateEquivalenceRight();
	}

	public NewPersonalEquivalenceListener getListener() {
		return listener;
	}

	public void setListener(NewPersonalEquivalenceListener listener) {
		this.listener = listener;
	}

	public boolean isEasy() {
		return easy;
	}

	public void setEasy(boolean easy) {
		this.easy = easy;
	}

}
