package eqtutor;

import equivalence.*;
import AST.*;


public class PropositionalExpressionGenerator extends ExpressionGenerator {
	
	private AST startState;
	private AST endState;
	
	public void generate() {
		int n = (int)(Math.random() * 10);
		if(n < 5) {
			generateCNF();
		}
		else {
			generateDNF();
		}
		generateEndState();
		System.out.println(getStartState().toString());
		System.out.println(getEndState().toString());
	}
	
	private void generateCNF() {
		int atoms = 3 + (int)(Math.random() * ((6 - 3) + 1));
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(Character.toString((char) 97));
		for(int i = 1; i < atoms; i++) {
			stringBuilder.append(" & ");
			stringBuilder.append(Character.toString((char) (97 + i)));
		}
		EQTutor eqtutor = new EQTutor(); 
		LogicParser parser = eqtutor.getParser(stringBuilder.toString());
		AST tree = eqtutor.getTree(parser);
		setStartState(tree);
	}
	
	private void generateDNF() {
		int atoms = 3 + (int)(Math.random() * ((6 - 3) + 1));
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(Character.toString((char) 97));
		for(int i = 1; i < atoms; i++) {
			stringBuilder.append(" | ");
			stringBuilder.append(Character.toString((char) (97 + i)));
		}
		EQTutor eqtutor = new EQTutor(); 
		LogicParser parser = eqtutor.getParser(stringBuilder.toString());
		AST tree = eqtutor.getTree(parser);
		setStartState(tree);
	}
	
	private void generateEndState() {
		AST endState = getStartState().copy();
		int random = (int)(Math.random() * 10);
		int k = startState.getKey() - 1;
		//System.out.println("random: " + random);
		//System.out.println("k: " + k);
		for(int i = 0 ; i < random; i++) {
			int randKey = 1 + (int)(Math.random() * ((k - 1) + 1));
			ASTNode node = Equivalence.find(startState.getRoot(), randKey);
			//System.out.println(node.toString());
			AST temp = null;
			if(node instanceof ASTAndNode) {
				temp = andInstance(endState, randKey);
			}
			else if(node instanceof ASTOrNode) {
				temp = orInstance(endState, randKey);
			}
			else if(node instanceof ASTNotNode) {
				temp = notInstance(endState, randKey);
			}
			else if(node instanceof ASTIfThenNode) {
				temp = ifThenInstance(endState, randKey);
			}
			else if(node instanceof ASTIffNode) {
				temp = iffInstance(endState, randKey);
			}
			else if(node instanceof ASTIdentifierNode) {
				temp = identifierInstance(endState, randKey);
			}
			if(temp != null) {
				endState = temp;
			}
		}
		setEndState(endState);
		NodeEquivalence n = new NodeEquivalence(getEndState().getRoot().getLeaf(), getStartState().getRoot().getLeaf());
		if(n.isEquivalent()) {
			generateEndState();
		}
	}
	
	private AST andInstance(AST endState, int randKey) {
		AST temp = null;
		AndEquivalence eq = new AndEquivalence(endState, randKey);
		int r = 1 + (int)(Math.random() * ((8 - 1) + 1));
		switch(r) {
			case 1:	temp = eq.associativityLeft(); break;
			case 2:	temp = eq.associativityRight(); break;
			case 3:	temp = eq.commutativity(); break;
			case 4:	temp = eq.deMorgan(); break;
			case 5:	temp = eq.distback(); break;
			case 6:	temp = eq.distdiff(); break;
			case 7:	temp = eq.idempotence(); break;
			case 8:	temp = eq.iff(); break;
			default:
		}
		return temp;
	}
	
	private AST orInstance(AST endState, int randKey) {
		AST temp = null;
		OrEquivalence eq = new OrEquivalence(endState, randKey);
		int r = 1 + (int)(Math.random() * ((8 - 1) + 1));
		switch(r) {
			case 1:	temp = eq.associativityLeft(); break;
			case 2:	temp = eq.associativityRight(); break;
			case 3:	temp = eq.commutativity(); break;
			case 4:	temp = eq.dist(); break;
			case 5:	temp = eq.distdiff(); break;
			case 7:	temp = eq.idempotence(); break;
			case 8:	temp = eq.distsame(); break;
			default:
		}
		return temp;
	}
	
	private AST notInstance(AST endState, int randKey) {
		AST temp = null;
		NotEquivalence eq = new NotEquivalence(endState, randKey);
		int r = 1 + (int)(Math.random() * ((3 - 1) + 1));
		switch(r) {
			case 1:	temp = eq.deMorganAnd(); break;
			case 2:	temp = eq.deMorganOr(); break;
			case 3:	temp = eq.doubleNegation(); break;
			default:
		}
		return temp;
	}
	
	private AST ifThenInstance(AST endState, int randKey) {
		AST temp = null;
		IfEquivalence eq = new IfEquivalence(endState, randKey);
		int r = 1 + (int)(Math.random() * ((2 - 1) + 1));
		switch(r) {
			case 1:	temp = eq.ifToAndEquivalence(); break;
			case 2:	temp = eq.ifToOrEquivalence(); break;
			default:
		}
		return temp;
	}
	
	private AST iffInstance(AST endState, int randKey) {
		AST temp = null;
		IffEquivalence eq = new IffEquivalence(endState, randKey);
		int r = 1 + (int)(Math.random() * ((5 - 1) + 1));
		switch(r) {
			case 1:	temp = eq.iffNot1(); break;
			case 2:	temp = eq.iffNot2(); break;
			case 3:	temp = eq.iffToAndEquivalence(); break;
			case 4:	temp = eq.iffToOrEquivalence(); break;
			case 5:	temp = eq.negate(); break;
			default:
		}
		return temp;
	}
	
	private AST identifierInstance(AST endState, int randKey) {
		AST temp = null;
		IdentifierEquivalence eq = new IdentifierEquivalence(endState, randKey);
		int r = 1 + (int)(Math.random() * ((3 - 1) + 1));
		switch(r) {
			case 1:	temp = eq.andIdempotence(); break;
			case 2:	temp = eq.doubleNegation(); break;
			case 3:	temp = eq.orIdempotence(); break;
			default:
		}
		return temp;
	}
	
	public AST getStartState() {
		return startState;
	}

	public void setStartState(AST startState) {
		this.startState = startState;
	}

	public AST getEndState() {
		return endState;
	}

	public void setEndState(AST endState) {
		this.endState = endState;
	}

	
	/*
	private int atoms;
	private int nestings;
	
	public PropositionalExpressionGenerator(int atoms, int nestings) {
		this.atoms = atoms;
		this.nestings = nestings;
	}
	
	public String generate() {
		StringBuilder stringBuilder = new StringBuilder();
		int nestings = getNestings();
		int atoms = getAtoms();
		Random randomAtoms = new Random();
		int randAtoms;
		for(int i = 1; i < atoms; i += randAtoms) {
			randAtoms = randomAtoms.nextInt(atoms);
			PropositionalExpressionGenerator gen = new PropositionalExpressionGenerator(randAtoms, nestings);
			stringBuilder.append(gen.generateExpression(i) + getOperatorSymbol(BinaryOperator.AND));
		}
		return stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()).toString();
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
		int ascii = 96 + offset;
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
	*/
}
