package eqtutor;

public class PropositionalExpressionGenerator extends ExpressionGenerator {

	private int difficulty;
	
	public PropositionalExpressionGenerator(int difficulty) {
		this.setDifficulty(difficulty);
	}
	
	public String generate() {
		String formula = null;
		switch(getDifficulty()) {
			case 1: formula = generateEasyFormula();
		}
		return formula;
	}

	private String generateEasyFormula() {
		StringBuilder stringBuilder = new StringBuilder();
		Operator operator;
		int limit = 4;
		for(int i = 0; i < limit; i++) {
			int ascii = 97 + i;
			stringBuilder.append(Character.toString((char) ascii));
			operator = getRandomOperator();
			if(i != limit - 1) {
				stringBuilder.append(getOperatorSymbol(operator));
			}
		}
		return stringBuilder.toString();
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
}
