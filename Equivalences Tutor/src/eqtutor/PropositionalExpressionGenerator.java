package eqtutor;

import java.util.Random;

public class PropositionalExpressionGenerator extends ExpressionGenerator {

	private int atoms;
	private int nestings;
	
	public PropositionalExpressionGenerator(int atoms, int nestings) {
		this.atoms = atoms;
		this.nestings = nestings;
	}
	
	public String generate() {
		StringBuilder stringBuilder = new StringBuilder();
		/*int nestings = getNestings();*/
		int atoms = getAtoms();
		Random randomAtoms = new Random();
		int randAtoms;
		for(int i = 0; i < atoms; i += randAtoms) {
			randAtoms = randomAtoms.nextInt(atoms - i);
			/*Random randomNestings = new Random();
			int randNestings = randomNestings.nextInt(nestings);
			if(randNestings > randAtoms) {
				randNestings = randAtoms - 1;
			}
			nestings -= randNestings;*/
			//boolean end = false;
			//if(randAtoms == atoms) {
			//	end = true;
			//}
			PropositionalExpressionGenerator gen = new PropositionalExpressionGenerator(randAtoms, 0);
			stringBuilder.append(gen.generateExpression(i));
		}
		return stringBuilder.toString();
	}
	
	private String generateString(int offset) {
		int nestings = getNestings();
		int atoms = getAtoms();
		if(atoms == 1) {
			return getAtom(offset);
		}
		StringBuilder stringBuilder = new StringBuilder();
		int i;
		for(i = 0; i < atoms; i++) {
			BinaryOperator operator = getRandomOperator();
			stringBuilder.append(getAtom(offset + i) + getOperatorSymbol(operator));
		}
		return stringBuilder.toString();
	}
	
	private String generateExpression(int offset) {
		StringBuilder stringBuilder = new StringBuilder();
		int atoms = getAtoms();
		int nestings = getNestings();
		if(nestings > 0) {
			stringBuilder.append("(");
		}
		for(int i = 0; i < atoms; i ++) {
			stringBuilder.append(getAtom(offset + i));
			BinaryOperator operator = getRandomOperator();
			if(i != atoms - 1) {
				stringBuilder.append(getOperatorSymbol(operator));
			}
		}
		if(nestings > 0) {
			stringBuilder.append(")");
			nestings--;
		}
		return stringBuilder.toString();
	}

	private String getAtom(int offset) {
		int ascii = 97 + offset;
		Random random = new Random();
		int rand = random.nextInt(10);
		if(rand >= 7) {
			return "!" + Character.toString((char) ascii);
		}
		return Character.toString((char) ascii);
	}

	public int getAtoms() {
		return atoms;
	}

	public int getNestings() {
		return nestings;
	}
	
}
