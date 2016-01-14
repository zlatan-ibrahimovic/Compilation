package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.Temp;

public class StreeRETURN extends Stree {

    public StreeRETURN(Stree left, Stree right){
		super(EnumTag.RETURN, left, right, null);
    }
    
    public StreeRETURN(Stree left){
		super(EnumTag.RETURN, left, null, null);
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
}
