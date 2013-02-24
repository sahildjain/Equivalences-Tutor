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

iffexpr returns [ASTPropositionalNode node]
  : ifthen = ifexpr {$node = $ifthen.node;} (IFF iff = iffexpr {$node = new ASTIffNode(++counter, $ifthen.node, $iff.node);})*
  ;
  	
ifexpr returns [ASTPropositionalNode node]
  : or = orexpr {$node = $or.node;} (IFTHEN ifthen = ifexpr {$node = new ASTIfThenNode(++counter, $or.node, $ifthen.node);})*
  ;

orexpr returns [ASTPropositionalNode node]
  : and = andexpr {$node = $and.node;} (OR or = orexpr {$node = new ASTOrNode(++counter, $and.node, $or.node);})*
  ;

andexpr returns [ASTPropositionalNode node]
  : not = notexpr {$node = $not.node;} (AND and = andexpr {$node = new ASTAndNode(++counter, $not.node, $and.node);})*
  ;
  
notexpr returns [ASTPropositionalNode node]
  : NOT not = notexpr {$node = new ASTNotNode(++counter, $not.node);}
  | id = identifier {$node = $id.node;}
  ;

identifier returns [ASTPropositionalNode node]
  : ID {$node = new ASTIdentifierNode(++counter, $ID.text);}
  | LPAREN iffexpr RPAREN {$node = $iffexpr.node;}
  ;