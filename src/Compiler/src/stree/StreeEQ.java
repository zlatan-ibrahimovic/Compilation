package stree;

import itree.CJUMP;
import itree.ITree;
import itree.ITreeInterface;
import type.EnumType;
import type.Label;
import type.Temp;
import type.TypeException;
import evn.Env;

public class StreeEQ extends Stree implements ITreeInterface{
	private Env currentEnv;

	//ne traite pas les boolean
    public StreeEQ(Stree left, Stree right,Env currentEnv) throws TypeException{
		super(EnumTag.EQ, left, right, null);
		this.currentEnv=currentEnv;		
		
		if (isIntegerOrFloat(left) || isBoolean(left)){
			this.left.type = left.getEnumType();
		}else{
			if (currentEnv.find(String.valueOf(left.getObject()))==null){
				throw new TypeException("variable ["+ left.getObject() +"] not declared  ");
			}
			else{
				this.left.type=currentEnv.find(String.valueOf(left.getObject())).getEnumType();
			}
		}
		
		if (isIntegerOrFloat(right) || isBoolean(right)){
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
		Label l1=labels[0];
    	Label l2=labels[1];
    	
		if (t1.toString().compareTo(t2.toString()) == 0) {
			return new CJUMP(CJUMP.EQ,left.toITree(),right.toITree(),l1,l2);
		} else {
			throw new TypeException("type incompatible " + t1 + " et " + t2);
		}
		
    }

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}

}
