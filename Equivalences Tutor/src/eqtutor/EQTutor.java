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
		String src = "a <> b -> c & d | e <> f";
		System.out.println("Formula: " + src);
		CharStream stream = new ANTLRStringStream(src);
		LogicLexer lexer = new LogicLexer(stream);
		TokenStream tokens = new CommonTokenStream(lexer);
		LogicParser parser = new LogicParser(tokens);
		AST tree = null;
		try {
			tree = parser.program();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		PrintStream p = System.out;
		ASTPrintVisitor printVisitor = new ASTPrintVisitor(p);
		tree.visit(printVisitor);
	}

}
