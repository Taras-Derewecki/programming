/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2000 Gerwin Klein <lsf@jflex.de>                          *
 * All rights reserved.                                                    *
 *                                                                         *
 * Thanks to Larry Bell and Bob Jamison for suggestions and comments.      *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

%%

%class Lexer
%byaccj
%int

%{

  public Parser   yyparser;

  public Lexer(java.io.Reader r, Parser yyparser) {
    this(r);
    this.yyparser = yyparser;
  }
%}

digit      = [0-9]
number     = {digit}+
real       = {number}("."{number})?(E[+-]?{number})?
identifier = [A-Za-z_][A-Za-z0-9_]*
newline    = \n
whitespace = [ \t\r]+
comment    = "//".*

%%

"main"          {   return Parser.MAIN    ; }
"print"         {   return Parser.PRINT   ; }
"{"             {   return Parser.BEGIN   ; }
"}"             {   return Parser.END     ; }
"("             {   return Parser.LPAREN  ; }
")"             {   return Parser.RPAREN  ; }
"="             {   return Parser.ASSIGN  ; }
";"             {   return Parser.SEMI    ; }
"$"             {   return Parser.ENDMARKER;}
"\""            {   return Parser.QUOTE    ; }
"int"           {   return Parser.INTEGERTYPE; }
"float"         {   return Parser.FLOATTYPE; }
"while"         {   return Parser.WHILELOOP; }
"if"            {   return Parser.IFSTATEMENT; }
"return"        {   return Parser.RETURNSTATEMENT; }
"else"          {   return Parser.ELSESTATEMENT; }
"+"             {   return Parser.ADDITION; }
"-"             {   return Parser.SUBTRACTION; }
"*"             {   return Parser.MULTIPLICATION; }
"/"             {   return Parser.DIVISION; }
"%"             {   return Parser.MODULUS; }
"true"          {   return Parser.TRUEBOOL; }
"false"         {   return Parser.FALSEBOOL; }
"=="            {   return Parser.EE; }
"!="            {   return Parser.NE; }
"<"             {   return Parser.L; }
">"             {   return Parser.G; }
"<="            {   return Parser.LE; }
">="            {   return Parser.GE; }




{number}        {
                    int val = Integer.parseInt(yytext());
                    yyparser.yylval = new ParserVal(val);
                    return Parser.NUM;
                }

{real}          {
                    double val = Double.parseDouble(yytext());
                    yyparser.yylval = new ParserVal(val);
                    return Parser.REAL;
                }
                

{identifier}    {
                    yyparser.yylval = new ParserVal(yytext());
                    return Parser.ID;
                }
                
{comment}       {   /* skip */}
{newline}       {   /* skip */}
{whitespace}    {   /* skip */}

\b     { System.err.println("Sorry, backspace doesn't work"); }

/* error fallback */
[^]    { System.err.println("Error: unexpected character '"+yytext()+"'"); return -1; }
