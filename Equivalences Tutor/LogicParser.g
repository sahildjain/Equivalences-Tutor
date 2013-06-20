parser grammar LogicParser;

options {
  tokenVocab = LogicLexer;
}

@header {
  package eqtutor;
  
  import java.util.LinkedList;
  import java.util.List;
  import AST.*;
}

@members {
  private boolean hasFoundError = false;
  
  private int counter = 0;
  
  public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
    hasFoundError = true;
  }
  
  public boolean hasFoundError() {
    return this.hasFoundError;
  }
}

program returns [AST tree]
  : e = iffexpr {$tree = new AST(++counter, new ASTProgramNode($e.node));} EOF
  ;

iffexpr returns [ASTNode node]
  : ifthen = ifexpr {$node = $ifthen.node;} (IFF iff = iffexpr {$node = new ASTIffNode(++counter, $ifthen.node, $iff.node);})*
  ;
  	
ifexpr returns [ASTNode node]
  : or = orexpr {$node = $or.node;} (IFTHEN ifthen = ifexpr {$node = new ASTIfThenNode(++counter, $or.node, $ifthen.node);})*
  ;

orexpr returns [ASTNode node]
  : and = andexpr {$node = $and.node;} (OR or = orexpr {$node = new ASTOrNode(++counter, $and.node, $or.node);})*
  ;

andexpr returns [ASTNode node]
  : not = notexpr {$node = $not.node;} (AND and = andexpr {$node = new ASTAndNode(++counter, $not.node, $and.node);})*
  ;
  
notexpr returns [ASTNode node]
  : NOT not = notexpr {$node = new ASTNotNode(++counter, $not.node);}
  | id = identifier {$node = $id.node;}
  ;
  
  
forallexpr returns [ASTNode node]
  : FORALL LPAREN ID RPAREN LPAREN iffexpr RPAREN = forallexpr {$node = new ASTForAllNode}

identifier returns [ASTNode node]
  : ID {$node = new ASTIdentifierNode(++counter, $ID.text);}
  | LPAREN iffexpr RPAREN {$node = $iffexpr.node;}
  ;