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
  public int      linenum = 1;

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


"main"          {   yyparser.linenum = linenum;     return Parser.MAIN    ; }
"print"         {   yyparser.linenum = linenum;     return Parser.PRINT   ; }
"{"             {   yyparser.linenum = linenum;     return Parser.BEGIN   ; }
"}"             {   yyparser.linenum = linenum;     return Parser.END     ; }
"("             {   yyparser.linenum = linenum;     return Parser.LPAREN  ; }
")"             {   yyparser.linenum = linenum;     return Parser.RPAREN  ; }
"="             {   yyparser.linenum = linenum;     return Parser.ASSIGN  ; }
";"             {   yyparser.linenum = linenum;     return Parser.SEMI    ; }
"int"           {   yyparser.linenum = linenum;     return Parser.INT; }
"float"         {   yyparser.linenum = linenum;     return Parser.FLOAT; }
"bool"		    {   yyparser.linenum = linenum;     return Parser.BOOL; }
"while"         {   yyparser.linenum = linenum;     return Parser.WHILE; }
"if"            {   yyparser.linenum = linenum;     return Parser.IF; }
"return"        {   yyparser.linenum = linenum;     return Parser.RETURN; }
"else"          {   yyparser.linenum = linenum;     return Parser.ELSE; }
"+"             {   yyparser.linenum = linenum;     return Parser.PLUS; }
"-"             {   yyparser.linenum = linenum;     return Parser.SUB; }
"*"             {   yyparser.linenum = linenum;     return Parser.MUL; }
"/"             {   yyparser.linenum = linenum;     return Parser.DIV; }
"%"             {   yyparser.linenum = linenum;     return Parser.MOD; }
"true"          {   yyparser.linenum = linenum;     return Parser.TRUE; }
"false"         {   yyparser.linenum = linenum;     return Parser.FALSE; }
"=="            {   yyparser.linenum = linenum;     return Parser.EQ; }
"!="            {   yyparser.linenum = linenum;     return Parser.NE; }
"<"             {   yyparser.linenum = linenum;     return Parser.LT; }
">"             {   yyparser.linenum = linenum;     return Parser.GT; }
"<="            {   yyparser.linenum = linenum;     return Parser.LE; }
">="            {   yyparser.linenum = linenum;     return Parser.GE; }

"or"            {   yyparser.linenum = linenum;     return Parser.OR; }
"and"           {   yyparser.linenum = linenum;     return Parser.AND; }
"not"           {   yyparser.linenum = linenum;     return Parser.NOT; }
","			    {   yyparser.linenum = linenum;     return Parser.COMMA; }


{number}      { yyparser.linenum = linenum; yyparser.yylval = new ParserVal(yytext()); return Parser.NUM   ; }
{real}        { yyparser.linenum = linenum; yyparser.yylval = new ParserVal(yytext()); return Parser.REAL  ; }
{identifier}  { yyparser.linenum = linenum; yyparser.yylval = new ParserVal(yytext()); return Parser.ID    ; }
{comment}     {            /* skip */ }
{newl;e}     { linenum++; /* skip */ }
{whitespace}  {            /* skip */ }

\b     { System.err.println("Sorry, backspace doesn't work"); }

/* error fallback */
[^]    {} /*{ System.err.println("Error: unexpected character '"+yytext()+"'"); return -1; }*/
