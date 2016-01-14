package stree;

import itree.CJUMP;
import itree.ITree;
import itree.JUMP;
import itree.LABEL;
import itree.SEQ;
import type.Label;
import type.Temp;
import type.TypeException;
import itree.*;
import ICode.*;
import java.util.*;

public class StreeWHILE extends Stree {

    public StreeWHILE(Stree left, Stree right){
		super(EnumTag.WHILE, left, right, null);
    }
    
	public ITree toITree(Label...labels) throws TypeException{
		ITree e1=left.left.toITree();
		ITree e2=left.right.toITree();
		EnumTag tag=left.tag;
		Label l1=new Label();
		Label l2=new Label();
		Label l3=new Label();		
		ITree s=right.toITree();
	   Stree.quadruples.add(new Entry(null,l1+":",null,null));
		Stree.quadruples.add(new Entry("==","if "+left.getArgs().get(0),left.getArgs().get(2)+" GOTO "+l2,null));
		List<Object> l=right.getArgs();
		int j=0;
		while(j<l.size()-1){
			Stree.quadruples.add(new Entry(l.get(j+1),l.get(j),l.get(j+2),null));
			j=j+2;
		}
		Stree.quadruples.add(new Entry(null,"GOTO "+l1,null,null));
		Stree.quadruples.add(new Entry(null,l2+":",null,null));
		return new SEQ(left.toITree(l1,l2),new SEQ(new LABEL(l2),new SEQ(new SEQ(s,new JUMP(l1)),new LABEL(l3))));
	}
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
