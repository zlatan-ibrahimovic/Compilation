package stree;

import itree.ITree;
import itree.ITreeInterface;
import itree.TEMP;
import type.Label;
import type.Temp;
import type.TypeException;
import evn.Env;

public class StreeIDENTIFIER extends Stree implements ITreeInterface{
	//Env currentEnv;
    // str gives type
    public StreeIDENTIFIER(String str, int line, int column) {
		super(EnumTag.IDENTIFIER, null, null, str);
    }
    
    // type given
    public StreeIDENTIFIER(Object object, String str) {
		super(EnumTag.IDENTIFIER, null, null, str);
		this.type=getEnumType();
		//this.currentEnv=currentEnv;
		//this.type=this.currentEnv.find(str);
    }
    
    // without str
    public StreeIDENTIFIER(Object object,Env currentEnv) {
		super(EnumTag.IDENTIFIER, null, null, null);
		////this.currentEnv=this.currentEnv;
		//this.type=currentEnv.find((String)object);
    }

    public ITree toITree(Label...labels) throws TypeException{
    	return new TEMP(new Temp());
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}

    
}
