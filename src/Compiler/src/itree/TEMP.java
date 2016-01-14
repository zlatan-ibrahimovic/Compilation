package itree;

import type.Temp;
import ICode.ICodeInterface;
import java.util.*;

public class TEMP extends ITree {
	public Temp temp;

	public TEMP(Temp t) {
		super();
		temp = t;
	}

	public String toString() {
		return new String("TEMP");
	};

	public void toDot(StringBuffer str) {
		str.append("e_" + id + " [");
		str.append("shape=\"ellipse\", label=\"" + toString());
		str.append("\"];\n");
		str.append("e_t_" + id + " [");
		str.append("shape=\"ellipse\", label=\"" + temp);
		str.append("\"];\n");
		str.append("e_" + id + " -> e_t_" + id + ";\n");
	}

}
