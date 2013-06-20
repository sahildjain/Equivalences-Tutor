lexer grammar LogicLexer;

options {
  language = Java;
}

@header {
  package eqtutor;
}

WHITESPACE:     ( '\t' | ' ' | '\r' | '\n' | '\u000C' )+ { $channel = HIDDEN; };

AND	:	'&';
OR	:	'|';
IFTHEN	:	'->';
IFF 	:	'<>';

NOT 	:	'!';

LPAREN  :	'(';
RPAREN  :	')';

ID	:	('A'..'Z'|'a'..'z') ('A'..'Z'|'a'..'z'|'_')*;

FORALL	: '(A)';
EXISTS	: '(E)';