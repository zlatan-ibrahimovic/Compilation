package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.Temp;

public class StreeDESTRUCTOR extends Stree {

    public StreeDESTRUCTOR(String object,Stree s){
	super(EnumTag.DESTRUCTOR, s, null, object);
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
