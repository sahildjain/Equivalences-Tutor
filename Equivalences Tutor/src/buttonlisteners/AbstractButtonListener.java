package buttonlisteners;

import gui.NewPersonalEquivalenceListener;

public abstract class AbstractButtonListener {
	
	private int key;
	private NewPersonalEquivalenceListener listener;
	
	public AbstractButtonListener(NewPersonalEquivalenceListener listener, int key) {
		this.setKey(key);
		this.setListener(listener);
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

}
