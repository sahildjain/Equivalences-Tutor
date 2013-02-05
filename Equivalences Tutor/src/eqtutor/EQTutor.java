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
		ASTNode node1 = new ASTAndNode(new ASTNotNode(new ASTIdentifierNode("Test")), new ASTIdentifierNode("Test"));
		ASTNode node2 = new ASTAndNode(new ASTNotNode(new ASTIdentifierNode("Test")), new ASTIdentifierNode("Test"));
		NodeEquivalence test = new NodeEquivalence(node1, node2);
		boolean ret = test.isEquivalent();
		System.out.println(ret);
		//String src = eqtutor.getFormula();
		String src = "!((a | b) & c) & d | !f";
		System.out.println("Formula: " + src);
		LogicParser parser = eqtutor.getParser(src);
		AST tree = eqtutor.getTree(parser);
		eqtutor.printTreeToConsole(tree);
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
