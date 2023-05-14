/**
 * Write your info here
 *
 * @name Mahmoud Mohamed Aly Abdallah Jobeel
 * @id 46-18406
 * @labNumber 020
 */

grammar Task8;

fragment Digit: [0-9];
fragment Integer: Digit+;
fragment Decimal: Integer '.' Integer;
fragment E: [eE];
fragment Sign: [+-];
fragment Exponent: E Sign? Digit+;
fragment Letter: [a-zA-Z];
fragment Underscore: '_';

Space: [ \t\r\n]+ -> skip;
LP: '(';
RP: ')';
COMP: '<' | '>' | '<=' | '>=' | '==' | '!=';
LIT: '"' (~["\\] | '\\' ["\\])* '"';
NUM: Sign? (Decimal | Integer | Decimal Exponent | Integer Exponent);
ELSE : [eE] [lL] [sS] [eE];
IF : [iI] [fF];
ID: (Letter | Underscore) (Letter | Digit | Underscore)*;

start: (Space | IF | ELSE | ID | NUM | COMP | LIT | LP | RP)+;
