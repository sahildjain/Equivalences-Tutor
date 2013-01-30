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
		padding = padding + indent;
		node.getUnary().visit(this);
		node.getPropositional().visit(this);
		padding = oldPadding;
	}
	
	public void visitOrNode(ASTOrNode node) {
		String oldPadding = padding;
		stream.println(padding + "Or");
		padding = padding + indent;
		node.getConjunction().visit(this);
		node.getDisjunction().visit(this);
		padding = oldPadding;
	}
	
	public void visitNotNode(ASTNotNode node) {
		String oldPadding = padding;
		stream.println(padding + "Not");
		padding = padding + indent;
		node.getUnary().visit(this);
		padding = oldPadding;
	}

	public void visitIdentifierNode(ASTIdentifierNode node) {
		stream.println(padding + "Identifier");
		stream.println(padding + indent + node.getId());
	}

	public void visitIfThenNode(ASTIfThenNode node) {
		String oldPadding = padding;
		stream.println(padding + "If");
		padding = padding + indent;
		node.getDisjunction().visit(this);
		padding = oldPadding;
		stream.println(padding + "Then");
		padding = padding + indent;
		node.getConditional().visit(this);
		padding = oldPadding;
	}

	public void visitIffNode(ASTIffNode node) {
		String oldPadding = padding;
		stream.println(padding + "If");
		padding = padding + indent;
		node.getConditional().visit(this);
		padding = oldPadding;
		stream.println(padding + "Only If");
		padding = padding + indent;
		node.getDoubleConditional().visit(this);
		padding = oldPadding;
	}

	public void visitProgramNode(ASTProgramNode node) {
		String oldPadding = padding;
		stream.println(padding + "Expression");
		padding = padding + indent;
		node.getDoubleConditional().visit(this);
		padding = oldPadding;
		/*String oldPadding = padding;
		stream.println(padding + "Expression");
		padding = padding + indent;
		List<ASTExpressionNode> expressions = node.getExpressions();
		Iterator<ASTExpressionNode> it = expressions.iterator();
		while(it.hasNext()) {
			ASTExpressionNode expression = it.next();
			expression.visit(this);
		}
		padding = oldPadding;*/
	}

}
