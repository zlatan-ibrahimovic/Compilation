package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.Temp;


public class StreeINCR extends Stree {

	public StreeINCR(Stree left){
		super(EnumTag.INCR,left,null,null);
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
