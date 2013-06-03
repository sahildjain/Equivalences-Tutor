package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import eqtutor.PropositionalExpressionGenerator;

public class RandomEquivalenceListener implements ActionListener {
	
	private JFrame frame;
	private JPanel menu;
	private int id;
	
	public RandomEquivalenceListener(JFrame frame, JPanel menu, int id) {
		this.setFrame(frame);
		this.setMenu(menu);
		this.setId(id);
	}

	public void actionPerformed(ActionEvent arg0) {
		/*EasyEquivalence eq = new EasyEquivalence(getFrame(), getMenu(), getId());
		PropositionalExpressionGenerator gen = new PropositionalExpressionGenerator();
		gen.generate();*/
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getMenu() {
		return menu;
	}

	public void setMenu(JPanel menu) {
		this.menu = menu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
