package itree;

import type.Label;
import ICode.*;

public class CJUMP extends ITree {
	public int relop;
	public ITree left, right;
	public Label iftrue, iffalse;

	public CJUMP(int rel, ITree l, ITree r, Label t, Label f) {
		super();
		relop = rel;
		left = l;
		right = r;
		iftrue = t;
		iffalse = f;
	}

	public final static int EQ = 0, NE = 1, LT = 2, GT = 3, LE = 4, GE = 5,
			ULT = 6, ULE = 7, UGT = 8, UGE = 9, OR = 10, AND = 11, DIFF = 12;

	public static int notRel(int relop) {
		switch (relop) {
		case EQ:
			return NE;
		case NE:
			return EQ;
		case LT:
			return GE;
		case GE:
			return LT;
		case GT:
			return LE;
		case LE:
			return GT;
		case ULT:
			return UGE;
		case UGE:
			return ULT;
		case UGT:
			return ULE;
		case ULE:
			return UGT;
		default:
			throw new Error("bad relop in CJUMP.notRel");
		}
	}

	public String toString() {
		return new String("CJUMP");
	};

	public void toDot(StringBuffer str) {
		str.append("e_" + id + " [");
		str.append("shape=\"ellipse\", label=\"" + toString());
		str.append("\"];\n");
		str.append("e_op_" + id + " [");
		str.append("shape=\"ellipse\", label=\"");
		switch (relop) {
		case EQ:
			str.append("EQ");
			break;
		case NE:
			str.append("NE");
			break;
		case LT:
			str.append("LT");
			break;
		case GE:
			str.append("GE");
			break;
		case GT:
			str.append("GT");
			break;
		case LE:
			str.append("LE");
			break;
		case ULT:
			str.append("ULT");
			break;
		case UGE:
			str.append("UGE");
			break;
		case UGT:
			str.append("UGT");
			break;
		case ULE:
			str.append("ULE");
			break;
		case AND:
			str.append("AND");
			break;
		case OR:
			str.append("OR");
			break;
		case DIFF:
			str.append("DIFF");
			break;
		default:
			throw new Error("bad relop in CJUMP.notRel");
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
		str.append("e_it_" + id + " [");
		str.append("shape=\"ellipse\", label=\"" + iftrue);
		str.append("\"];\n");
		str.append("e_" + id + " -> e_it_" + id + ";\n");
		str.append("e_if_" + id + " [");
		str.append("shape=\"ellipse\", label=\"" + iffalse);
		str.append("\"];\n");
		str.append("e_" + id + " -> e_if_" + id + ";\n");
	}

	public String getOperator() {
		switch (relop) {
		case DIFF:
			return "!=";
		case EQ:
			return "==";
		default:
			return "null";
		}
	}

}
