package eqtutor;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import equivalence.NodeEquivalence;

import AST.*;

public class EQTutor {
	
	public static void main(String[] args) throws FileNotFoundException {
		EQTutor eqtutor = new EQTutor(); 
		//String src = eqtutor.getFormula();
		String src = "a -> !b";
		System.out.println("Formula: " + src);
		System.out.println();
		LogicParser parser = eqtutor.getParser(src);
		AST tree = eqtutor.getTree(parser);
		eqtutor.printTreeToConsole(tree);
		System.out.println();
		String src2 = "a -> !b";
		System.out.println("Formula: " + src2);
		System.out.println();
		LogicParser parser2 = eqtutor.getParser(src2);
		AST tree2 = eqtutor.getTree(parser2);
		eqtutor.printTreeToConsole(tree2);
		NodeEquivalence test = new NodeEquivalence(tree2.getRoot(), tree.getRoot());
		System.out.println();
		System.out.println("Equal: " + test.isEquivalent());
		
	}
	
	private String getFormula() {
		PropositionalExpressionGenerator formula = new PropositionalExpressionGenerator(4, 0);
		return formula.generate();
	}
	
	private LogicParser getParser(String src) {
		CharStream stream = new ANTLRStringStream(src);
		LogicLexer lexer = new LogicLexer(stream);
		TokenStream tokens = new CommonTokenStream(lexer);
		LogicParser parser = new LogicParser(tokens);
		return parser;
	}
	
	private AST getTree(LogicParser parser) {
		AST tree = null;
		try {
			tree = parser.program();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		return tree;
	}

	private void printTreeToConsole(AST tree) {
		PrintStream p = System.out;
		ASTPrintVisitor printVisitor = new ASTPrintVisitor(p);
		tree.visit(printVisitor);
	}

}
