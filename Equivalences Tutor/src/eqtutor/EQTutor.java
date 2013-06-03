package eqtutor;

import java.io.PrintStream;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import AST.*;

public class EQTutor {
	
	/*public static void main(String[] args) throws FileNotFoundException {
		EQTutor eqtutor = new EQTutor(); 
		//String src = eqtutor.getFormula();
		String src = "a & b";
		System.out.println("Formula: " + src);
		System.out.println();
		LogicParser parser = eqtutor.getParser(src);
		AST tree = eqtutor.getTree(parser);
		eqtutor.printTreeToConsole(tree);
		System.out.println();
		System.out.println("performing a test equivalence");
		AndEquivalence andEquivalence = new AndEquivalence(tree, new ASTAndNode(new ASTIdentifierNode("a"), new ASTIdentifierNode("b")));
		AST newTree = andEquivalence.deMorgan();
		eqtutor.printTreeToConsole(newTree);
		
	}*/
	
	/*public String getFormula() {
		PropositionalExpressionGenerator formula = new PropositionalExpressionGenerator(4, 0);
		return formula.generate();
	}*/
	
	public LogicParser getParser(String src) {
		CharStream stream = new ANTLRStringStream(src);
		LogicLexer lexer = new LogicLexer(stream);
		TokenStream tokens = new CommonTokenStream(lexer);
		LogicParser parser = new LogicParser(tokens);
		return parser;
	}
	
	public AST getTree(LogicParser parser) {
		AST tree = null;
		try {
			tree = parser.program();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		return tree;
	}

	public static void printTreeToConsole(AST tree) {
		PrintStream p = System.out;
		ASTPrintVisitor printVisitor = new ASTPrintVisitor(p);
		tree.visit(printVisitor);
	}

}
