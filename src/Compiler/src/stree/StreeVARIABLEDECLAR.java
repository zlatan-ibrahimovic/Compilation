package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import stree.*;
import type.*;
import itree.*;

public class StreeVARIABLEDECLAR extends Stree implements ITreeInterface{
    //private Temp temp;
    public StreeVARIABLEDECLAR(Stree left,Stree right){
		super(EnumTag.VARIABLEDECLAR, left, right, null);
    }

    public ITree toITree(Label...labels) throws TypeException{
		this.temp=new Temp();
		System.out.println("OH temp "+temp);
		return new TEMP(temp);
	}
    
	public Temp getTemp(){
		return temp;
	}
}
