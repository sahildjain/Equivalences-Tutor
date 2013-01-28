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

iffexpr
  : ifexpr IFF iffexpr = iffexpr {$node = new ASTIffNode($ifexpr.node, $iffexpr.node);}
  | ifexpr ($node = $ifexpr.node;)
  ;

ifexpr
  : orexpr IFTHEN ifexpr = ifexpr {$node = new ASTIfThenNode($orexpr.node, $ifexpr.node);}
  | orexpr {$node = $orexpr.node;}
  ;

orexpr
  : andexpr OR orexpr = orexpr {$node = new ASTOrNode($andexpr.node, $orexpr.node);}
  | andexpr {$node = $andexpr.node;}
  ;

andexpr
  : notexpr AND andexpr = andexpr {$node = new ASTAndNode($notexpr.node, $andexpr.node);}
  | notexpr {$node = $notexpr.node;}
  ;

notexpr
  : NOT notexpr = notexpr {$node = new ASTNotNode($notexpr.node);}
  | identifier {$node = $identifier.node;}
  ;

identifier returns [ASTLiteralNode node]
  : ID {$node = new ASTIdentifierNode($ID.text);}
  | LPAREN! expr RPAREN!
  ;
