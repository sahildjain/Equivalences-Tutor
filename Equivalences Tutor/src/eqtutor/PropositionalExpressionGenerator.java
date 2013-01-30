package eqtutor;

public class PropositionalExpressionGenerator extends ExpressionGenerator {

	private int atoms;
	private int nestings;
	
	public PropositionalExpressionGenerator(int atoms, int nestings) {
		this.atoms = atoms;
		this.nestings = nestings;
	}
	
	public String generate() {
		StringBuilder stringBuilder = new StringBuilder();
		BinaryOperator operator;
		int nestings = getNestings();
		int atoms = getAtoms();
		for(int i = 0; i < atoms; i++) {
			int ascii = 97 + i;
			stringBuilder.append(Character.toString((char) ascii));
			operator = getRandomOperator();
			if(i != atoms - 1) {
				stringBuilder.append(getOperatorSymbol(operator));
			}
		}
		return stringBuilder.toString();
	}

	public int getAtoms() {
		return atoms;
	}

	public void setAtoms(int atoms) {
		this.atoms = atoms;
	}

	public int getNestings() {
		return nestings;
	}

	public void setNestings(int nestings) {
		this.nestings = nestings;
	}
	
}
