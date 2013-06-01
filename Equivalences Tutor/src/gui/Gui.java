package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import database.RegisterDb;

import net.miginfocom.swing.MigLayout;

public class Gui {
	
	private JFrame frame;
	
	private JPanel menu;
	private JPanel login;
	private JPanel register;
	
	private JButton hardEquivalence;
	private JButton easyEquivalence;
	private JButton quit;
	private JButton loadEquivalence;
	
	private JTextField user;
	private JTextField pass;
	
	public void createGui(int size) {
		createFrame("Equivalences Tutor", size);
		createLoginPanel();
		addLoginToFrame();
		//createMenuPanel();
		//addToFrame();
	}

	private void addLoginToFrame() {
		frame.add(login, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void addMenuToFrame() {
		frame.add(menu, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void createLoginPanel() {
		login = new JPanel(new MigLayout());
		JPanel username = new JPanel(new MigLayout());
		JPanel password = new JPanel(new MigLayout());
		JLabel u = new JLabel("Username");
		JLabel p = new JLabel("Password");
	    user = new JTextField(25);
		pass = new JTextField(25);
		username.add(u, BorderLayout.WEST);
		username.add(user, BorderLayout.WEST);
		password.add(p, BorderLayout.WEST);
		password.add(pass, BorderLayout.WEST);
		JButton submit = new JButton("Submit");
		JButton register = new JButton("Register");
		RegisterListener regListener = new RegisterListener();
		register.addActionListener(regListener);
		login.add(username, BorderLayout.NORTH);
		login.add(password, BorderLayout.NORTH);
		login.add(submit, BorderLayout.SOUTH);
		login.add(register, BorderLayout.SOUTH);
	}
	
	private void createMenuPanel() {
		menu = new JPanel(new MigLayout());
		hardEquivalence = new JButton("Hard Personal Equivalence");
		HardEquivalence listener = new HardEquivalence(frame, menu);
		hardEquivalence.addActionListener(listener);
		easyEquivalence = new JButton("Easy Personal Equivalence");
		EasyEquivalence easyListener = new EasyEquivalence(frame, menu);
		easyEquivalence.addActionListener(easyListener);
		loadEquivalence = new JButton("Load Equivalence From File");
		LoadFromFileListener loadListener = new LoadFromFileListener(loadEquivalence);
		loadEquivalence.addActionListener(loadListener);
		quit = new JButton("Quit");
		QuitListener quitListener = new QuitListener();
		quit.addActionListener(quitListener);
		menu.add(easyEquivalence, BorderLayout.NORTH);
		menu.add(hardEquivalence, BorderLayout.NORTH);
		menu.add(loadEquivalence, BorderLayout.NORTH);
		menu.add(quit, BorderLayout.SOUTH);
	}

	private void createFrame(String string, int size) {
		frame = new JFrame(string);
		frame.setSize(size * 50, size * 40);
	}
	
	private class RegisterListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			login.setVisible(false);
			register = new JPanel(new MigLayout());
			JPanel username = new JPanel(new MigLayout());
			JPanel password = new JPanel(new MigLayout());
			JLabel u = new JLabel("Username");
			JLabel p = new JLabel("Password");
			user = new JTextField(25);
			pass = new JTextField(25);
			username.add(u, BorderLayout.WEST);
			username.add(user, BorderLayout.WEST);
			password.add(p, BorderLayout.WEST);
			password.add(pass, BorderLayout.WEST);
			JButton submit = new JButton("Submit");
			SubmitListener listener = new SubmitListener(false);
			submit.addActionListener(listener);
			register.add(username, BorderLayout.NORTH);
			register.add(password, BorderLayout.NORTH);
			register.add(submit, BorderLayout.SOUTH);
			frame.add(register);
		}
		
	}
	
	private class SubmitListener implements ActionListener {

		private boolean login;
		
		public SubmitListener(boolean login) {
			this.login = login;
		}
		
		public void actionPerformed(ActionEvent arg0) {
			if(login) {
				
			}
			if(!login) {
				RegisterDb.addUser(user.getText(), pass.getText());
			}
		}
		
		
	}

}
