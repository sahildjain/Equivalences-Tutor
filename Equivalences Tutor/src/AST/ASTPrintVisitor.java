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
		stream.println(padding + "And Key: " + node.getKey());
		padding = padding + indent;
		node.getLeft().visit(this);
		node.getRight().visit(this);
		padding = oldPadding;
	}
	
	public void visitOrNode(ASTOrNode node) {
		String oldPadding = padding;
		stream.println(padding + "Or Key: " + node.getKey());
		padding = padding + indent;
		node.getLeft().visit(this);
		node.getRight().visit(this);
		padding = oldPadding;
	}
	
	public void visitNotNode(ASTNotNode node) {
		String oldPadding = padding;
		stream.println(padding + "Not Key: " + node.getKey());
		padding = padding + indent;
		node.getLeaf().visit(this);
		padding = oldPadding;
	}

	public void visitIdentifierNode(ASTIdentifierNode node) {
		stream.println(padding + "Identifier " + node.getLeaf() + " Key: " + node.getKey());
	}

	public void visitIfThenNode(ASTIfThenNode node) {
		String oldPadding = padding;
		stream.println(padding + "If Key: " + node.getKey());
		padding = padding + indent;
		node.getLeft().visit(this);
		padding = oldPadding;
		stream.println(padding + "Then Key: " + node.getKey());
		padding = padding + indent;
		node.getRight().visit(this);
		padding = oldPadding;
	}

	public void visitIffNode(ASTIffNode node) {
		String oldPadding = padding;
		stream.println(padding + "If Key: " + node.getKey());
		padding = padding + indent;
		node.getLeft().visit(this);
		padding = oldPadding;
		stream.println(padding + "Only If Key: " + node.getKey());
		padding = padding + indent;
		node.getRight().visit(this);
		padding = oldPadding;
	}

	public void visitProgramNode(ASTProgramNode node) {
		String oldPadding = padding;
		stream.println(padding + "Expression Key: " + node.getKey());
		padding = padding + indent;
		node.getLeaf().visit(this);
		padding = oldPadding;
	}

}
