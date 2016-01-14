package itree;

import ICode.ICodeInterface;
import java.util.*;

public class BINOP extends ITree {
	public int binop;
	public ITree left, right;

	public BINOP(int b, ITree l, ITree r) {
		super();
		binop = b;
		left = l;
		right = r;
	}

	public final static int PLUS = 0, MINUS = 1, MUL = 2, DIV = 3, AND = 4,
			OR = 5, LSHIFT = 6, RSHIFT = 7, ARSHIFT = 8, XOR = 9;

	public String toString() {
		return new String("BINOP");
	};

	/*
	 * public String toString(){ String result = new String(); return result; };
	 */

	public void toDot(StringBuffer str) {
		str.append("e_" + id + " [");
		str.append("shape=\"ellipse\", label=\"" + toString());
		str.append("\"];\n");
		str.append("e_op_" + id + " [");
		str.append("shape=\"ellipse\", label=\"");
		switch (binop) {
		case 0:
			str.append("PLUS");
			break;
		case 1:
			str.append("MINUS");
			break;
		case 2:
			str.append("MUL");
			break;
		case 3:
			str.append("DIV");
			break;
		case 4:
			str.append("AND");
			break;
		case 5:
			str.append("OR");
			break;
		case 6:
			str.append("LSHIFT");
			break;
		case 7:
			str.append("RSHIFT");
			break;
		case 8:
			str.append("ARSHIFT");
			break;
		case 9:
			str.append("XOR");
			break;
		default:
			throw new Error("bad binop in BINOP.toDot");
		}
		str.append("\"];\n");
		str.append("e_" + id + " -> e_op_" + id + ";\n");
		if (left != null) {
			left.toDot(str);
			str.append("e_" + id + " -> e_" + left.id + ";\n");
		}
		if (right != null) {
			right.toDot(str);
			str.append("e_" + id + " -> e_" + right.id + ";\n");
		}
	}

	public String getOperator() {
		switch (binop) {
		case 0:
			return "+";
		case 1:
			return "-";
		case 2:
			return "*";
		case 3:
			return "/";
		default:
			return "null";
		}
	}

}
