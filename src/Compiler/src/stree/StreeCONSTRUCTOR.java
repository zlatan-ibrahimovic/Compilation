package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.Temp;

public class StreeCONSTRUCTOR extends Stree {

    public StreeCONSTRUCTOR(String object,Stree s){
	super(EnumTag.CONSTRUCTOR, s, null, object);
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
