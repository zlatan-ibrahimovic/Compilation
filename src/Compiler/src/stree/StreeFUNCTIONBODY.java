package stree;

import type.Temp;


public class StreeFUNCTIONBODY extends Stree {

    public StreeFUNCTIONBODY(Stree left, Stree right){
	super(EnumTag.FUNCTIONBODY, left, right, null);
    }
    
    public StreeFUNCTIONBODY(Stree left){
	super(EnumTag.FUNCTIONBODY, left, null, null);
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
}
