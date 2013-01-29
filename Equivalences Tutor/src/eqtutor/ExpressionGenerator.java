package eqtutor;

import java.util.Random;

public abstract class ExpressionGenerator {
	
	public abstract String generate();
	
	public Operator getRandomOperator() {
		Random rand = new Random();
		int i = rand.nextInt(1000);
		i = i % 4;
		return Operator.values()[i];
	}
	
	public String getOperatorSymbol(Operator operator) {
		if(operator.equals(Operator.AND)) {
			return " & ";
		}
		if(operator.equals(Operator.OR)) {
			return " | ";
		}
		if(operator.equals(Operator.IFF)) {
			return " <> "; 
		}
		if(operator.equals(Operator.IFTHEN)) {
			return " -> ";
		}
		return null;
	}
}
