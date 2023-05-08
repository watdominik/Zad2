grammar Calculator;
expression: multiplicativeExpr ((PLUS | MINUS) multiplicativeExpr)*;
multiplicativeExpr: exponentiationExpr ((MULT | DIV) exponentiationExpr)*;
exponentiationExpr: sqrtExpression (POW sqrtExpression)*;
sqrtExpression: primaryExpr | ROOT sqrtExpression;
primaryExpr: FLOAT | INT | LPAREN expression RPAREN;

FLOAT: [0-9]+'.'[0-9]+ ;
INT: [0-9];
PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
POW: '^';
ROOT: 'sqrt';
LPAREN: '(';
RPAREN: ')';

WS: [ \t\r\n]+ -> skip;
