package stree;

import itree.ExpList;
import itree.ITree;
import itree.ITreeInterface;
import type.Temp;
import type.TypeException;

public class StreeExps extends Stree implements ITreeInterface{

    public StreeExps(Stree left, Stree right){
		super(EnumTag.EXP, left, right, null);
    }


	public ITree toITree() throws TypeException{
		return new ExpList(left.toITree(),right.toITree());
	}


	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}

}