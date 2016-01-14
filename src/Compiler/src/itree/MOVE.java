package itree;

import ICode.*;

public class MOVE extends ITree {
	public ITree dst, src;

	public MOVE(ITree d, ITree s) {
		super();
		dst = d;
		src = s;
	}

	public String toString() {
		return new String("MOVE");
	};

	public void toDot(StringBuffer str) {
		str.append("e_" + id + " [");
		str.append("shape=\"ellipse\", label=\"" + toString());
		str.append("\"];\n");
		if (dst != null) {
			dst.toDot(str);
			str.append("e_" + id + " -> e_" + dst.id + ";\n");
		}
		if (src != null) {
			src.toDot(str);
			str.append("e_" + id + " -> e_" + src.id + ";\n");
		}
	}

}
