package stree;

import itree.BINOP;
import itree.ITree;
import itree.ITreeInterface;
import type.EnumType;
import type.Label;
import type.TypeException;
import evn.Env;
import type.*;
import ICode.*;
import java.util.*;
public class StreeMULT extends Stree implements ITreeInterface{
	private Env currentEnv;

    public StreeMULT(Stree left, Stree right,Env currentEnv) throws TypeException{
		super(EnumTag.MULT, left, right, null);

		this.currentEnv=currentEnv;		
		
		if (isIntegerOrFloat(left)){
			this.left.type = left.getEnumType();
		}else{
			if (currentEnv.find(String.valueOf(left.getObject()))==null){
				throw new TypeException("variable ["+ left.getObject() +"] not declared  ");
			}
			else{
				this.left.type=currentEnv.find(String.valueOf(left.getObject())).getEnumType();
			}
		}
		
		if (isIntegerOrFloat(right)){
			this.right.type = right.getEnumType();
		}else{
			if (currentEnv.find(String.valueOf(right.getObject()))==null){
				throw new TypeException("variable ["+ right.getObject() +"] not declared  ");
			}
			else{
				this.right.type=currentEnv.find(String.valueOf(right.getObject())).getEnumType();
			}
		} 
		
    }
    
	public ITree toITree(Label...labels)throws TypeException{
		EnumType t1 = this.left.getEnumType();
		EnumType t2 = this.right.getEnumType();
		Temp t=new Temp();
		if (t1.toString().compareTo(t2.toString()) == 0) {
			return new BINOP(0, left.toITree(), right.toITree());
		} else {
			throw new TypeException("type incompatible " + t1 + " et " + t2);
		}
			
    }
	
	public List<Object> getArgs(){
		List<Object> l=new ArrayList<Object>();
		l.add(left.getObject());
		l.add("*");
		l.add(right.getObject());
		return l;
	}

	
	public EnumType getEnumType(){
		return this.right.type;
	}
	
	public Temp getTemp(){
		return null;
	}
	

}
