import static java.lang.Math.*;
import java.util.HashMap;
%%

%class Lexer
%byaccj
%int

%{
    HashMap <String, Integer> hmap = new HashMap<String, Integer>();
    Integer idNumber = 0;
    public Lexer(java.io.Reader r, HashMap <String, Integer> thmap) {
        this(r);
        this.hmap = thmap;
    }
    // "public Lexer(java.io.Reader in)" will be generated as default
%}

digit      = [0-9]
number     = {digit}+
real       = {number}(.{number})?(E[+-]?{number})?
letter     = [A-Za-z]
newline    = \n
id         = [_A-Za-z][_A-Za-z0-9]*
comment    = "//".*



%%
"main"          { 
		   String lexeme = yytext();
		   System.out.print("<main>");
		   return Main.MAIN;   
		}

"if"            { 
		   String lexeme = yytext();
		   System.out.print("<if>"); 
		   return Main.IF;   
		}

"else"          { 
		   String lexeme = yytext();
		   System.out.print("<else>");
		   return Main.ELSE;   
		}

"while"         { 
		   String lexeme = yytext();
		   System.out.print("<while>");
		   return Main.WHILE;   
		}

"bool"          { 
		   String lexeme = yytext();
		   System.out.print("<bool>");
		   return Main.BOOL;   
		}

"int"           { 
		   String lexeme = yytext();
		   System.out.print("<int>");
		   return Main.INT;   
		}

"float"         { 
		   String lexeme = yytext();
		   System.out.print("<float>");
		   return Main.FLOAT;   
		}

"print"         { 
		   String lexeme = yytext();
		   System.out.print("<print>");
		   return Main.PRINT;   
		}

"true"          { 
		   String lexeme = yytext();
		   System.out.print("<true>");
		   return Main.TRUE;   
		}

"false"         { 
		   String lexeme = yytext();
		   System.out.print("<false>");
		   return Main.FALSE;   
		}

{id}            {
		  String lexeme = yytext();
		  
		  if(!hmap.containsKey(lexeme))
		  {
		     System.out.print("<< add " + lexeme + " into symbol table at " + 				idNumber + " >>");
		     hmap.put(lexeme, idNumber++);
		  }; 
 
		  System.out.print("<id," + hmap.get(lexeme) + ">");
		  return Main.ID;
		}

{number}        { 
		  String lexeme = yytext();
                  System.out.print("<num,"  + yytext() + ">");
		  return Main.NUM;  
		}

{real}          { 
		  String lexeme = yytext();
		  System.out.print("<real, "  + yytext() + ">");
		  return Main.REAL; 
		}

{letter}+
                {
                    String lexeme = yytext();
		    System.out.print("<"+ lexeme + ">");
                    return Main.WORD;
                }

{newline}       {
                    String lexeme = yytext();
                    System.out.print("\n");
                    /* skip */
                }

[ \t\r]+        {
                    String lexeme = yytext();
                    System.out.print(lexeme);
                    /* skip */
                }

{comment}	{
		    String lexeme = yytext();
		    System.out.print(lexeme);
		    return Main.comment;
		}

"+"             { String lexeme = yytext(); System.out.print("<+>"); return Main.PLUS; }


"("             { 
		   String lexeme = yytext();
		   System.out.print("<(>");
		   return Main.leftParenthesis;   
		}

")"             { 
		   String lexeme = yytext();
		   System.out.print("<)>");
		   return Main.rightParenthesis;   
		}


"{"             { 
		   String lexeme = yytext();
		   System.out.print("<{>");
		   return Main.leftBracket;   
		}

"}"             { 
		   String lexeme = yytext();
		   System.out.print("<}>");
		   return Main.rightBracket;   
		}

"<"             { 
		   String lexeme = yytext();
		   System.out.print("<<>");
		   return Main.lt;   
		}

">"             { 
		   String lexeme = yytext();
		   System.out.print("<>>");
		   return Main.gt;   
		}
"<="             { 
		   String lexeme = yytext();
		   System.out.print("<<=>");
		   return Main.lteq;   
		}

">="             { 
		   String lexeme = yytext();
		   System.out.print("<>=>");
		   return Main.gteq;   
		}

"!="             { 
		   String lexeme = yytext();
		   System.out.print("<!=>");
		   return Main.noteq;   
		}
"="             { 
		   String lexeme = yytext();
		   System.out.print("<=>");
		   return Main.eq;   
		}

"-"             { 
		   String lexeme = yytext();
		   System.out.print("<->");
		   return Main.minus;   
		}
"/"             { 
		   String lexeme = yytext();
		   System.out.print("</>");
		   return Main.divide;   
		}

"*"             { 
		   String lexeme = yytext();
		   System.out.print("<*>");
		   return Main.multiply;   
		}
","             { 
		   String lexeme = yytext();
		   System.out.print("<,>");
		   return Main.comma;   
		}
";"             { 
		   String lexeme = yytext();
		   System.out.print("<;>");
		   return Main.semicolon;   
		}

"["             { 
		   String lexeme = yytext();
		   System.out.print("<[>");
		   return Main.leftStraightBracket;   
		}

"]"             { 
		   String lexeme = yytext();
		   System.out.print("<]>");
		   return Main.rightStraightBracket;   
		}

"=="             { 
		   String lexeme = yytext();
		   System.out.print("<==>");
		   return Main.eqeq;   
		}




/* error fallback */
[^]             {
                    System.err.println("Error: unexpected character '"+yytext()+"'");
                    return -1;
                }
