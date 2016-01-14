package itree;

public class CALL extends Exp {
	public ITree func;
	public ITree args;

	public CALL(ITree f, ITree a) {
		super();
		func = f;
		args = a;
	}

	public String toString() {
		return "CALL";
	}

	public void toDot(StringBuffer str) {
		str.append("e_" + id + " [");
		str.append("shape=\"ellipse\", label=\"" + toString());
		str.append("\"];\n");
		if (func != null) {
			func.toDot(str);
			str.append("e_" + id + " -> e_" + func.id + ";\n");
		}
		if (args != null) {
			args.toDot(str);
			str.append("e_" + id + " -> e_" + args.id + ";\n");
		}
	}

}
