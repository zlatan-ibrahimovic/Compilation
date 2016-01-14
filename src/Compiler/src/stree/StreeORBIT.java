package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.Temp;

public class StreeORBIT extends Stree {

    public StreeORBIT(Stree left, Stree right){
		super(EnumTag.ORBIT, left, right, null);
    }

    public StreeORBIT(Stree s){
    	this(s,null);
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
