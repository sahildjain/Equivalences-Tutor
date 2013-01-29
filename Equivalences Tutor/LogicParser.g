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
    return this.hasFoundError;
  }
}

program returns [AST tree]
  : e = iffexpr {$tree = new AST(new ASTProgramNode($e.node));} EOF
  ;

iffexpr returns [ASTDoubleConditionalNode node]
  : ifexpr IFF iff = iffexpr {$node = new ASTIffNode($ifexpr.node, $iff.node);}
  | ifexpr {$node = $ifexpr.node}
  ;
  	
ifexpr returns [ASTConditionalNode node]
  : orexpr IFTHEN ifthen = ifexpr {$node = new ASTIfThenNode($orexpr.node, $ifthen.node);}
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
