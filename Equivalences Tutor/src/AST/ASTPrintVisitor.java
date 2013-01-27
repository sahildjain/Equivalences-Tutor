package AST;

import java.io.PrintStream;

public class ASTPrintVisitor implements ASTVisitor {
	
	PrintStream stream;
	String padding = "";
	String indent = "  ";
	
	public ASTPrintVisitor(PrintStream stream) {
		this.stream = stream;
	}

	public void visitAndNode(ASTAndNode node) {
		String oldPadding = padding;
		stream.println(padding + "And");
		padding = padding + "  ";
		node.getExpression1().visit(this);
		node.getExpression2().visit(this);
		padding = oldPadding;
	}
	
	public void visitOrNode(ASTOrNode node) {
		String oldPadding = padding;
		stream.println(padding + "Or");
		padding = padding + "  ";
		node.getExpression1().visit(this);
		node.getExpression2().visit(this);
		padding = oldPadding;
	}
	
	public void visitNotNode(ASTNotNode node) {
		String oldPadding = padding;
		stream.println(padding + "Not");
		padding = padding + "  ";
		node.getUnary().visit(this);
		padding = oldPadding;
	}

	public void visitIdentifierNode(ASTIdentifierNode node) {
		stream.println(padding + "Identifier");
		stream.println(padding + node.getId());
	}

}
