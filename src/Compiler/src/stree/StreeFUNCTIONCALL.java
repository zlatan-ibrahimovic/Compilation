package stree;

import itree.CALL;
import itree.ITree;
import itree.ITreeInterface;
import itree.NAME;
import type.Label;
import type.Temp;
import type.TypeException;

public class StreeFUNCTIONCALL extends Stree implements ITreeInterface{

    public StreeFUNCTIONCALL(String object,Stree s){
		super(EnumTag.FUNCTIONCALL, s, null, object);
    }

    public StreeFUNCTIONCALL(String object){
    	super(EnumTag.FUNCTIONCALL,new StreeFUNCTIONCALL(),null,object);
    }

    public StreeFUNCTIONCALL(){
    	super(EnumTag.VOID,null,null,null);
    }
    
    public ITree toITree() throws TypeException{
    	return new CALL(new NAME(new Label((String)object)),left.toITree());
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
}
