package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import AST.AST;

import eqtutor.EQTutor;
import eqtutor.LogicParser;
import equivalence.EquivalenceLinkedList;
import equivalence.EquivalenceLinkNode;

public class LoadEquivalenceListener implements ActionListener {
	
	private JButton load;
	private String fileContent;
	private EquivalenceLinkedList left;
	private EquivalenceLinkedList right;
	
	public LoadEquivalenceListener(JButton load) {
		this.setLoad(load);
	}

	public void actionPerformed(ActionEvent e) {
		JFileChooser c = new JFileChooser();
		int rVal = c.showOpenDialog(getLoad());
		if(rVal == JFileChooser.APPROVE_OPTION) {
			File file = c.getSelectedFile();
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				StringBuilder sb = new StringBuilder();
				String line;
				while((line = reader.readLine()) != null) {
					sb.append(line);
					sb.append("\n");
				}
				reader.close();
				setFileContent(sb.toString());
			} 
			catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		parse();
	}

	private void parse() {
		EQTutor eqtutor = new EQTutor();
		String fileContent = getFileContent();
		String[] tokens = fileContent.split("\n");
		int i = 0;
		String token = tokens[i];
		AST tree;
		LogicParser parser;
		
		while(!token.equals("")) {
			EquivalenceLinkedList left = new EquivalenceLinkedList();
			if(token.charAt(0) != '/') {
				parser = eqtutor.getParser(token);
				tree = eqtutor.getTree(parser);
				EquivalenceLinkNode node = new EquivalenceLinkNode(left.getSize() + 1, tree, null, null);
				left.add(node);
			}
			++i;
		}
		setLeft(left);
		
		while(i < tokens.length) {
			EquivalenceLinkedList right = new EquivalenceLinkedList();
			if(token.charAt(0) != '/') {
				parser = eqtutor.getParser(token);
				tree = eqtutor.getTree(parser);
				EquivalenceLinkNode node = new EquivalenceLinkNode(right.getSize() + 1, tree, null, null);
				right.add(node);
			}
			++i;
		}
		setRight(right);
	}
	
	public JButton getLoad() {
		return this.load;
	}
	
	public void setLoad(JButton load) {
		this.load = load;
	}
	
	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	public EquivalenceLinkedList getLeft() {
		return left;
	}

	public void setLeft(EquivalenceLinkedList left) {
		this.left = left;
	}

	public EquivalenceLinkedList getRight() {
		return right;
	}

	public void setRight(EquivalenceLinkedList right) {
		this.right = right;
	}

}
