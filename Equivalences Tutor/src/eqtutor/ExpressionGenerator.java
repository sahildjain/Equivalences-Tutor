package eqtutor;

import java.util.Random;

public abstract class ExpressionGenerator {
	
	public abstract void generate();
	
	public BinaryOperator getRandomOperator() {
		Random rand = new Random();
		int i = rand.nextInt(4);
		return BinaryOperator.values()[i];
	}
	
	public String getOperatorSymbol(BinaryOperator operator) {
		if(operator.equals(BinaryOperator.AND)) {
			return " & ";
		}
		if(operator.equals(BinaryOperator.OR)) {
			return " | ";
		}
		if(operator.equals(BinaryOperator.IFF)) {
			return " <> "; 
		}
		if(operator.equals(BinaryOperator.IFTHEN)) {
			return " -> ";
		}
		return null;
	}
}
