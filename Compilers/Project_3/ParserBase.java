import java.util.ArrayList;

@SuppressWarnings("unchecked")

public class ParserBase
{
    public  int   linenum;
    Env env = new Env(null);

    // void Debug(String msg)
    // {
    //     System.out.println(msg);
    // }


    Object CallProgram(Object main_decl)
    {
        //Debug("Debugging...");
        return main_decl;
    }

    Object CallDeclListMainDecl(Object decl_list)
    {
        //((ArrayList<Object>)decl_list).add(main_decl);
        return decl_list;
    }


    Object CallDeclListDecl(Object decl_list, Object decl)
    {
        ((ArrayList<Object>)decl_list).add(decl);
        return decl_list;
    }

    Object CallMain(Object compound_stmt)
    {
        return compound_stmt;
    }

    Object CallStmtListRec(Object stmt_list, Object stmt)
    {
        ((ArrayList<Object>)stmt_list).add(stmt);
        return stmt_list;
    }

    Object CallStmtListEps()
    {
        return new ArrayList<Object>();
    }

    Object CallStmtCompound(Object compound_stmt)
    {
        return compound_stmt;
    }

    Object CallStmtExpr(Object expr_stmt)
    {
        return expr_stmt;
    }

    Object CallStmtIf(Object if_stmt)
    {
        return if_stmt;
    }

    Object CallStmtWhile(Object while_stmt)
    {
        return while_stmt;
    }

    Object CallStmtReturn(Object return_stmt)
    {
        return return_stmt;
    }

    Object CallStmtPrint(Object print_stmt)
    {
        System.out.println("test");
        return print_stmt;
    }

    Object CallParamExpr(Object type_spec)
    {
        return type_spec;
    }

    Object CallParamsExpr(ArrayList<String> params)
    {
        params = new ArrayList<String>();
        return params;
    }

    Object CallParamList(Object param)
    {
        ArrayList<String> list = new ArrayList<>();
        list.add((String)param);
        return param;
    }

    Object CallParamListEps()
    {
        return new ArrayList<Object>();   
    }

    Object CallParamList2(Object param_list, Object param)
    {
        ((ArrayList<Object>)param_list).add(param);
        return param_list;
    }


    Object CallWhileStmtExprStmt(String expr, Object stmt) throws Exception
    {
        // 1. expr will have expr type
        // 2. get type of ID
        // 3. compare the ID_type and expr_type
        // 4. if their types are same, then OK
        // 5. if different, then print error message, and throw exception to stop parsing
        // You should re-write this function since this is a simplified version


        if(expr == "BOOL")
            return "CallWhileStmtExprStmt "+expr+" "+stmt;

        else
        {
            System.out.println("Error: try to assign wrong type to "+expr+" at line "+linenum);
            throw new Exception();
        }
    }


    Object CallIfStmtExprStmtStmt(String expr, Object stmt, Object stmt2) throws Exception
    {
        // 1. expr will have expr type
        // 2. get type of ID
        // 3. compare the ID_type and expr_type
        // 4. if their types are same, then OK
        // 5. if different, then print error message, and throw exception to stop parsing
        // You should re-write this function since this is a simplified version


        if(expr == "BOOL")
            return "CallIfStmtExprStmtStmt "+expr+" "+stmt;

        else
        {
            System.out.println("Error: try to assign wrong type to "+expr+" at line "+linenum);
            throw new Exception();
        }
    }

    Object ArgListExpr(Object arg_list, String expr)
    {
        //ArrayList<String> args_list = new ArrayList<String>();
            //Object expressionAdded = ArgListExpr2(expr);
        ((ArrayList<String>) arg_list).add(expr);
        //args_list = ArgList(arg_list);
        //return arg_list;
        return arg_list;
    }


    String ArgListExpr2(String expr)
    {
        ArrayList<String> arg_list = new ArrayList<String>();
        //String stringExpr = String.valueOf(expr);
        arg_list.add(expr);
        return expr;
    }


    Object ArgList(Object arg_list)
    {
        return arg_list;
    }

    Object CallExprStmtIdAssignExpr(String ID, String expr) throws Exception
    {
        // 1. expr will have expr type
        // 2. get type of ID
        // 3. compare the ID_type and expr_type
        // 4. if their types are same, then OK
        // 5. if different, then print error message, and throw exception to stop parsing
        // You should re-write this function since this is a simplified version
        String ID_type = (String)(env.Get(ID));
        //if(ID_type == expr)
            //return "CallExprStmtIdAssignExpr "+ID+" "+expr;  

        if (ID_type == expr) {
            return ID_type;
        }

        if (ID_type == "FLOAT" && expr == "FLOAT") {
            return "FLOAT";
        }

        if (ID_type == "INT" && expr == "INT") {
            return "INT";
        }

        if (ID_type == "BOOL" && expr == "BOOL") {
            return "BOOL";
        }

        else
        {
            //System.out.println("Error: try to assign wrong type to "+ID+" at line "+linenum);
            System.out.println("Error at line " + linenum + ": try to assign " + expr + " value to " + ID_type+ " variable " + ID);
            throw new Exception();
        }
    }

    Object CallCompoundStmtBegin()
    {
        env = new Env(env);
        return "CallCompoundStmtBegin";
    }

    Object CallCompoundStmtRest(Object begin, Object local_decls, Object stmt_list)
    {
        env = env.prev;
        return "CallCompoundStmtRest";
    }

    Object CallLocalDeclsRec(Object local_decls, Object local_decl)
    {
        ((ArrayList<String>)local_decls).add((String)local_decl);
        return local_decls;
    }

    Object CallLocalDeclsEps()
    {
        return new ArrayList<String>();
    }

    Object CallLocalDecl(Object type_spec, String ID)
    {
        // You should re-write this function since this is a simplified version
        switch((String)type_spec)
        {
            case "CallTypeInt" : env.Put(ID, "INT" ); break;
            case "CallTypeFloat" : env.Put(ID, "FLOAT"); break;
            case "CallTypeBool" : env.Put(ID, "BOOL"); break;
        }

        return "CallLocalDecl "+type_spec+" "+ID;
    }

    Object CallDeclFun(Object type_spec, String ID, Object params) throws Exception
    {
        // You should re-write this function since this is a simplified version
    //     switch((String)type_spec)
    //     {
    //         case "CallTypeInt": env.Put(ID, "INT");
    //         case "CallTypeBool": env.Put(ID, "BOOL");
    //         case "CallTypeFloat": env.Put(ID, "FLOAT");
    //     }
    //     return "CallFunDecl"; // insert the type_spec, and the ID.... so return the params

        if(env.Get(ID) != null)
        {
            System.out.println("Error at line: " + linenum + " variable already declared.");
            throw new Exception();
        }

        return "CallFunDecl" + type_spec + " " + ID;
    }


    Object CallFunDecl(Object type_spec)
    {
        return type_spec;
    }

    // Object CallFunDecl(Object type_spec, String ID, Object params) throws Exception
    // {
    //     switch((String)type_spec)
    //     {
    //         case "CallTypeInt": env.Put(ID, "INT");
    //         case "CallTypeBool": env.Put(ID, "BOOL");
    //         case "CallTypeFloat": env.Put(ID, "FLOAT");
    //     }
    //     return "CallFunDecl"; // insert the type_spec, and the ID.... so return the params

    //     // if(env.Get(ID) != null)
    //     // {
    //     //     System.out.println("Error at line: " + linenum + " variable already declared.");
    //     //     throw new Exception();
    //     // }

    //     // return "CallFunDecl" + type_spec + " " + ID;
    // }

    Object CallTypeInt()
    {
        return "CallTypeInt";
    }


    Object CallTypeFloat()
    {
        return "CallTypeFloat";
    }


    Object CallTypeBool()
    {
        return "CallTypeBool";
    }

    Object CallPrintExpr(String expr)
    {
        // dont need to check semantic error here
        return "CallPrintExpr "+ expr;
    }


    String CallExprNot(String expr1) throws Exception
    {
        if (expr1.equals("BOOL"))
            return "BOOL";

        else
        {
            System.out.println("Error at line "+linenum+ ": (not " + expr1 +") is not allowed.");
            throw new Exception();
        }
    }

    String CallExprAnd(String expr1, String expr2) throws Exception
    {
        if ( expr1.equals("BOOL") && expr2.equals("BOOL") )
            return "BOOL";

        if( expr2.equals("BOOL") && expr1.equals("BOOL") )
            return "BOOL";

        else
        {
            System.out.println("Error at line "+linenum+ ": (" + expr1 + " and " + expr2 +") is not allowed.");
            throw new Exception();
        }
    }


    String CallExprOr(String expr1, String expr2) throws Exception
    {
        if (expr1.equals("BOOL") && expr2.equals("BOOL"))
            return "BOOL";

        if( expr2.equals("BOOL") && expr1.equals("BOOL") )
            return "BOOL";


        else
        {
            System.out.println("Error at line "+linenum+ ": (" + expr1 + " or " + expr2 +") is not allowed.");
            throw new Exception();
        }
    }


    String CallExprEQ(String expr1, String expr2) throws Exception
    {
        if (expr1.equals("INT") && expr2.equals("INT"))
            return "BOOL";

        if (expr1.equals("INT") && expr2.equals("FLOAT"))
            return "BOOL";

        if (expr1.equals("FLOAT") && expr2.equals("INT"))
            return "BOOL";

        if (expr1.equals("FLOAT") && expr2.equals("FLOAT"))
            return "BOOL";

        if (expr1.equals("BOOL") && expr2.equals("BOOL"))
            return "BOOL";

        if (expr2.equals("BOOL") && expr1.equals("BOOL"))
            return "BOOL";

        else
        {
            System.out.println("Error at line "+linenum+ ": (" + expr1 + " == " + expr2 +") is not allowed.");
            throw new Exception();
        }
    }


    String CallExprNE(String expr1, String expr2) throws Exception
    {
        if (expr1.equals("INT") && expr2.equals("INT"))
            return "BOOL";

        if (expr1.equals("INT") && expr2.equals("FLOAT"))
            return "BOOL";

        if (expr1.equals("FLOAT") && expr2.equals("INT"))
            return "BOOL";

        if (expr1.equals("FLOAT") && expr2.equals("FLOAT"))
            return "BOOL";

        if (expr1.equals("BOOL") && expr2.equals("BOOL"))
            return "BOOL";

        if (expr2.equals("BOOL") && expr1.equals("BOOL"))
            return "BOOL";

        else
        {
            System.out.println("Error at line "+linenum+ ": (" + expr1 + " != " + expr2 +") is not allowed.");
            throw new Exception();
        }
    }


    String CallExprLT(String expr1, String expr2) throws Exception
    {
        if (expr1.equals("INT") && expr2.equals("INT"))
            return "BOOL";

        if (expr1.equals("INT") && expr2.equals("FLOAT"))
            return "BOOL";

        if (expr1.equals("FLOAT") && expr2.equals("INT"))
            return "BOOL";

        if (expr1.equals("FLOAT") && expr2.equals("FLOAT"))
            return "BOOL";

        // if (expr1.equals("BOOL") && expr2.equals("BOOL"))
        //     return "BOOL";

        // if (expr2.equals("BOOL") && expr1.equals("BOOL"))
        //     return "BOOL";

        else
        {
            System.out.println("Error at line "+linenum+ ": (" + expr1 + " < " + expr2 +") is not allowed.");
            throw new Exception();
        }
    }


    String CallExprGT(String expr1, String expr2) throws Exception
    {
        if (expr1.equals("INT") && expr2.equals("INT"))
            return "BOOL";

        if (expr1.equals("INT") && expr2.equals("FLOAT"))
            return "BOOL";

        if (expr1.equals("FLOAT") && expr2.equals("INT"))
            return "BOOL";

        if (expr1.equals("FLOAT") && expr2.equals("FLOAT"))
            return "BOOL";

        // if (expr1.equals("BOOL") && expr2.equals("BOOL"))
        //     return "BOOL";

        // if (expr2.equals("BOOL") && expr1.equals("BOOL"))
        //     return "BOOL";

        else
        {
            System.out.println("Error at line "+linenum+ ": (" + expr1 + " > " + expr2 +") is not allowed.");
            throw new Exception();
        }
    }


    String CallExprGE(String expr1, String expr2) throws Exception
    {
        if (expr1.equals("INT") && expr2.equals("INT"))
            return "BOOL";

        if (expr1.equals("INT") && expr2.equals("FLOAT"))
            return "BOOL";

        if (expr1.equals("FLOAT") && expr2.equals("INT"))
            return "BOOL";

        if (expr1.equals("FLOAT") && expr2.equals("FLOAT"))
            return "BOOL";

        // if (expr1.equals("BOOL") && expr2.equals("BOOL"))
        //     return "BOOL";

        // if (expr2.equals("BOOL") && expr1.equals("BOOL"))
        //     return "BOOL";

        else
        {
            System.out.println("Error at line "+linenum+ ": (" + expr1 + " >= " + expr2 +") is not allowed.");
            throw new Exception();
        }
    }


    String CallExprLE(String expr1, String expr2) throws Exception
    {
        if (expr1.equals("INT") && expr2.equals("INT"))
            return "BOOL";

        if (expr1.equals("INT") && expr2.equals("FLOAT"))
            return "BOOL";

        if (expr1.equals("FLOAT") && expr2.equals("INT"))
            return "BOOL";

        if (expr1.equals("FLOAT") && expr2.equals("FLOAT"))
            return "BOOL";

        // if (expr1.equals("BOOL") && expr2.equals("BOOL"))
        //     return "BOOL";

        // if (expr2.equals("BOOL") && expr1.equals("BOOL"))
        //     return "BOOL";

        else
        {
            System.out.println("Error at line "+linenum+ ": (" + expr1 + " <= " + expr2 +") is not allowed.");
            throw new Exception();
        }
    }


    String CallExprAdd(String expr1, String expr2) throws Exception
    {
        // 1. expr1 has type of expr1
        // 2. expr2 has type of expr2
        // 3. if both of their types are int, then (int + int)->int, return "int"
        // 4. if not, then print error message, and throw exception to stop parsing
        // You should re-write this function since this is a simplified version
        if (expr1.equals("INT") && expr2.equals("INT"))
            return "INT";

        if (expr1.equals("INT") && expr2.equals("FLOAT"))
            return "FLOAT";

        if (expr1.equals("FLOAT") && expr2.equals("INT"))
            return "FLOAT";

        if (expr1.equals("FLOAT") && expr2.equals("FLOAT"))
            return "FLOAT";

        //if (expr1.equals("bool") && expr2.equals("bool"))
            //return "bool";

        else
        {
            System.out.println("Error at line "+linenum+ ": (" + expr1 + " + " + expr2 +") is not allowed.");
            throw new Exception();
        }
    }

    String CallExprMul(String expr1, String expr2) throws Exception
    {
        // 1. expr1 has type of expr1
        // 2. expr2 has type of expr2
        // 3. if both of their types are int, then (int * int)->int, return "int"
        // 4. if not, then print error message, and throw exception to stop parsing
        // You should re-write this function since this is a simplified version
        if (expr1.equals("INT") && expr2.equals("INT"))
            return "INT";

        if (expr1.equals("INT") && expr2.equals("FLOAT"))
            return "FLOAT";

        if (expr1.equals("FLOAT") && expr2.equals("INT"))
            return "FLOAT";

        if (expr1.equals("FLOAT") && expr2.equals("FLOAT"))
            return "FLOAT";

        //if (expr1.equals("bool") && expr2.equals("bool"))
            //return "bool";

        else
        {
            System.out.println("Error at line "+linenum+ ": (" + expr1 + " * " + expr2 +") is not allowed.");
            throw new Exception();
        }
    }

    String CallExprSub(String expr1, String expr2) throws Exception
    {
        // 1. expr1 has type of expr1
        // 2. expr2 has type of expr2
        // 3. if both of their types are int, then (int * int)->int, return "int"
        // 4. if not, then print error message, and throw exception to stop parsing
        // You should re-write this function since this is a simplified version
        if (expr1.equals("INT") && expr2.equals("INT"))
            return "INT";

        if (expr1.equals("INT") && expr2.equals("FLOAT"))
            return "FLOAT";

        if (expr1.equals("FLOAT") && expr2.equals("INT"))
            return "FLOAT";

        if (expr1.equals("FLOAT") && expr2.equals("FLOAT"))
            return "FLOAT";

        //if (expr1.equals("bool") && expr2.equals("bool"))
            //return "bool";
        
        else
        {
            System.out.println("Error at line "+linenum+ ": (" + expr1 + " - " + expr2 +") is not allowed.");
            throw new Exception();
        }
    }


    String CallExprDiv(String expr1, String expr2) throws Exception
    {
        // 1. expr1 has type of expr1
        // 2. expr2 has type of expr2
        // 3. if both of their types are int, then (int * int)->int, return "int"
        // 4. if not, then print error message, and throw exception to stop parsing
        // You should re-write this function since this is a simplified version
        if (expr1.equals("INT") && expr2.equals("INT"))
            return "INT";

        if (expr1.equals("INT") && expr2.equals("FLOAT"))
            return "FLOAT";

        if (expr1.equals("FLOAT") && expr2.equals("INT"))
            return "FLOAT";

        if (expr1.equals("FLOAT") && expr2.equals("FLOAT"))
            return "FLOAT";

        //if (expr1.equals("bool") && expr2.equals("bool"))
            //return "bool";
        
        else
        {
            System.out.println("Error at line "+linenum+ ": (" + expr1 + " / " + expr2 +") is not allowed.");
            throw new Exception();
        }
    }


    String CallExprMod(String expr1, String expr2) throws Exception
    {
        // 1. expr1 has type of expr1
        // 2. expr2 has type of expr2
        // 3. if both of their types are int, then (int * int)->int, return "int"
        // 4. if not, then print error message, and throw exception to stop parsing
        // You should re-write this function since this is a simplified version
        if (expr1.equals("INT") && expr2.equals("INT"))
            return "INT";

        if (expr1.equals("INT") && expr2.equals("FLOAT"))
            return "FLOAT";

        if (expr1.equals("FLOAT") && expr2.equals("INT"))
            return "FLOAT";

        if (expr1.equals("FLOAT") && expr2.equals("FLOAT"))
            return "FLOAT";

        //if (expr1.equals("bool") && expr2.equals("bool"))
            //return "bool";
        
        else
        {
            System.out.println("Error at line "+linenum+ ": (" + expr1 + " % " + expr2 +") is not allowed.");
            throw new Exception();
        }
    }



    String CallExprParen(String expr)
    {
        return expr;
    }

    String CallIDArgs(String ID, Object args) throws Exception
    {
        //((ArrayList<String>) args).add(ID);

        Object check = env.Get(ID);

        if (check instanceof ArrayList) 
            return ID;
            //return (String)env.Get(ID);

        System.out.println("Error at line " + linenum + ": undefined " + ID + " is used.");
        throw new Exception();
    }

    String CallExprId(String ID) throws Exception
    {
        // 1. in symbol table, env[ID] has its type in string, such as "int" or "bool"
        // 2. so return env[ID]
        // You should re-write this function since this is a simplified version
        // For example, if ID is function name, you should show error message.

        Object check = env.Get(ID);

        if (check instanceof String) 
            return (String)env.Get(ID); 

        System.out.println("Error at line " + linenum + ": undefined " + ID + " is used.");
        throw new Exception();

        //return ID;
    }

    String CallExprNum()
    {
        //Debug("Debugging... CallExprNum("+val+")");
        // in this semantic checker, you can return type of value
        return "INT";
    }

    String CallExprReal()
    {
        // in this semantic checker, you can return type of value
        return "FLOAT";
    }

    String CallExprTrue()
    {
        // in this semantic checker, you can return type of value
        return "BOOL";
    }

    String CallExprFalse()
    {
        // in this semantic checker, you can return type of value
        return "BOOL";
    }

    Object CallReturnStmt()
    {
        return "CallReturnStmt";
    }
}
