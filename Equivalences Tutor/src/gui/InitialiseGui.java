package gui;

public class InitialiseGui {
	
	public static void main(final String[] args){
		/*String content = "/left size= 1\n(a ∧ b)\n\n/right size= 1\n(b ∧ a)\n";
		String[] tokens = content.split("\n");
		for(int i = 0; i < tokens.length; ++i) {
			System.out.println(i + ": " + tokens[i]);
		}*/
		/*
		EQTutor eqtutor = new EQTutor(); 
		String src = "(B)";
		LogicParser parser = eqtutor.getParser(src);
		AST tree1 = eqtutor.getTree(parser);
		System.out.println(tree1.toString());
		*/
		/*
		PropositionalExpressionGenerator gen = new PropositionalExpressionGenerator();
		gen.generate();
		*/
		
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				final Gui gui = new Gui();
				gui.createGui(20);
			}
		});
		
	}
}