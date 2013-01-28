parser grammar LogicParser;

options {
  tokenVocab = LogicLexer;
  output = AST;
}

@header {
  package eqtutor;
}

expr
  : iffexpr
  ;

iffexpr returns [ASTDoubleConditionalNode node]
  : ifexpr IFF iffexpr = iffexpr {$node = new ASTIffNode($ifexpr.node, $iffexpr.node);}
  | ifexpr ($node = $ifexpr.node;)
  ;

ifexpr returns [ASTConditionalNode node]
  : orexpr IFTHEN ifexpr = ifexpr {$node = new ASTIfThenNode($orexpr.node, $ifexpr.node);}
  | orexpr {$node = $orexpr.node;}
  ;

orexpr returns [ASTDisjunctionNode node]
  : andexpr OR orexpr = orexpr {$node = new ASTOrNode($andexpr.node, $orexpr.node);}
  | andexpr {$node = $andexpr.node;}
  ;

andexpr returns [ASTConjunctionNode node]
  : notexpr AND andexpr = andexpr {$node = new ASTAndNode($notexpr.node, $andexpr.node);}
  | notexpr {$node = $notexpr.node;}
  ;

notexpr returns [ASTUnaryNode node]
  : NOT notexpr = notexpr {$node = new ASTNotNode($notexpr.node);}
  | identifier {$node = $identifier.node;}
  ;

identifier returns [ASTLiteralNode node]
  : ID {$node = new ASTIdentifierNode($ID.text);}
  | LPAREN! expr RPAREN!
  ;
