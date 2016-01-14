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
public class StreeMINUS extends Stree implements ITreeInterface{
	private Env currentEnv;

    public StreeMINUS(Stree left, Stree right,Env currentEnv) throws TypeException{
		super(EnumTag.MINUS, left, right, null);

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
		Stree.quadruples.add(new Entry("-",left.getObject(),right.getObject(),t));
		if (t1.toString().compareTo(t2.toString()) == 0) {
			return new BINOP(0, left.toITree(), right.toITree());
		} else {
			throw new TypeException("type incompatible " + t1 + " et " + t2);
		}
			
    }
	
	
	public EnumType getEnumType(){
		return this.right.type;
	}

	public Temp getTemp(){
		return null;
	}

}
