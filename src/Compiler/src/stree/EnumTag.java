package stree;

public enum EnumTag { 
    
    IF ("IF"), 
    THENELSE ("THENELSE"), 
    WHILE ("WHILE"), 
    AFF ("="), 
    NOT ("!"), 
    AND ("&&"), 
    OR ("||"), 
    LT ("<"), 
    GT (">"), 
    LE ("<="), 
    GE (">="), 
    EQ ("=="), 
    DIFF ("!=") , 
    PLUS ("+"), 
    MINUS ("-"), 
    MINUS_U ("-"), 
    MULT ("*"), 
    DIV ("/"), 
    MOD ("%"), 
    EXP("EXP"),
    SUCC("SUCC"),
    PRODUCT("PRODUCT"),
    IDENTIFIER ("IDENTIFIER"),
    CALL ("CALL"),
    TABLE ("TABLE"),
    CHARACTER ("CHARACTER"), 
    INTEGER ("INTEGER"), 
    FLOAT ("FLOAT"), 
	STRING("STRING"),
    FOREACH("foreach"),
    FOREACHHEADER("foreach_header"),
    LSHIFT("<<"),
    RSHIFT(">>"),
    ORBIT("|"),
    FUNCTIONARGS("args"),
    FUNCTIONBODY("body"),
    FUNCTIONHEADER("function_header"),
    VARIABLETYPE("'"),
    FUNCTIONDECLAR("function"),
    REPEATWHILE("repeat_while"),
    PLUS_EQ("+="),
    MINUS_EQ("-="),
    MULT_EQ("*="),
    DIV_EQ("/="),
    MOD_EQ("%="),
    LISTOF("list of"),
    VARIABLEDECLAR("type of"),
    BOOLEAN("BOOLEAN"),
    STRUCTURE("structure"),
    RETURN("return"),
    CONSTRUCTOR("construtor"),
    DESTRUCTOR("destructor"),
    CLASS("class"),
    FUNCTIONCALL("function_call"),
    VOID("void"),
    PROCEDURE("procedure"),
    POINTERTYPE("^"),
    ARRAY("array"),
    INCR("++"),
    DECR("--"),
    BODY("body");

    private final String tag;

    EnumTag(String s){
            tag = s;
    }

    public String toString(){
            return tag;
    }


}

