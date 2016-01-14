package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.Temp;


public class StreeDECR extends Stree {

	public StreeDECR(Stree left){
		super(EnumTag.DECR,left,null,null);
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
