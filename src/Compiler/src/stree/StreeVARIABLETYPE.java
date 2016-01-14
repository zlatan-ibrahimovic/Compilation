package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.Temp;

public class StreeVARIABLETYPE extends Stree {

    public StreeVARIABLETYPE(Stree left, Stree right){
		super(EnumTag.VARIABLETYPE, left, right, null);
    }

    public StreeVARIABLETYPE(Stree s,Object o){
    	this(s,null);
    	this.object=o;

    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
