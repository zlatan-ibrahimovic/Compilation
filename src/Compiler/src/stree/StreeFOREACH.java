package stree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import stree.*;
import itree.*;
import type.*;

public class StreeFOREACH extends Stree {

    public StreeFOREACH(Stree left, Stree right){
		super(EnumTag.FOREACH, left, right, null);
    }
    

	/*public Stm toStm(){
		Stree t1=left;
		Exp e1=t1.left.toExp();
		EnumTag tag=left.tag;
		Exp e2=t1.right.toExp();
		Stree t2=right;
		Stm s1=t2.toStm();
		return StreeFOREACH.build(getNbr(tag),e1,e2,s1);
	}*/

	public int getNbr(EnumTag tag){
		switch(tag){
			case EQ: return CJUMP.EQ;
			case LT: return CJUMP.LT;
			case GE: return CJUMP.GE;
			case LE: return CJUMP.LE;
			case GT: return CJUMP.GT;
			default:return -1;
		}
	}


	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
}
