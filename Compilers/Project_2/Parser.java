/// program         -> main_decl
/// main_decl       -> MAIN LPAREN RPAREN BEGIN stmt_list END
/// stmt_list       -> print_stmt stmt_list | eps
/// print_stmt      -> PRINT expr SEMI
/// expr            -> ID | NUM

import java.util.List;
import java.util.ArrayList;

public class Parser
{
    public static final int MAIN            = 10;     // "main"
    public static final int PRINT           = 11;     // "print"
    public static final int BEGIN           = 12;     // "{"
    public static final int END             = 13;     // "}"
    public static final int LPAREN          = 14;     // "("
    public static final int RPAREN          = 15;     // ")"
    public static final int ASSIGN          = 16;     // "="
    public static final int SEMI            = 17;     // ";"
    public static final int NUM             = 18;     // [0-9]+
    public static final int REAL            = 19;     // [0-9]+"."[0-9]+(E[+-]?[0-9]+)?
    public static final int ID              = 20;     // [a-zA-Z_][a-zA-Z0-9_]*
    public static final int ENDMARKER       = 21;     // $
    public static final int QUOTE           = 22;     // "
    public static final int INTEGERTYPE     = 23;     // int
    public static final int FLOATTYPE       = 24;     // float
    public static final int WHILELOOP       = 25;     // while
    public static final int IFSTATEMENT     = 26;     // if
    public static final int RETURNSTATEMENT = 27;     // return
    public static final int ELSESTATEMENT   = 28;     // else
    public static final int ADDITION        = 29;     // +
    public static final int SUBTRACTION     = 30;     // -
    public static final int MULTIPLICATION  = 31;     // *
    public static final int DIVISION        = 32;     // /
    public static final int MODULUS         = 33;     // %
    public static final int TRUEBOOL        = 34;     // true
    public static final int FALSEBOOL       = 35;     // -
    public static final int EE              = 36;     // ==
    public static final int NE              = 37;     // !=
    public static final int L               = 38;     // <
    public static final int G               = 39;     // >
    public static final int LE              = 40;     // <=
    public static final int GE              = 41;     // >=


    public class Token 
    {
        public int       type;
        public ParserVal attr;

        public Token(int type, ParserVal attr) 
        {
            this.type = type;
            this.attr = attr;
        }
    }

    public ParserVal yylval;
    Token[]          _tokens;
    //List<Token> token = new ArrayList<Token>();
    int              _lah;

    public Parser(java.io.Reader r) throws java.io.IOException
    {
        this._tokens   = new Token[214748364];

        this._lah      = 0;

        Lexer lex = new Lexer(r, this);
        for(int i=0; i<214748364; i++)
        {
            int token_type = lex.yylex();
            if (token_type == 0 ) { _tokens[i] = new Token(Parser.ENDMARKER, null); break; } // end of input
            if (token_type == -1) { _tokens[i] = new Token(Parser.ENDMARKER, null); break; } // error

            _tokens[i] = new Token(token_type, yylval);
        }
    }

    public void Advance() throws java.io.IOException
    {
        _lah ++;
    }
    public boolean Match(int token_type) throws java.io.IOException
    {
        //System.out.println(_lah);
        if (_lah < 0 || _lah >= 214748364)
            return false;

        boolean Match = (token_type == _tokens[_lah].type);
        _lah ++;
        return Match;
    }
    public int GetTokenLocation()
    {
        return _lah;
    }
    public void ResetTokenLocation(int loc)
    {
        _lah = loc;
    }

    public int yyparse() throws java.io.IOException
    {
        parse();
        return 0;
    }

    public void parse() throws java.io.IOException
    {
        if(program())
            System.out.println("Success");
        else
            System.out.println("Error: Syntax error.");
    }

    /// program         -> main_decl
    ///                  ;
    public boolean program() throws java.io.IOException
    {
        //System.out.println("Program has been executed");
        int loc = GetTokenLocation();

        /// program -> main_decl
        ResetTokenLocation(loc);
        if(main_decl() && Match(ENDMARKER))
            return true;

        return false;
    }



    public boolean type_spec() throws java.io.IOException
    {
        //System.out.println("Type_Spec has been executed");
        /*
            type_spec -> "int" | "float"
        */

            int loc = GetTokenLocation();
            ResetTokenLocation(loc);
            if(Match(INTEGERTYPE))
                return true;

            ResetTokenLocation(loc);
            if(Match(FLOATTYPE))
                return true;

			return false;
    }
    
    
    
    public boolean local_decl() throws java.io.IOException
    {
        //System.out.println("Local_Decl has been executed");
        int loc = GetTokenLocation();

        // local_decl -> type_spec ID ";"
        ResetTokenLocation(loc);
        
		if(type_spec())
            if(Match(ID))
                if(Match(SEMI))
                    return true;

        return false;

    }
    
    
    public boolean local_decls() throws java.io.IOException
    {
        //System.out.println("Local_Decls has been executed");
        int loc = GetTokenLocation();

        // local_decls -> local_decl local_decls | eps
        ResetTokenLocation(loc);

        if(local_decl())
            if(local_decls())
                return true;

        ResetTokenLocation(loc);
        return true;    
    }  
    
    
    public boolean compound_stmt() throws java.io.IOException
    {
        //System.out.println("Compound_Stmt has been executed");
        int loc = GetTokenLocation();

        // compound_stmt -> "{" Local_decls stmt_list "}"
        ResetTokenLocation(loc);
        if(Match(BEGIN))
            if(local_decls())
                if(stmt_list())
                    if(Match(END))
                        return true;

        return false;
    }



    /// main_decl       -> MAIN LPAREN RPAREN BEGIN stmt_list END
    ///                  ;
    public boolean main_decl() throws java.io.IOException
    {
        //System.out.println("Main_Decl has been executed");
        int loc = GetTokenLocation();

        /// main_decl -> MAIN LPAREN RPAREN BEGIN stmt_list END
        ResetTokenLocation(loc);
        if(Match(MAIN))
            if(Match(LPAREN))
                if(Match(RPAREN))
                    if(compound_stmt())
                        return true;

        return false;
    }



    /// stmt_list       -> print_stmt stmt_list
    ///                  | eps
    ///                  ;
    public boolean stmt_list() throws java.io.IOException
    {
        //System.out.println("Stmt_List has been executed");
        int loc = GetTokenLocation();

        /// stmt_list -> print_stmt stmt_list
        ResetTokenLocation(loc);
        if(stmt())
            if(stmt_list())
                return true;

        // if(print_stmt() && stmt_list())
        //     return true;

        /// stmt_list -> eps
        ResetTokenLocation(loc);
        return true;
    }


    public boolean stmt() throws java.io.IOException
    {
        //System.out.println("Stmt has been executed");
        int loc = GetTokenLocation();

        // stmt -> expr_stmt|print_stmt|compound_stmt|if_stmt|while_stmt|return_stmt
        ResetTokenLocation(loc);
        if(expr_stmt())
            return true;

        ResetTokenLocation(loc);
        if(print_stmt())
            return true;

        ResetTokenLocation(loc);
        if(compound_stmt())
            return true;

        ResetTokenLocation(loc);
        if(if_stmt())
            return true;

        ResetTokenLocation(loc);
        if(while_stmt())
            return true;

        ResetTokenLocation(loc);
        if(return_stmt())
            return true;


        return false;
    }

    public boolean if_stmt() throws java.io.IOException
    {
        //System.out.println("If_Stmt has been executed");
        int loc = GetTokenLocation();

        // if_stmt -> "if" "(" bexpr ")" stmt "else" stmt
        ResetTokenLocation(loc);
        if(Match(IFSTATEMENT))
        	if(Match(LPAREN))
                if(bexpr())
            		if(Match(RPAREN))
            			if(stmt())
            				if(Match(ELSESTATEMENT))
        						if(stmt())
        							return true;
        							
        return false;

    }
    
    
    public boolean while_stmt() throws java.io.IOException
    {
        //System.out.println("While_Stmt has been executed");
        int loc = GetTokenLocation();

        // while_stmt -> "while" "(" bexpr ")" stmt "else" stmt
        ResetTokenLocation(loc);
        if(Match(WHILELOOP))
        	if(Match(LPAREN))
        		if(bexpr())
        			if(Match(RPAREN))
        				if(stmt())
        					return true;
        							
        return false;

    }
    
    public boolean return_stmt() throws java.io.IOException
    {
        //System.out.println("Return_Stmt has been executed");
        int loc = GetTokenLocation();

        // return_stmt -> "return" ";" | "return" expr ";"
        ResetTokenLocation(loc);
        if(Match(RETURNSTATEMENT))
        	if(Match(SEMI))
        		return true;
        		
        		
        ResetTokenLocation(loc);
        if(Match(RETURNSTATEMENT))
        	if(expr())
        		if(Match(SEMI))
        			return true;
        							
        return false;
    }


    public boolean expr_stmt() throws java.io.IOException
    {
        //System.out.println("Expr_stmt has been executed");
        int loc = GetTokenLocation();

        // expr_stmt -> ID "=" expr ";" | ";"
        ResetTokenLocation(loc);
        if(Match(ID))
            if(Match(ASSIGN))
                if(expr())
                    if(Match(SEMI))
                        return true;


        ResetTokenLocation(loc);    
        if(Match(SEMI))
            return true;


        return false;
    }

    /// print_stmt      -> PRINT expr SEMI
    ///                  ;
    public boolean print_stmt() throws java.io.IOException
    {
        //System.out.println("Print_Stmt has been executed");

        int loc = GetTokenLocation();

        /// print_stmt -> PRINT expr SEMI
        if(Match(PRINT))
            if(expr())
                if(Match(SEMI))
                    return true;

        return false;
    }
    /// expr -> ID
    ///       | NUM
    ///       ;
    public boolean expr() throws java.io.IOException
    {
        //System.out.println("Expr has been executed");
        int loc = GetTokenLocation();

        /// expr -> ID
        ResetTokenLocation(loc);
        //expr -> term expr'
        if(term())
        	if(exprDash())
        		return true;
        
       // if(Match(ID ))
           // return true;

        /// expr -> NUM
        //ResetTokenLocation(loc);
        //if(Match(NUM))
           // return true;

        return false;
    }
    
    public boolean exprDash() throws java.io.IOException
    {
        //System.out.println("ExprDash has been executed");
        int loc = GetTokenLocation();

        /// expr' -> "+" term expr'|"-" term expr'|eps
        ResetTokenLocation(loc);
        if(Match(ADDITION))
        	if(term())
        		if(exprDash())
        			return true;
        			
        ResetTokenLocation(loc);
        if(Match(SUBTRACTION))
        	if(term())
        		if(exprDash())
        			return true;
        
        ResetTokenLocation(loc);
        return true;
    }
    
    public boolean term() throws java.io.IOException
    {   
        //System.out.println("Term has been executed");
    	int loc = GetTokenLocation();
    	// term -> factor term'
    	ResetTokenLocation(loc);
    	if(factor())
    		if(termDash())
    			return true;
    			
    	return false;
    }
    
    public boolean termDash() throws java.io.IOException
    {
        //System.out.println("TermDash has been executed");
    	int loc = GetTokenLocation();
    	
    	// term' -> "*" factor term'|"/" factor term'| "%" factor term'|eps
    	ResetTokenLocation(loc);
    	if(Match(MULTIPLICATION))
    		if(factor())
    			if(termDash())
    				return true;
    				
    	ResetTokenLocation(loc);
    	if(Match(DIVISION))
    		if(factor())
    			if(termDash())
    				return true;
    				
    	ResetTokenLocation(loc);
    	if(Match(MODULUS))
    		if(factor())
    			if(termDash())
    				return true;

        ResetTokenLocation(loc);
        return true;
    }
    
    
    public boolean bexpr() throws java.io.IOException
    {
        //System.out.println("Bexpr has been executed");
    	int loc = GetTokenLocation();
    	
    	// bexpr -> "true"|"false"|expr "==" expr|expr "!=" expr| expr "<" expr|expr ">" expr|expr "<=" expr|expr ">=" expr
    	ResetTokenLocation(loc);
    	if(Match(TRUEBOOL))
    		return true;
    		
    	ResetTokenLocation(loc);
    	if(Match(FALSEBOOL))
    		return true;
    				
    	ResetTokenLocation(loc);
    	if(expr())
    		if(Match(EE))
    			if(expr())
    				return true;
    				
    	ResetTokenLocation(loc);
    	if(expr())
    		if(Match(NE))
    			if(expr())
    				return true;
    				
    	ResetTokenLocation(loc);
    	if(expr())
    		if(Match(L))
    			if(expr())
    				return true;
    				
        ResetTokenLocation(loc);
    	if(expr())
    		if(Match(G))
    			if(expr())
    				return true;
    				
    	ResetTokenLocation(loc);
    	if(expr())
    		if(Match(LE))
    			if(expr())
    				return true;
    				
    	ResetTokenLocation(loc);
    	if(expr())
    		if(Match(GE))
    			if(expr())
    				return true;

        ResetTokenLocation(loc);
        return true;
    }
    
    
    public boolean factor() throws java.io.IOException
    {
        //System.out.println("Factor has been executed");
    	int loc = GetTokenLocation();
    	// factor -> "(" expr ")"|ID|NUM|REAL
    	ResetTokenLocation(loc);
    	if(Match(LPAREN))
    		if(expr())
    			if(Match(RPAREN))
    				return true;
    				
    	ResetTokenLocation(loc);
    	if(Match(ID))
    		return true;
    		
    	ResetTokenLocation(loc);
    	if(Match(NUM))
    		return true;
    		
    	ResetTokenLocation(loc);
    	if(Match(REAL))
    		return true;

    	// ResetTokenLocation(loc);
    	// if(Match(NUM))
    	// 	return true;
    		
    	// ResetTokenLocation(loc);	
    	// if(Match(REAL))
    	// 	return true;
    			
        return false;
    }
}
