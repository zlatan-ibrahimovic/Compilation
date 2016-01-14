package itree;

import type.*;

public class LABEL extends ITree {
	public Label label;

	public LABEL(Label l) {
		super();
		label = l;
	}

	public String toString() {
		return new String("LABEL");
	};

	public void toDot(StringBuffer str) {
		str.append("e_" + id + " [");
		str.append("shape=\"ellipse\", label=\"" + toString());
		str.append("\"];\n");
		str.append("e_l_" + id + " [");
		str.append("shape=\"ellipse\", label=\"" + label);
		str.append("\"];\n");
		str.append("e_" + id + " -> e_l_" + id + ";\n");
	}

}
