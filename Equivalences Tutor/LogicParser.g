parser grammar LogicParser;

options {
  tokenVocab = LogicLexer;
  backtrack = true;
}

@header {
  package eqtutor;
  
  import java.util.LinkedList;
  import java.util.List;
  import AST.*;
}

@members {
  private boolean hasFoundError = false;
  
  public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
    hasFoundError = true;
  }
  
  public boolean hasFoundError() {
    retutn this.hasFoundError;
  }
}

program returns [AST tree]
	@init {List<ASTExpressionNode> expressions = new LinkedList<ASTExpressionNode>();}
  : (expr {expressions.add($expr.node);})* EOF
    {$tree = new AST(new ASTProgramNode(expressions));}
  ;

expr returns [ASTExpressionNode node]
  : iffexpr ($node = $iffexpr.node;)
  ;

iffexpr returns [ASTDoubleConditionalNode node]
  : ifexpr IFF iff = expr {$node = new ASTIffNode($ifexpr.node, $iff.node);}
  | ifexpr ($node = $ifexpr.node;)
  ;
  	
ifexpr returns [ASTConditionalNode node]
  : orexpr IFTHEN if = ifexpr {$node = new ASTIfThenNode($orexpr.node, $if.node);}
  | orexpr {$node = $orexpr.node;}
  ;

orexpr returns [ASTDisjunctionNode node]
  : andexpr OR or = orexpr {$node = new ASTOrNode($andexpr.node, $or.node);}
  | andexpr {$node = $andexpr.node;}
  ;

andexpr returns [ASTConjunctionNode node]
  : notexpr AND and = andexpr {$node = new ASTAndNode($notexpr.node, $and.node);}
  | notexpr {$node = $notexpr.node;}
  ;
notexpr returns [ASTUnaryNode node]
  : NOT not = notexpr {$node = new ASTNotNode($not.node);}
  | identifier {$node = $identifier.node;}
  ;

identifier returns [ASTLiteralNode node]
  : ID {$node = new ASTIdentifierNode($ID.text);}
  //| LPAREN! expr RPAREN!
  ;
