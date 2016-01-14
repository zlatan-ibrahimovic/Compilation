package stree;

import itree.CJUMP;
import itree.Exp;
import itree.ITree;
import itree.ITreeInterface;
import itree.SEQ;
import itree.Stm;
import type.Label;
import type.Temp;

public class StreeFOREACHHEADER extends Stree implements ITreeInterface{

    public StreeFOREACHHEADER(Stree left, Stree right){
		super(EnumTag.FOREACHHEADER, left, right, null);
    }
    
/*
	public ITree toITree(){
		ITree t1=left;
		ITree e1=t1.left.toITree();
		EnumTag tag=left.tag;
		ITree e2=t1.right.toITree();
		ITree t2=right.toITree();
		ITree s1=t2.toITree();
		return new SEQ(new CJUMP(rel,e1,e2,l1,l2),s);
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
