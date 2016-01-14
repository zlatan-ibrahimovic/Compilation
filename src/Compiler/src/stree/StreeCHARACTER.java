package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.*;

public class StreeCHARACTER extends Stree {

    public StreeCHARACTER(String object){
	super(EnumTag.CHARACTER, null, null, object);
    }
    
     public StreeCHARACTER(){
    	super(EnumTag.CHARACTER,null,null,null);
    }

	public EnumType getType(){
		return EnumType.CHARACTER;
	}

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
}
