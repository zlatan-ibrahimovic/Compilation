package stree;

import itree.ITree;
import itree.ITreeInterface;
import itree.MOVE;
import type.EnumType;
import type.Label;
import type.TypeException;
import evn.Env;
import type.*;
import java.util.*;
import ICode.*;
public class StreeAFF extends Stree implements ITreeInterface {
	private Env currentEnv;
    public StreeAFF(Stree left, Stree right,Env currentEnv)throws TypeException{
		super(EnumTag.AFF, left, right, null);
		
		this.currentEnv=currentEnv;		

		if (currentEnv.find(String.valueOf(left.getObject()))==null){
			throw new TypeException("variable ["+ left.getObject() +"] non declare ");
		}
		else{
			this.left.type=currentEnv.find(String.valueOf(left.getObject())).getEnumType();
		}
		
		if (right.getEnumType()==null){
			throw new TypeException("variable ["+ right.getObject() +"] non declare ");
		}
		else{
			this.right.type=right.getEnumType();
		}
		
    }

	public ITree toITree(Label...labels)throws TypeException{ 
    	EnumType t1 = this.left.getEnumType();
		EnumType t2 = this.right.getEnumType();
		//Temp t=new Temp();
		List<Object> l=right.getArgs();
		Stree.quadruples.add(new Entry(l.get(1),l.get(0),l.get(2),left.getObject()));
		if (t1.toString().compareTo(t2.toString()) == 0) {
			return new MOVE(left.toITree(),right.toITree());
		} else {
			throw new TypeException("type incompatible " + t1 + " et " + t2);
		}
		
	}
    
	public Temp getTemp(){
		return null;
	}
}
