package itree;

import type.*;
import ICode.*;

public class SEQ extends ITree {
	public ITree left, right;

	public SEQ(ITree l, ITree r) {
		super();
		left = l;
		right = r;
	}

	public String toString() {
		return new String("SEQ");
	};

	public void toDot(StringBuffer str) {
		str.append("e_" + id + " [");
		str.append("shape=\"ellipse\", label=\"" + toString());
		str.append("\"];\n");
		if (left != null) {
			left.toDot(str);
			str.append("e_" + id + " -> e_" + left.id + ";\n");
		}
		if (right != null) {
			right.toDot(str);
			str.append("e_" + id + " -> e_" + right.id + ";\n");
		}
	}

}
