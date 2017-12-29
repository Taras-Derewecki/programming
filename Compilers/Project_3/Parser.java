//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";






//#line 1 "Parser.y"

import java.io.*;
//#line 20 "Parser.java"




public class Parser
             extends ParserBase
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//public class ParserVal is defined in ParserVal.java


String   yytext;//user variable to return contextual strings
ParserVal yyval; //used to return semantic vals from action routines
ParserVal yylval;//the 'lval' (result) I got from yylex()
ParserVal valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new ParserVal[YYSTACKSIZE];
  yyval=new ParserVal();
  yylval=new ParserVal();
  valptr=-1;
}
void val_push(ParserVal val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
ParserVal val_pop()
{
  if (valptr<0)
    return new ParserVal();
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
ParserVal val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return new ParserVal();
  return valstk[ptr];
}
final ParserVal dup_yyval(ParserVal val)
{
  ParserVal dup = new ParserVal();
  dup.ival = val.ival;
  dup.dval = val.dval;
  dup.sval = val.sval;
  dup.obj = val.obj;
  return dup;
}
//#### end semantic value section ####
public final static short ASSIGN=257;
public final static short OR=258;
public final static short AND=259;
public final static short NOT=260;
public final static short EQ=261;
public final static short NE=262;
public final static short LT=263;
public final static short GT=264;
public final static short GE=265;
public final static short LE=266;
public final static short PLUS=267;
public final static short SUB=268;
public final static short MUL=269;
public final static short DIV=270;
public final static short MOD=271;
public final static short NUM=272;
public final static short ID=273;
public final static short REAL=274;
public final static short MAIN=275;
public final static short PRINT=276;
public final static short BEGIN=277;
public final static short END=278;
public final static short WHILE=279;
public final static short IF=280;
public final static short RETURN=281;
public final static short ELSE=282;
public final static short COMMA=283;
public final static short FLOAT=284;
public final static short LPAREN=285;
public final static short RPAREN=286;
public final static short SEMI=287;
public final static short INT=288;
public final static short BOOL=289;
public final static short TRUE=290;
public final static short FALSE=291;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    8,    8,    3,    1,    1,    1,    2,    4,    9,
    9,    5,   10,   13,   13,   14,   14,   14,   14,   14,
   14,   15,   17,   17,   19,   22,   16,    6,    6,    7,
   18,   20,   11,   11,   12,   12,   21,   21,   21,   21,
   21,   21,   21,   21,   21,   21,   21,   21,   21,   21,
   21,   21,   21,   21,   21,   21,   21,
};
final static short yylen[] = {                            2,
    2,    2,    0,    1,    1,    1,    1,    4,    6,    1,
    0,    3,    1,    2,    0,    1,    1,    1,    1,    1,
    1,    3,    4,    1,    5,    0,    5,    2,    0,    3,
    7,    2,    3,    1,    1,    0,    3,    3,    3,    3,
    3,    3,    3,    2,    3,    3,    3,    3,    3,    3,
    3,    1,    4,    1,    1,    1,    1,
};
final static short yydefred[] = {                         3,
    0,    0,    0,    6,    5,    7,    0,    1,    2,    4,
    0,    0,    0,   11,   26,    8,    0,    0,   29,    0,
    0,    0,   13,   12,    9,    0,   28,    0,    0,    0,
    0,   27,    0,    0,    0,   24,   14,   18,   16,   17,
   19,   20,   21,   30,    0,    0,   54,    0,   55,    0,
   56,   57,    0,    0,    0,   32,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   22,    0,    0,   23,    0,    0,    0,
   51,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   38,   40,   41,    0,    0,    0,   53,   25,    0,
    0,    0,   31,
};
final static short yydgoto[] = {                          1,
    7,    8,    9,   10,   17,   22,   27,    2,   18,   24,
   78,   79,   28,   37,   38,   39,   40,   41,   42,   43,
   53,   19,
};
final static short yysindex[] = {                         0,
    0, -130, -277,    0,    0,    0, -241,    0,    0,    0,
 -229, -232, -219,    0,    0,    0, -220, -210,    0, -233,
 -205, -233,    0,    0,    0, -192,    0,   62, -204, -173,
 -231,    0, -200, -198, -199,    0,    0,    0,    0,    0,
    0,    0,    0,    0, -231, -231,    0, -178,    0, -231,
    0,    0, -167, -231, -231,    0, -153,   47, -231,   21,
 -231, -231, -231, -231, -231, -231, -231, -231, -231, -231,
 -231, -231, -231,    0,   35,   61,    0, -190, -163,  111,
    0,  124,   47, -222, -222, -222, -222, -222, -222, -267,
 -267,    0,    0,    0,   84,   84, -231,    0,    0, -139,
  111,   84,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0, -142,    0,    0,    0,
    0,   75,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0, -197,    0,    0,
    0,    0,    0,    0,    0,    0,    0, -252, -138,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0, -135,    0, -253,
    0, -208, -247,  -96,  -87,  -57,  -48,  -18,   -9, -137,
 -126,    0,    0,    0,    0,    0,    0,    0,    0,    0,
 -206,    0,    0,
};
final static short yygindex[] = {                         0,
   -7,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  -58,    0,  106,    0,    0,    0,    0,
  -45,    0,
};
final static int YYTABLESIZE=395;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         57,
   58,   71,   72,   73,   60,   44,   44,   11,   75,   76,
   43,   43,   23,   80,   26,   82,   83,   84,   85,   86,
   87,   88,   89,   90,   91,   92,   93,   94,   46,   34,
   44,   12,   34,   44,   44,   43,   99,  100,   43,   43,
   47,   48,   49,  103,   69,   70,   71,   72,   73,   42,
    4,  101,   14,   50,    5,    6,   13,   15,   51,   52,
   52,   52,   20,   52,   52,   52,   52,   52,   52,   52,
   52,   52,   52,   52,   42,   21,   33,   42,   42,   33,
   29,   25,   44,   45,   54,   52,   55,   56,   52,   52,
   61,   62,   97,   63,   64,   65,   66,   67,   68,   69,
   70,   71,   72,   73,   61,   62,   59,   63,   64,   65,
   66,   67,   68,   69,   70,   71,   72,   73,   16,   74,
   37,   37,   98,   37,   37,   37,   37,   37,   37,   37,
   37,   39,   39,   77,   39,   39,   39,   39,   39,   39,
   39,   39,  102,   10,    3,   37,    0,   36,   37,   37,
   35,    0,    0,    4,    0,    0,   39,    5,    6,   39,
   39,   45,   45,    0,   45,   45,   45,   45,   45,   45,
   46,   46,    0,   46,   46,   46,   46,   46,   46,    0,
    0,    0,    0,    0,    0,    0,   45,    0,    0,   45,
   45,    0,    0,    0,    0,   46,    0,    0,   46,   46,
   47,   47,    0,   47,   47,   47,   47,   47,   47,   48,
   48,    0,   48,   48,   48,   48,   48,   48,    0,    0,
    0,    0,    0,    0,    0,   47,    0,    0,   47,   47,
    0,    0,    0,    0,   48,    0,    0,   48,   48,   49,
   49,    0,   49,   49,   49,   49,   49,   49,   50,   50,
    0,   50,   50,   50,   50,   50,   50,    0,    0,    0,
    0,    0,    0,    0,   49,    0,    0,   49,   49,    0,
    0,    0,    0,   50,    0,    0,   50,   50,   61,   62,
    0,   63,   64,   65,   66,   67,   68,   69,   70,   71,
   72,   73,   61,   62,    0,   63,   64,   65,   66,   67,
   68,   69,   70,   71,   72,   73,   81,   63,   64,   65,
   66,   67,   68,   69,   70,   71,   72,   73,   61,   62,
   95,   63,   64,   65,   66,   67,   68,   69,   70,   71,
   72,   73,    0,    0,   30,    0,    0,   31,   15,   32,
   33,   34,   35,    0,    0,    0,   96,   15,   36,    0,
   15,   15,   15,   15,   15,   15,   30,    0,    0,   31,
   15,   15,   33,   34,   35,    0,    0,    0,   61,   62,
   36,   63,   64,   65,   66,   67,   68,   69,   70,   71,
   72,   73,   62,    0,   63,   64,   65,   66,   67,   68,
   69,   70,   71,   72,   73,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         45,
   46,  269,  270,  271,   50,  258,  259,  285,   54,   55,
  258,  259,   20,   59,   22,   61,   62,   63,   64,   65,
   66,   67,   68,   69,   70,   71,   72,   73,  260,  283,
  283,  273,  286,  286,  287,  283,   95,   96,  286,  287,
  272,  273,  274,  102,  267,  268,  269,  270,  271,  258,
  284,   97,  285,  285,  288,  289,  286,  277,  290,  291,
  258,  259,  283,  261,  262,  263,  264,  265,  266,  267,
  268,  269,  270,  271,  283,  286,  283,  286,  287,  286,
  273,  287,  287,  257,  285,  283,  285,  287,  286,  287,
  258,  259,  283,  261,  262,  263,  264,  265,  266,  267,
  268,  269,  270,  271,  258,  259,  285,  261,  262,  263,
  264,  265,  266,  267,  268,  269,  270,  271,   13,  287,
  258,  259,  286,  261,  262,  263,  264,  265,  266,  267,
  268,  258,  259,  287,  261,  262,  263,  264,  265,  266,
  267,  268,  282,  286,  275,  283,   -1,  286,  286,  287,
  286,   -1,   -1,  284,   -1,   -1,  283,  288,  289,  286,
  287,  258,  259,   -1,  261,  262,  263,  264,  265,  266,
  258,  259,   -1,  261,  262,  263,  264,  265,  266,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  283,   -1,   -1,  286,
  287,   -1,   -1,   -1,   -1,  283,   -1,   -1,  286,  287,
  258,  259,   -1,  261,  262,  263,  264,  265,  266,  258,
  259,   -1,  261,  262,  263,  264,  265,  266,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  283,   -1,   -1,  286,  287,
   -1,   -1,   -1,   -1,  283,   -1,   -1,  286,  287,  258,
  259,   -1,  261,  262,  263,  264,  265,  266,  258,  259,
   -1,  261,  262,  263,  264,  265,  266,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  283,   -1,   -1,  286,  287,   -1,
   -1,   -1,   -1,  283,   -1,   -1,  286,  287,  258,  259,
   -1,  261,  262,  263,  264,  265,  266,  267,  268,  269,
  270,  271,  258,  259,   -1,  261,  262,  263,  264,  265,
  266,  267,  268,  269,  270,  271,  286,  261,  262,  263,
  264,  265,  266,  267,  268,  269,  270,  271,  258,  259,
  286,  261,  262,  263,  264,  265,  266,  267,  268,  269,
  270,  271,   -1,   -1,  273,   -1,   -1,  276,  277,  278,
  279,  280,  281,   -1,   -1,   -1,  286,  273,  287,   -1,
  276,  277,  278,  279,  280,  281,  273,   -1,   -1,  276,
  277,  287,  279,  280,  281,   -1,   -1,   -1,  258,  259,
  287,  261,  262,  263,  264,  265,  266,  267,  268,  269,
  270,  271,  259,   -1,  261,  262,  263,  264,  265,  266,
  267,  268,  269,  270,  271,
};
}
final static short YYFINAL=1;
final static short YYMAXTOKEN=291;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"ASSIGN","OR","AND","NOT","EQ","NE","LT","GT","GE","LE","PLUS",
"SUB","MUL","DIV","MOD","NUM","ID","REAL","MAIN","PRINT","BEGIN","END","WHILE",
"IF","RETURN","ELSE","COMMA","FLOAT","LPAREN","RPAREN","SEMI","INT","BOOL",
"TRUE","FALSE",
};
final static String yyrule[] = {
"$accept : program",
"program : decl_list main_decl",
"decl_list : decl_list decl",
"decl_list :",
"decl : fun_decl",
"type_spec : INT",
"type_spec : FLOAT",
"type_spec : BOOL",
"main_decl : MAIN LPAREN RPAREN compound_stmt",
"fun_decl : type_spec ID LPAREN params RPAREN SEMI",
"params : param_list",
"params :",
"param_list : param_list COMMA param",
"param : type_spec",
"stmt_list : stmt_list stmt",
"stmt_list :",
"stmt : compound_stmt",
"stmt : expr_stmt",
"stmt : print_stmt",
"stmt : if_stmt",
"stmt : while_stmt",
"stmt : return_stmt",
"print_stmt : PRINT expr SEMI",
"expr_stmt : ID ASSIGN expr SEMI",
"expr_stmt : SEMI",
"while_stmt : WHILE LPAREN expr RPAREN stmt",
"$$1 :",
"compound_stmt : BEGIN $$1 local_decls stmt_list END",
"local_decls : local_decls local_decl",
"local_decls :",
"local_decl : type_spec ID SEMI",
"if_stmt : IF LPAREN expr RPAREN stmt ELSE stmt",
"return_stmt : RETURN SEMI",
"arg_list : arg_list COMMA expr",
"arg_list : expr",
"args : arg_list",
"args :",
"expr : expr PLUS expr",
"expr : expr MUL expr",
"expr : expr SUB expr",
"expr : expr DIV expr",
"expr : expr MOD expr",
"expr : expr OR expr",
"expr : expr AND expr",
"expr : NOT expr",
"expr : expr EQ expr",
"expr : expr NE expr",
"expr : expr LT expr",
"expr : expr GT expr",
"expr : expr GE expr",
"expr : expr LE expr",
"expr : LPAREN expr RPAREN",
"expr : ID",
"expr : ID LPAREN args RPAREN",
"expr : NUM",
"expr : REAL",
"expr : TRUE",
"expr : FALSE",
};

//#line 131 "Parser.y"

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
//#line 391 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
throws Exception
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 24 "Parser.y"
{ yyval.obj = CallProgram(val_peek(0).obj);                  }
break;
case 2:
//#line 28 "Parser.y"
{ yyval.obj = CallDeclListDecl(val_peek(1).obj, val_peek(0).obj);         }
break;
case 3:
//#line 29 "Parser.y"
{ yyval.obj = CallStmtListEps();                }
break;
case 4:
//#line 32 "Parser.y"
{ yyval.obj = CallFunDecl(val_peek(0).obj);                  }
break;
case 5:
//#line 35 "Parser.y"
{ yyval.obj = CallTypeInt();                    }
break;
case 6:
//#line 36 "Parser.y"
{ yyval.obj = CallTypeFloat();                  }
break;
case 7:
//#line 37 "Parser.y"
{ yyval.obj = CallTypeBool();                   }
break;
case 8:
//#line 40 "Parser.y"
{ yyval.obj = CallMain(val_peek(0).obj);                     }
break;
case 9:
//#line 44 "Parser.y"
{ yyval.obj = CallDeclFun(val_peek(5).obj, val_peek(4).sval, val_peek(2).obj);    }
break;
case 10:
//#line 47 "Parser.y"
{ yyval.obj = CallParamList(val_peek(0).obj);                }
break;
case 11:
//#line 48 "Parser.y"
{ yyval.obj = CallParamListEps();               }
break;
case 12:
//#line 51 "Parser.y"
{ yyval.obj = CallParamList2(val_peek(2).obj, val_peek(0).obj);           }
break;
case 13:
//#line 54 "Parser.y"
{ yyval.obj = CallParamExpr(val_peek(0).obj);                }
break;
case 14:
//#line 57 "Parser.y"
{ yyval.obj = CallStmtListRec(val_peek(1).obj, val_peek(0).obj);          }
break;
case 15:
//#line 58 "Parser.y"
{ yyval.obj = CallStmtListEps();                }
break;
case 16:
//#line 61 "Parser.y"
{ yyval.obj = CallStmtCompound(val_peek(0).obj);             }
break;
case 17:
//#line 62 "Parser.y"
{ yyval.obj = CallStmtExpr(val_peek(0).obj);                 }
break;
case 18:
//#line 63 "Parser.y"
{ yyval.obj = CallStmtPrint(val_peek(0).obj);                }
break;
case 19:
//#line 64 "Parser.y"
{ yyval.obj = CallStmtIf(val_peek(0).obj);                   }
break;
case 20:
//#line 65 "Parser.y"
{ yyval.obj = CallStmtWhile(val_peek(0).obj);                }
break;
case 21:
//#line 66 "Parser.y"
{ yyval.obj = CallStmtReturn(val_peek(0).obj);               }
break;
case 22:
//#line 69 "Parser.y"
{ yyval.obj = CallPrintExpr(val_peek(1).sval);                }
break;
case 23:
//#line 72 "Parser.y"
{ yyval.obj = CallExprStmtIdAssignExpr(val_peek(3).sval, val_peek(1).sval); }
break;
case 24:
//#line 73 "Parser.y"
{ }
break;
case 25:
//#line 76 "Parser.y"
{ yyval.obj = CallWhileStmtExprStmt(val_peek(2).sval, val_peek(0).obj);    }
break;
case 26:
//#line 79 "Parser.y"
{ yyval.obj = CallCompoundStmtBegin();          }
break;
case 27:
//#line 80 "Parser.y"
{ yyval.obj = CallCompoundStmtRest(val_peek(3).obj, val_peek(2).obj, val_peek(1).obj); }
break;
case 28:
//#line 84 "Parser.y"
{ yyval.obj = CallLocalDeclsRec(val_peek(1).obj, val_peek(0).obj);        }
break;
case 29:
//#line 85 "Parser.y"
{ yyval.obj = CallLocalDeclsEps();              }
break;
case 30:
//#line 89 "Parser.y"
{ yyval.obj = CallLocalDecl(val_peek(2).obj, val_peek(1).sval);            }
break;
case 31:
//#line 92 "Parser.y"
{ yyval.obj = CallIfStmtExprStmtStmt(val_peek(4).sval, val_peek(2).obj, val_peek(0).obj);}
break;
case 32:
//#line 95 "Parser.y"
{ yyval.obj = CallReturnStmt();                }
break;
case 33:
//#line 98 "Parser.y"
{ yyval.obj = ArgListExpr(val_peek(2).obj, val_peek(0).sval);             }
break;
case 34:
//#line 99 "Parser.y"
{ yyval.obj = ArgListExpr2(val_peek(0).sval);                }
break;
case 35:
//#line 102 "Parser.y"
{ yyval.obj = ArgList(val_peek(0).obj);                     }
break;
case 36:
//#line 103 "Parser.y"
{ yyval.obj = CallLocalDeclsEps();             }
break;
case 37:
//#line 106 "Parser.y"
{ yyval.sval = CallExprAdd(val_peek(2).sval, val_peek(0).sval);              }
break;
case 38:
//#line 107 "Parser.y"
{ yyval.sval = CallExprMul(val_peek(2).sval, val_peek(0).sval);              }
break;
case 39:
//#line 108 "Parser.y"
{ yyval.sval = CallExprSub(val_peek(2).sval, val_peek(0).sval);              }
break;
case 40:
//#line 109 "Parser.y"
{ yyval.sval = CallExprDiv(val_peek(2).sval, val_peek(0).sval);              }
break;
case 41:
//#line 110 "Parser.y"
{ yyval.sval = CallExprMod(val_peek(2).sval, val_peek(0).sval);              }
break;
case 42:
//#line 111 "Parser.y"
{ yyval.sval = CallExprOr(val_peek(2).sval, val_peek(0).sval);               }
break;
case 43:
//#line 112 "Parser.y"
{ yyval.sval = CallExprAnd(val_peek(2).sval, val_peek(0).sval);              }
break;
case 44:
//#line 113 "Parser.y"
{ yyval.sval = CallExprNot(val_peek(0).sval);                  }
break;
case 45:
//#line 114 "Parser.y"
{ yyval.sval = CallExprEQ(val_peek(2).sval, val_peek(0).sval);               }
break;
case 46:
//#line 115 "Parser.y"
{ yyval.sval = CallExprNE(val_peek(2).sval, val_peek(0).sval);               }
break;
case 47:
//#line 116 "Parser.y"
{ yyval.sval = CallExprLT(val_peek(2).sval, val_peek(0).sval);               }
break;
case 48:
//#line 117 "Parser.y"
{ yyval.sval = CallExprGT(val_peek(2).sval, val_peek(0).sval);               }
break;
case 49:
//#line 118 "Parser.y"
{ yyval.sval = CallExprGE(val_peek(2).sval, val_peek(0).sval);               }
break;
case 50:
//#line 119 "Parser.y"
{ yyval.sval = CallExprLE(val_peek(2).sval, val_peek(0).sval);               }
break;
case 51:
//#line 120 "Parser.y"
{ yyval.sval = CallExprParen(val_peek(1).sval);                }
break;
case 52:
//#line 121 "Parser.y"
{ yyval.sval = CallExprId(val_peek(0).sval);                   }
break;
case 53:
//#line 122 "Parser.y"
{ yyval.sval = CallIDArgs(val_peek(3).sval, val_peek(1).obj);               }
break;
case 54:
//#line 123 "Parser.y"
{ yyval.sval = CallExprNum();                    }
break;
case 55:
//#line 124 "Parser.y"
{ yyval.sval = CallExprReal();                   }
break;
case 56:
//#line 125 "Parser.y"
{ yyval.sval = CallExprTrue();                   }
break;
case 57:
//#line 126 "Parser.y"
{ yyval.sval = CallExprFalse();                  }
break;
//#line 768 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
//## The -Jnorun option was used ##
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
