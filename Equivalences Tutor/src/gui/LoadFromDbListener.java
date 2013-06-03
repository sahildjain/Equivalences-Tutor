package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import AST.AST;


import database.EquivalencesDb;
import eqtutor.EQTutor;
import eqtutor.LogicParser;
import equivalence.EquivalenceLinkNode;
import equivalence.EquivalenceLinkedList;

public class LoadFromDbListener implements ActionListener {
	
	private int id;
	private JFrame frame;
	private JPanel menu;
	private EquivalenceLinkedList left;
	private EquivalenceLinkedList right;
	private JPanel panel;
	
	public LoadFromDbListener(JFrame frame, JPanel menu, int id) {
		this.setFrame(frame);
		this.setMenu(menu);
		this.setId(id);
	}
	
	public void actionPerformed(ActionEvent e) {
		getMenu().setVisible(false);
		ResultSet resultSet = EquivalencesDb.getEquivalencesForUser(getId());
		JPanel panel = createTable(resultSet);
		setPanel(panel);
		getFrame().add(panel, BorderLayout.NORTH);
	}
	
	private JPanel createTable(ResultSet resultSet) {
		JPanel panel = new JPanel(new MigLayout());
		JLabel start = new JLabel("Start State");
		JLabel end = new JLabel("End State");
		JLabel load = new JLabel("Load");
		JPanel temp1 = new JPanel(new MigLayout());
		JPanel temp2 = new JPanel(new MigLayout());
		JPanel temp3 = new JPanel(new MigLayout());
		temp1.add(start, BorderLayout.NORTH);
		temp2.add(end, BorderLayout.NORTH);
		temp3.add(load, BorderLayout.NORTH);
		int num = EquivalencesDb.getNumberOfEquivalencesForUser(getId());
		for(int i = 0; i < num; ++i) {
			try {
				resultSet.next();
				String left = resultSet.getString("lefteq");
				String right = resultSet.getString("righteq");
				EquivalenceLinkedList leftList = createLinkedList(left);
				setLeft(leftList);
				EquivalenceLinkedList rightList = createLinkedList(right);
				setRight(rightList);
				String startState = leftList.getHead().getTree().toString();
				String endState = rightList.getHead().getTree().toString();
				JLabel s = new JLabel(startState);
				JLabel e = new JLabel(endState);
				JButton button = new JButton("Go");
				//button.setFont(new Font("Arial", Font.BOLD, 12));
				button.setOpaque(false);
				button.setContentAreaFilled(false);
				button.setBorderPainted(false);
				GoListener listener = new GoListener();
				button.addActionListener(listener);
				temp1.add(new JPanel(new MigLayout()), BorderLayout.NORTH);
				temp2.add(new JPanel(new MigLayout()), BorderLayout.NORTH);
				//temp3.add(new JPanel(new MigLayout()), BorderLayout.NORTH);
				temp1.add(s, BorderLayout.NORTH);
			    temp2.add(e, BorderLayout.NORTH);
			    temp3.add(button, BorderLayout.NORTH);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		panel.add(temp1, BorderLayout.WEST);
		panel.add(new JPanel(new MigLayout()), BorderLayout.WEST);
		panel.add(temp2, BorderLayout.WEST);
		panel.add(new JPanel(new MigLayout()), BorderLayout.WEST);
		panel.add(temp3, BorderLayout.WEST);
		return panel;
	}
	
	private EquivalenceLinkedList createLinkedList(String side) {
		EquivalenceLinkedList list = new EquivalenceLinkedList();
		String[] tokens = side.split("\\.");
		for(int i = 0; i < tokens.length; ++i) {
			String token = tokens[i];
			EQTutor eqtutor = new EQTutor(); 
			LogicParser parser = eqtutor.getParser(token);
			AST tree = eqtutor.getTree(parser);
			EquivalenceLinkNode node = new EquivalenceLinkNode(list.getSize() + 1, tree, null, null);
			list.add(node);
		}
		return list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public EquivalenceLinkedList getLeft() {
		return this.left;
	}
	
	public void setLeft(EquivalenceLinkedList left) {
		this.left = left;
	}
	
	public EquivalenceLinkedList getRight() {
		return this.right;
	}
	
	public void setRight(EquivalenceLinkedList right) {
		this.right = right;
	}
	
	public JPanel getPanel() {
		return this.panel;
	}
	
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	private class GoListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			getPanel().setVisible(false);
			EasyEquivalence eq = new EasyEquivalence(getFrame(), getMenu(), getId());
			eq.createEquivalencePanel();
			eq.createButtonsPanel();
			frame.add(eq.getEquivalence(), BorderLayout.NORTH);
			frame.add(eq.getButtons(), BorderLayout.SOUTH);
			eq.setLeft(getLeft());
			eq.setRight(getRight());
			eq.updateEquivalenceLeft();
			eq.updateEquivalenceRight();
		}
		
	}

}
