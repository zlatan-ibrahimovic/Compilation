package stree;

import itree.CONST;
import itree.ITree;
import itree.ITreeInterface;
import type.EnumType;
import type.Label;
import type.Temp;
import type.TypeException;

public class StreeINTEGER extends Stree implements ITreeInterface {

	public StreeINTEGER(Object object) {
		super(EnumTag.INTEGER, null, null, object);
	}

	public StreeINTEGER() {
		super(EnumTag.INTEGER, null, null, null);
	}

	public ITree toITree(Label... labels) throws TypeException {
		return new CONST((Integer) object);
	}

	public EnumType getEnumType() {
		return EnumType.INT;
	}

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}

}
