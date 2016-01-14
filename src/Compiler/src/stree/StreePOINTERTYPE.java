package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.Temp;


public class StreePOINTERTYPE extends Stree {

	public StreePOINTERTYPE(Stree left){
		super(EnumTag.POINTERTYPE,left,null,null);
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}


    
}
