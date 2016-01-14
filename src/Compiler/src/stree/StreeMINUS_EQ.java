
package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.Temp;

public class StreeMINUS_EQ extends Stree {

    public StreeMINUS_EQ(Stree left,Stree right){
		super(EnumTag.MINUS_EQ, left, right, null);
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
