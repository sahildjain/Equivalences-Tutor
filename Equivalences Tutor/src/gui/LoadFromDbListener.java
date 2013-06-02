package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public LoadFromDbListener(JFrame frame, JPanel menu, int id) {
		this.setFrame(frame);
		this.setMenu(menu);
		this.setId(id);
	}
	
	public void actionPerformed(ActionEvent e) {
		getMenu().setVisible(false);
		ResultSet resultSet = EquivalencesDb.getEquivalencesForUser(getId());
		JPanel panel = createTable(resultSet);
		getFrame().add(panel, BorderLayout.NORTH);
	}
	
	private JPanel createTable(ResultSet resultSet) {
		JPanel panel = new JPanel(new MigLayout());
		JLabel start = new JLabel("Start State");
		JLabel end = new JLabel("End State");
		JPanel temp1 = new JPanel(new MigLayout());
		JPanel temp2 = new JPanel(new MigLayout());
		temp1.add(start, BorderLayout.NORTH);
		temp2.add(end, BorderLayout.NORTH);
		int num = EquivalencesDb.getNumberOfEquivalencesForUser(getId());
		for(int i = 0; i < num; ++i) {
			try {
				resultSet.next();
				String left = resultSet.getString("lefteq");
				String right = resultSet.getString("righteq");
				EquivalenceLinkedList leftList = createLinkedList(left);
				EquivalenceLinkedList rightList = createLinkedList(right);
				String startState = leftList.getHead().getTree().toString();
				String endState = rightList.getHead().getTree().toString();
				JLabel s = new JLabel(startState);
				JLabel e = new JLabel(endState);
				temp1.add(s, BorderLayout.NORTH);
			    temp2.add(e, BorderLayout.NORTH);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		panel.add(temp1, BorderLayout.WEST);
		panel.add(new JPanel(new MigLayout()), BorderLayout.WEST);
		panel.add(temp2, BorderLayout.WEST);
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

}
