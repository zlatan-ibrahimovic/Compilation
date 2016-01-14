package itree;
import type.*; 

import ICode.ICodeInterface;

public class JUMP extends ITree implements ICodeInterface{
    public Exp exp;
    public LabelList targets;
    public JUMP(Exp e, LabelList t) {super(); exp=e; targets=t;}
    public JUMP(Label target) {
		this(new NAME(target), new LabelList(target,null));
    }
    
    public String toString(){return new String("JUMP");};

    public void toDot(StringBuffer str) {
	str.append("e_"+id+" [");
	str.append("shape=\"ellipse\", label=\""+toString()); 
	str.append("\"];\n");
	if (exp != null){
	    exp.toDot(str);
	    str.append("e_"+id+" -> e_"+exp.id+";\n");
	}
	/*
	if (targets != null){
	    targets.toDot(str);
	    str.append("s_"+id+" -> e_"+targets.id+";\n");
	}
	*/
    }

	public void genCode(StringBuffer str){
		//str.append("GOTO "+targets.head+"\n");
	}
}

