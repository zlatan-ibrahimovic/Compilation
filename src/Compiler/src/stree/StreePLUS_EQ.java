
package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.Temp;

public class StreePLUS_EQ extends Stree {

    public StreePLUS_EQ(Stree left,Stree right){
		super(EnumTag.PLUS_EQ, left, right, null);
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
