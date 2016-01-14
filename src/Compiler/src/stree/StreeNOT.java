package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.Temp;

public class StreeNOT extends Stree {

    public StreeNOT(Stree left){
	super(EnumTag.NOT, left, null, null);
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
