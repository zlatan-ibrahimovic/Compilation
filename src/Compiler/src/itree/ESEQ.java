package itree;

import type.*;

@SuppressWarnings("unused")
public class ESEQ extends Exp {
	public Stm stm;
	public Exp exp;
	public ITree mov;
	public ITree func;
	public ITree temp;


	public ESEQ(Stm s, Exp e) {
		super();
		stm = s;
		exp = e;
		mov=null;
		func=null;
		temp=null;
		
	}

	public ESEQ(ITree stm2, ITree iTree, ITree t) {
		super();
		stm=null;
		exp=null;
		mov=stm2;
		func=iTree;
		temp=t;
	}

	public String toString() {
		return "ESEQ";
	}

	public void toDot(StringBuffer str) {
		str.append("e_" + id + " [");
		str.append("shape=\"ellipse\", label=\"" + toString());
		str.append("\"];\n");
		if (func != null) {
			func.toDot(str);
			str.append("e_" + id + " -> e_" + func.id + ";\n");
		}
		if (mov != null){
			mov.toDot(str);
			str.append("e_" + id + " -> e_" + mov.id + ";\n");
		}
		if(temp != null){
			temp.toDot(str);
			str.append("e_" + id + " -> e_" + temp.id + ";\n");
		}
		
		if(exp!=null){
			exp.toDot(str);
			str.append("e_" + id + " -> e_" + exp.id + ";\n");
		}
		if (stm != null) {
			stm.toDot(str);
			str.append("e_" + id + " -> e_" + stm.id + ";\n");
		}
	}


}
