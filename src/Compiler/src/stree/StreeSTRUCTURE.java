
package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.Temp;

public class StreeSTRUCTURE extends Stree {

    public StreeSTRUCTURE(Stree left,Stree right){
		super(EnumTag.STRUCTURE, left, right, null);
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
    
}