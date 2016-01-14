package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.Temp;

public class StreeFUNCTIONHEADER extends Stree {

    public StreeFUNCTIONHEADER(Stree left, Stree right){
	super(EnumTag.FUNCTIONHEADER, left, right, null);
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
