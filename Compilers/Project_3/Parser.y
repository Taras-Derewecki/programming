%{
import java.io.*;
%}

%right ASSIGN
%left OR
%left AND
%right NOT
%left EQ NE LT GT GE LE
%left PLUS SUB
%left MUL DIV MOD

%token <sval> NUM ID REAL
%token MAIN PRINT BEGIN END WHILE IF RETURN ELSE COMMA OR AND NOT FLOAT
%token LPAREN RPAREN PLUS MUL SEMI INT BOOL TRUE FALSE ASSIGN

%type <obj> program type_spec main_decl decl fun_decl param_list
%type <obj> local_decls local_decl decl_list params param arg_list args
%type <obj> stmt_list stmt print_stmt compound_stmt expr_stmt if_stmt while_stmt return_stmt
%type <sval> expr

%%

program       : decl_list main_decl             { $$ = CallProgram($2);                  } 
              ;


decl_list     : decl_list decl                   { $$ = CallDeclListDecl($1, $2);         }
              |                                  { $$ = CallStmtListEps();                }
              ;

decl          : fun_decl                         { $$ = CallFunDecl($1);                  }
              ;

type_spec     : INT                              { $$ = CallTypeInt();                    }
              | FLOAT                            { $$ = CallTypeFloat();                  }
              | BOOL                             { $$ = CallTypeBool();                   }
              ;

main_decl     : MAIN LPAREN RPAREN compound_stmt { $$ = CallMain($4);                     }
              ;


fun_decl      : type_spec ID LPAREN params RPAREN SEMI { $$ = CallDeclFun($1, $2, $4);    }
              ;

params        : param_list                       { $$ = CallParamList($1);                }
              |                                  { $$ = CallParamListEps();               }
              ;

param_list    : param_list COMMA param           { $$ = CallParamList2($1, $3);           }
              ;

param         : type_spec                        { $$ = CallParamExpr($1);                }
              ;

stmt_list     : stmt_list stmt                   { $$ = CallStmtListRec($1, $2);          }
              |                                  { $$ = CallStmtListEps();                }
              ;

stmt          : compound_stmt                    { $$ = CallStmtCompound($1);             }
              | expr_stmt                        { $$ = CallStmtExpr($1);                 }
              | print_stmt                       { $$ = CallStmtPrint($1);                }
              | if_stmt                          { $$ = CallStmtIf($1);                   }
              | while_stmt                       { $$ = CallStmtWhile($1);                }
              | return_stmt                      { $$ = CallStmtReturn($1);               }
              ;

print_stmt    : PRINT expr SEMI                  { $$ = CallPrintExpr($2);                }
              ;

expr_stmt     : ID ASSIGN expr SEMI              { $$ = CallExprStmtIdAssignExpr($1, $3); }
              | SEMI                             { }
              ;

while_stmt    : WHILE LPAREN expr RPAREN stmt    { $$ = CallWhileStmtExprStmt($3, $5);    }
              ;

compound_stmt : BEGIN                            { $$ = CallCompoundStmtBegin();          }
                      local_decls stmt_list END  { $$ = CallCompoundStmtRest($2, $3, $4); } 
              ;


local_decls   : local_decls local_decl           { $$ = CallLocalDeclsRec($1, $2);        }
              |                                  { $$ = CallLocalDeclsEps();              }
              ;


local_decl    : type_spec ID SEMI                { $$ = CallLocalDecl($1, $2);            }
              ;

if_stmt       : IF LPAREN expr RPAREN stmt ELSE stmt { $$ = CallIfStmtExprStmtStmt($3, $5, $7);}
              ;

return_stmt   : RETURN SEMI                       { $$ = CallReturnStmt();                }
              ;

arg_list      : arg_list COMMA expr               { $$ = ArgListExpr($1, $3);             }
              | expr                              { $$ = ArgListExpr2($1);                }
              ;

args          : arg_list                          { $$ = ArgList($1);                     }
              |                                   { $$ = CallLocalDeclsEps();             }
              ;

expr          : expr PLUS expr                   { $$ = CallExprAdd($1, $3);              }
              | expr MUL expr                    { $$ = CallExprMul($1, $3);              }   
              | expr SUB expr                    { $$ = CallExprSub($1, $3);              }
              | expr DIV expr                    { $$ = CallExprDiv($1, $3);              }
              | expr MOD expr                    { $$ = CallExprMod($1, $3);              }
              | expr OR expr                     { $$ = CallExprOr($1, $3);               }
              | expr AND expr                    { $$ = CallExprAnd($1, $3);              }
              | NOT expr                         { $$ = CallExprNot($2);                  }
              | expr EQ expr                     { $$ = CallExprEQ($1, $3);               }
              | expr NE expr                     { $$ = CallExprNE($1, $3);               }
              | expr LT expr                     { $$ = CallExprLT($1, $3);               }
              | expr GT expr                     { $$ = CallExprGT($1, $3);               }
              | expr GE expr                     { $$ = CallExprGE($1, $3);               }
              | expr LE expr                     { $$ = CallExprLE($1, $3);               }
              | LPAREN expr RPAREN               { $$ = CallExprParen($2);                }
              | ID                               { $$ = CallExprId($1);                   }
              | ID LPAREN args RPAREN            { $$ = CallIDArgs($1, $3);               }
              | NUM                              { $$ = CallExprNum();                    }
              | REAL                             { $$ = CallExprReal();                   }
              | TRUE                             { $$ = CallExprTrue();                   }
              | FALSE                            { $$ = CallExprFalse();                  }
              ;



%%
private Lexer lexer;

private int yylex () {
    int yyl_return = -1;
    try {
        yylval = new ParserVal(0);
        yyl_return = lexer.yylex();
    }
    catch (IOException e) {
        System.err.println("IO error :"+e);
    }
    return yyl_return;
}

public void yyerror (String error) {
    System.out.println("Error: " + error);
}

public Parser(Reader r) {
    lexer = new Lexer(r, this);
}
