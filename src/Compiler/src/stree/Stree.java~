package stree;

import itree.ITree;
import itree.ITreeInterface;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import type.EnumType;
import type.Label;
import type.TypeException;
import ICode.*;
import itree.*;
import type.*; 
import java.util.*;
 
// Abstract Syntax Tree
// decorated with attributs 
// tag: node label (cf EnumTag)

public abstract class Stree implements ITreeInterface{

    protected EnumTag tag;	// node label
    protected Stree left;
    protected Stree right;
    protected Object object;
	 protected EnumType type;
    protected int id;   // used in toDot
    protected static int uniqId=0;
	 protected static Quadruples quadruples=new Quadruples();
	 protected Temp temp;
	 protected int index;
	// protected Temp temp;

    public Stree(EnumTag tag, Stree left, Stree right, Object object) {
    	this.left=left;
    	this.right=right;
    	this.id=uniqId++;
    	this.tag=tag;
    	this.object=object;
   }
    
    public EnumTag getTag() {
        return tag;
    }    
    
    public int getId() {
        return id;
    }    
    
    public Stree getLeft() {
	return left;
    }
    
public int getIndex(){
	return index;
}
    public Stree getRight() {
	return right;
    }
    
    public Object getObject() {
	return object;
    }
	public abstract Temp getTemp();

	public int getPlace(){
		return quadruples.labelFor((String)object); 
	}

    public ITree toITree(Label...labels) throws TypeException{
    	return null;
    }
    
	public EnumType getEnumType(){
		return type;
	}

	public void genCodeIR(String name){
		quadruples.saveFile(name);
	}

	public List<Object> getArgs(){
		return null;
	}
    public String toString() {
	String result = new String();
	result += tag.toString();
	if ((left != null) || (right != null)){
	    result +="(";
	    if (left != null)
	    	result += left.toString();
	    if (right != null){
                result+=",";
                if (right.tag==EnumTag.SUCC || right.tag==EnumTag.THENELSE)
                    result+="\n\n\t";
	    	result += right.toString();
            }
	    result+=")";
	}
	return result;
    }
    
    public void toDot(StringBuffer str) {
	str.append("a_"+id+" [");
	str.append("shape=\"ellipse\", label=\""+tag.toString()); 
	if (object!=null)
	  str.append("\\nobject: "+object.toString());
		if(type!=null)
			str.append("\\ntype: "+type.toString()); 
	str.append("\", color=\"green\"];\n");
	if (left != null){
	   
 left.toDot(str); 
		
	    str.append("a_"+id+" -> a_"+left.id+";\n");
	}
	if (right != null){
	    right.toDot(str);
	    str.append("a_"+id+" -> a_"+right.id+";\n");
	}
    }
    
    public void toDot(String file) {
	try {
	    BufferedWriter out = new BufferedWriter(new FileWriter(file));
	    out.write("digraph Stree {\n");
	    StringBuffer str = new StringBuffer();
	    toDot(str);
	    out.write(str.toString());
	    out.write("}\n");
	    out.close();
	} catch (IOException e) {
	    System.err.println("ERROR: build dot");
	}		
    }

	public boolean isIntegerOrFloat(Stree stree){
		if (stree.getClass() == StreeINTEGER.class || stree.getClass() == StreeFLOAT.class){
			return true;
		}
		return false;
	}
	
	public boolean isBoolean(Stree stree){
		if (stree.getClass() == StreeBOOLEAN.class){
			return true;
		}
		return false;
	}
}
