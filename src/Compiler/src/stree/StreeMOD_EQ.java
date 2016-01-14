
package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import type.Temp;

public class StreeMOD_EQ extends Stree {

    public StreeMOD_EQ(Stree left,Stree right){
		super(EnumTag.MOD_EQ, left, right, null);
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
