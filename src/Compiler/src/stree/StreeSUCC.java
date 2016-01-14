package stree;

import type.*;
import itree.*;
import java.util.*;

public class StreeSUCC extends Stree implements ITreeInterface{

    public StreeSUCC(Stree left, Stree right){
	super(EnumTag.SUCC, left, right, null);
    }


    public ITree toITree(Label...label) throws TypeException{
	if(left instanceof StreeFUNCTIONCALL){
	    ITree t = new TEMP(new Temp());
	    ITree m = new MOVE(new TEMP(left.getTemp()),t);
	    return new SEQ(new ESEQ(m,((StreeFUNCTIONCALL) left).toITree(),t),right.toITree());
	}
	
	    
	return new SEQ(left.toITree(),right.toITree());
    }

    public Temp getTemp(){
	return null;
    }

    public List<Object> getArgs(){
	List<Object> l=new ArrayList<Object>();
	l=left.getArgs();
	System.out.println("OK MM\n")	;	
	List<Object> tmp=right.getArgs();
	System.out.println("OK MM\n");
	for(int i=0;i<tmp.size();i++)
	    l.add(tmp.get(i));
	return l;
    }
}
