package buttonlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IfButtonListener implements ActionListener {
	
	private int key;
	
	public IfButtonListener(int key) {
		this.setKey(key);
	}

	public void actionPerformed(ActionEvent e) {
		
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

}
