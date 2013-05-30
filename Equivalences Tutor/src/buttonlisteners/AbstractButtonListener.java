package buttonlisteners;

import gui.NewPersonalEquivalenceListener;

public abstract class AbstractButtonListener {
	
	private int key;
	private NewPersonalEquivalenceListener listener;
	private boolean side;
	
	public AbstractButtonListener(NewPersonalEquivalenceListener listener, int key, boolean side) {
		this.setKey(key);
		this.setListener(listener);
		this.setSide(side);
	}

	public NewPersonalEquivalenceListener getListener() {
		return listener;
	}

	public void setListener(NewPersonalEquivalenceListener listener) {
		this.listener = listener;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public boolean getSide() {
		return side;
	}

	public void setSide(boolean side) {
		this.side = side;
	}

}
