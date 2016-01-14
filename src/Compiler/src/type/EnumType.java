package type;

public enum EnumType {
   CHARACTER ("char"),
   INT ("int"),
   FLOAT ("float"),
   STRING ("String"),
   BOOLEAN ("boolean"),
   ARRAY ("array"),
   POINTER ("pointer"),
   ERROR ("error"),
   VARIABLE("variable"),
   FUNCTION("function"),
   TIMES("times"),
   LIST ("list");
       
   private final String tag;
	
   EnumType(String s){
      tag = s;
   }

   public String toString(){
      return tag;
   }
}


