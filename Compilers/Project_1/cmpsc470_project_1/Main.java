import java.util.HashMap;

class Main
{
    public static final int NUM  = 10;
    public static final int REAL = 11;
    public static final int WORD = 12;
    public static final int PLUS = 13;
    public static final int IF   = 14;
    public static final int MAIN = 15;
    public static final int ELSE = 16;
    public static final int WHILE = 17;
    public static final int BOOL = 18;
    public static final int INT = 19;
    public static final int FLOAT = 20;
    public static final int PRINT = 21;
    public static final int TRUE = 22;
    public static final int FALSE = 23;
    public static final int leftParenthesis = 24;
    public static final int rightParenthesis = 25;
    public static final int leftBracket = 26;
    public static final int rightBracket = 27;
    public static final int lt = 28;
    public static final int gt = 29;
    public static final int lteq = 30;
    public static final int gteq = 31;
    public static final int noteq = 32;
    public static final int eq = 33;
    public static final int minus = 34;
    public static final int divide = 35;
    public static final int multiply = 36;
    public static final int comma = 37;
    public static final int semicolon = 38;
    public static final int leftStraightBracket = 39;
    public static final int rightStraightBracket = 40;
    public static final int eqeq = 41;
    public static final int ID = 42;
    public static final int comment = 43;

    public static java.util.HashMap<String, Integer> _symtbl;

    public static void main(String[] args) throws Exception
    {
        //java.io.Reader r = new java.io.StringReader
        //("main\n"
        //+"123\n"
        //+"1.23  123e1\n"
        //);

        HashMap<String, Integer> hmap = new HashMap<String, Integer>();

        
        if(args.length < 0)
            return;
        java.io.Reader r = new java.io.FileReader(args[0]);

        Lexer lex = new Lexer(r, hmap);

        while(true)
        {
            int token = lex.yylex();
            if(token == 0)
                // end of input
                break;
            if(token == -1)
                // error
                break;
        }
    }
}
