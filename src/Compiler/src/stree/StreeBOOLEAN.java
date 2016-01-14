package stree;

import itree.CONST;
import itree.ITree;
import itree.ITreeInterface;
import type.EnumType;
import type.Label;
import type.Temp;
import type.TypeException;

public class StreeBOOLEAN extends Stree implements ITreeInterface {

	public StreeBOOLEAN(Object object) {
		super(EnumTag.BOOLEAN, null, null, object);
	}

	public StreeBOOLEAN() {
		super(EnumTag.BOOLEAN, null, null, null);
	}

	public ITree toITree(Label... labels) throws TypeException {
		return new CONST(object);
	}

	public EnumType getEnumType() {
		return EnumType.BOOLEAN;
	}

	@Override
	public Temp getTemp() {
		// TODO Auto-generated method stub
		return null;
	}
}
