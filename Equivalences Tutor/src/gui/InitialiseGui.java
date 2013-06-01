package gui;

import eqtutor.EQTutor;
import eqtutor.LogicParser;
import AST.AST;

public class InitialiseGui {
	
	public static void main(final String[] args){
		/*String content = "/left size= 1\n(a ∧ b)\n\n/right size= 1\n(b ∧ a)\n";
		String[] tokens = content.split("\n");
		for(int i = 0; i < tokens.length; ++i) {
			System.out.println(i + ": " + tokens[i]);
		}*/
		EQTutor eqtutor = new EQTutor(); 
		String src = "a & a";
		LogicParser parser = eqtutor.getParser(src);
		AST tree1 = eqtutor.getTree(parser);
		src = "a";
		parser = eqtutor.getParser(src);
		AST tree2 = eqtutor.getTree(parser);
		System.out.println(tree1.equivalent(tree2));
		/*
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				final Gui gui = new Gui();
				gui.createGui(20);
			}
		});*/
	}
}