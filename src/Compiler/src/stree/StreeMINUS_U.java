package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.Temp;

public class StreeMINUS_U extends Stree {

    public StreeMINUS_U(Stree left){
	super(EnumTag.MINUS_U, left, null, null);
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
