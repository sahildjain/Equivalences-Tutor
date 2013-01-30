package eqtutor;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import AST.*;

public class EQTutor {
	
	public static void main(String[] args) throws FileNotFoundException {
		String src = getFormula();
		//String src = "a & b -> c";
		System.out.println("Formula: " + src);
		LogicParser parser = getParser(src);
		AST tree = getTree(parser);
		printTreeToConsole(tree);
	}
	
	private static String getFormula() {
		PropositionalExpressionGenerator formula = new PropositionalExpressionGenerator(10, 0);
		return formula.generate();
	}
	
	private static LogicParser getParser(String src) {
		CharStream stream = new ANTLRStringStream(src);
		LogicLexer lexer = new LogicLexer(stream);
		TokenStream tokens = new CommonTokenStream(lexer);
		LogicParser parser = new LogicParser(tokens);
		return parser;
	}
	
	private static AST getTree(LogicParser parser) {
		AST tree = null;
		try {
			tree = parser.program();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		return tree;
	}

	private static void printTreeToConsole(AST tree) {
		PrintStream p = System.out;
		ASTPrintVisitor printVisitor = new ASTPrintVisitor(p);
		tree.visit(printVisitor);
	}

}
