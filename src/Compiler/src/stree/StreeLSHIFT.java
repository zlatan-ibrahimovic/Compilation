package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.Temp;

public class StreeLSHIFT extends Stree {

    public StreeLSHIFT(Stree left, Stree right){
	super(EnumTag.LSHIFT, left, right, null);
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
