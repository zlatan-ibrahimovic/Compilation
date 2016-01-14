package stree;

import itree.ITree;
import itree.JUMP;
import itree.LABEL;
import itree.SEQ;
import type.Label;
import type.Temp;
import type.TypeException;
import evn.Env;
import ICode.*;
import java.util.*;

public class StreeIF extends Stree{
	private Env currentEnv;
    public StreeIF(Stree left, Stree right,Env currentEnv){
		super(EnumTag.IF, left, right, null);
		this.currentEnv=currentEnv;
    }

	public ITree toITree(Label...labels) throws TypeException{
		Label l1=new Label();
		Label l2=new Label();
		Label l3=new Label();
		ITree s1=right.left.toITree();
		ITree s2=right.right.toITree();
		Stree.quadruples.add(new Entry(left.getArgs().get(1),"if "+left.getArgs().get(0),left.getArgs().get(2)+" GOTO "+l2,null));
		int i;		
		System.out.println("OK i="+Stree.quadruples.getIndex());
		
		List<Object> l=right.right.getArgs();
		int j=0;
		while(j<l.size()-1){
			Stree.quadruples.add(new Entry(l.get(j+1),l.get(j),l.get(j+2),null));
			j=j+3;
		}
		l=right.left.getArgs();
		j=0;
		System.out.println("OM Al="+l+" "+l.size());
		//System.out.println("H j="+Stree.quadruples.getIndex()+" i="+l.size());
		Stree.quadruples.add(new Entry(null,l2+":",null,null));
		System.out.println("OM Al="+l+" "+l.size());
		//System.out.println("H j="+Stree.quadruples.getIndex()+" i="+l.size());
		while(j<l.size()-1){
			Stree.quadruples.add(new Entry(l.get(j+1),l.get(j),l.get(j+2),null));
			System.out.println("o\n");
			j=j+3;
		}
		System.out.println("K");
		//Stree.quadruples.add(new Entry("if",null,null,"GOTO "+l2));
		return new SEQ(left.toITree(l1, l2), 
				new SEQ(
new LABEL(l1),new SEQ(s1,new SEQ(new JUMP(l3), new SEQ(new LABEL(l2), new SEQ(s2,new LABEL(l3)))))
					)
		);
	}

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
}
