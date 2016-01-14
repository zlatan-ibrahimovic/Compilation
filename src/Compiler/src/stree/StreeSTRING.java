package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.*;
import itree.*;

public class StreeSTRING extends Stree{

    public StreeSTRING(String object){
		super(EnumTag.STRING, null, null, object);
    }

    public StreeSTRING(){
    	super(EnumTag.STRING,null,null,null);
    }

	
	public EnumType getEnumType(){
		return EnumType.STRING;
	}

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}

}
