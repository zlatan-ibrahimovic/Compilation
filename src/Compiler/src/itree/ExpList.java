package itree;

import ICode.ICodeInterface;

public class ExpList extends ITree {
	public ITree head;
	public ITree tail;

	public ExpList(ITree h, ITree t) {
		super();
		head = h;
		tail = t;
	}

	public String toString() {
		return new String("EXPLIST");
	};

	public void toDot(StringBuffer str) {
		str.append("e_" + id + " [");
		str.append("shape=\"ellipse\", label=\"" + toString());
		str.append("\"];\n");
		if (head != null) {
			head.toDot(str);
			str.append("e_" + id + " -> e_" + head.id + ";\n");
		}
		if (tail != null) {
			tail.toDot(str);
			str.append("e_" + id + " -> e_" + tail.id + ";\n");
		}
	}

}
