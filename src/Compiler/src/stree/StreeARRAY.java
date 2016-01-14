package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.Temp;


public class StreeARRAY extends Stree {

	public StreeARRAY(Stree left){
		super(EnumTag.ARRAY,left,null,null);
    }

    public StreeARRAY(){
    	super(EnumTag.VOID,null,null,null);
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}


    
}
