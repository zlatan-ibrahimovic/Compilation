package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.Temp;

public class StreeFUNCTIONARGS extends Stree {

    public StreeFUNCTIONARGS(Stree left, Stree right){
		super(EnumTag.FUNCTIONARGS, left, right, null);
    }
    
    public StreeFUNCTIONARGS(Stree left){
		super(EnumTag.FUNCTIONARGS, left, null, null);
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
}
