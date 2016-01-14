
package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.Temp;

public class StreeFUNCTIONDECLAR extends Stree {

    public StreeFUNCTIONDECLAR(Stree left, Stree right,Object object){
	super(EnumTag.FUNCTIONDECLAR, left, right, object);
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
    
}