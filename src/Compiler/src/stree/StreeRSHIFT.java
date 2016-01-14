package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.Temp;

public class StreeRSHIFT extends Stree {

    public StreeRSHIFT(Stree left, Stree right){
	super(EnumTag.RSHIFT, left, right, null);
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
