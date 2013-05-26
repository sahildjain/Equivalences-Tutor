package AST;

import java.awt.BorderLayout;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class ASTOrNode extends ASTPropositionalBinaryNode {
	
	private ASTPropositionalNode conjunction;
	private ASTPropositionalNode disjunction;
	private int key;

	public ASTOrNode(int key, ASTPropositionalNode conjunction, ASTPropositionalNode disjunction) {
		this.conjunction = conjunction;
		this.disjunction = disjunction;
		this.setKey(key);
	}
	
	public ASTPropositionalNode getLeft() {
		return this.conjunction;
	}
	
	public ASTPropositionalNode getRight() {
		return this.disjunction;
	}

	public void visit(ASTVisitor visitor) {
		visitor.visitOrNode(this);
	}

	public void setLeft(ASTPropositionalNode left) {
		this.conjunction = left;
	}

	public void setRight(ASTPropositionalNode right) {
		this.disjunction = right;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	public boolean equals(ASTPropositionalNode node) {
		if(!(node instanceof ASTOrNode)) {
			return false;
		}
		boolean left = getLeft().equals(((ASTOrNode) node).getLeft());
		boolean right = getRight().equals(((ASTOrNode) node).getRight());
		return left && right;
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("(");
		stringBuilder.append(getLeft().toString());
		stringBuilder.append(" \u2228 ");
		stringBuilder.append(getRight().toString());
		stringBuilder.append(")");
		return stringBuilder.toString();
	}
	
	public TreeMap<String, Integer> numIdentifiers(TreeMap<String, Integer> identifiers) {
		identifiers = getLeft().numIdentifiers(identifiers);
		identifiers = getRight().numIdentifiers(identifiers);
		return identifiers;
	}

	public int value() {
		int left = getLeft().value();
		int right = getRight().value();
		if(left == 1 || right == 1) {
			return 1;
		}
		return 0;
	}

	public JPanel createJPanel() {
		JPanel panel = new JPanel(new MigLayout());
		JPanel left = getLeft().createJPanel();
		JPanel right = getRight().createJPanel();
		JButton button = new JButton("\u2228");
		panel.add(left, BorderLayout.WEST);
		panel.add(button, BorderLayout.CENTER);
		panel.add(right, BorderLayout.EAST);
		return panel;
	}

}
