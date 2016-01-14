package stree;

import itree.CONST;
import itree.ITree;
import itree.ITreeInterface;
import type.EnumType;
import type.Label;
import type.Temp;
import type.TypeException;

public class StreeFLOAT extends Stree implements ITreeInterface {

	public StreeFLOAT(Object object) {
		super(EnumTag.FLOAT, null, null, object);
	}

	public StreeFLOAT() {
		super(EnumTag.FLOAT, null, null, null);
	}

	public ITree toITree(Label... labels) throws TypeException {
		return new CONST((Float) object);
	}

	public EnumType getEnumType() {
		return EnumType.FLOAT;
	}

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
}
