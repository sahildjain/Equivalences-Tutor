package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import equivalence.EquivalenceLinkNode;
import equivalence.EquivalenceLinkedList;

public class SaveToFileListener implements ActionListener {
	
	private NewPersonalEquivalenceListener listener;
	private EquivalenceLinkedList left;
	private EquivalenceLinkedList right;
	private StringBuilder fileContent;
	
	public SaveToFileListener(NewPersonalEquivalenceListener listener) {
		this.setListener(listener);
		this.setLeft(getListener().getLeft());
		this.setRight(getListener().getRight());
	}

	public void actionPerformed(ActionEvent e) {
		createFileContent();
		String content = getFileContent().toString();
		System.out.println(content);
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File ("./"));
		int actionDialog = chooser.showSaveDialog(this.getListener().saveButton);
		if(actionDialog == JFileChooser.APPROVE_OPTION) {
			File fileName = new File(chooser.getSelectedFile() + "");
			/*if(fileName == null) {
				return;
			}*/
			if(fileName.exists()) {
				actionDialog = JOptionPane.showConfirmDialog(this.getListener().saveButton, "Replace existing file?");
				if(actionDialog == JOptionPane.NO_OPTION) {
					return;
				}
			}
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
				out.write(content);
				out.close();
			}
			catch(Exception e1) {
				System.err.println("Error: " + e1.getMessage());
			}
		}
	}
	
	private void createFileContent() {
		StringBuilder fileContent = new StringBuilder();
		
		//Left side
		EquivalenceLinkedList left = getLeft();
		fileContent.append("/left " + "size= " + left.getSize() +"\n");
		EquivalenceLinkNode curr = left.getHead();
		while(curr != null) {
			fileContent.append(curr.getTree().toString());
			fileContent.append("\n");
			curr = curr.getNext();
		}
		fileContent.append("\n");
		
		//Right side
		EquivalenceLinkedList right = getRight();
		fileContent.append("/right " + "size= " + right.getSize() + "\n");
		curr = right.getHead();
		while(curr != null) {
			fileContent.append(curr.getTree().toString());
			fileContent.append("\n");
			curr = curr.getNext();
		}
		
		this.setFileContent(fileContent);
		
	}

	public NewPersonalEquivalenceListener getListener() {
		return listener;
	}

	public void setListener(NewPersonalEquivalenceListener listener) {
		this.listener = listener;
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

	public StringBuilder getFileContent() {
		return fileContent;
	}

	public void setFileContent(StringBuilder fileContent) {
		this.fileContent = fileContent;
	}

}
