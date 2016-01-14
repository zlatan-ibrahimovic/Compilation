package stree;

import itree.Exp;
import itree.NAME;
import type.Label;
import type.Temp;

public class StreeCLASS extends Stree {

    public StreeCLASS(String object,Stree s){
	super(EnumTag.CLASS, s, null, object);
    }

    public static Exp build(Label l){
		return new NAME(l);
	}

	public Exp toExp(){
		Label l=new Label((String)object);
		return StreeCLASS.build(l);
	}

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
