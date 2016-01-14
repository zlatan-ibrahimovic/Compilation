package evn;

import java.io.*;
import type.*;


// binary search tree implementing a scope

public class ScopeTree {

	private int id;
	private ScopeTree left;
	private ScopeTree right;
	private String symbol;	
	private Type type;
	private boolean flag;

	// Les contructeurs...
	public ScopeTree(ScopeTree left, ScopeTree right, String s, Type t) {
		this.left=left;
		this.right=right;
		this.id=Env.nb++;
		this.symbol=s;
		this.type=t;
		this.flag=false;
	}

	public ScopeTree(String s, Type t) {
		this.left=null;
		this.right=null;
		this.id=Env.nb++;
		this.symbol=s;
		this.type=t;
		this.flag=false;
	}

	// Les accesseurs
	public ScopeTree getLeft() {
		return left;
	}

	public void setLeft(ScopeTree left) {
		this.left = left;
	}

	public ScopeTree getRight() {
		return right;
	}

	public int getId() {
		return id;
	}

	public Type getType() {
		return type;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setRight(ScopeTree right) {
		this.right = right;
	}

	// Pour retrouver le type d'un symbole
	public Type find(String s) {
		if ((s.compareTo(symbol) < 0) && left!=null)
			return left.find(s);
		else if ((s.compareTo(symbol) > 0) && right!=null)
			return right.find(s);
		else if (s.compareTo(symbol) == 0)
			return type; 
		else
			return null;
	}

	// pour ajouter un couple <symbole, type>
	public ScopeTree add(String s, Type t, ScopeTree a) {
		if (a==null)
			return new ScopeTree(s, t);
		else if (s.compareTo(a.symbol) < 0)
			return new ScopeTree(add(s, t, a.left), a.right, a.symbol, a.type);
		else if (s.compareTo(a.symbol) > 0)
			return new ScopeTree(a.left, add(s, t, a.right), a.symbol, a.type);
		else
			return new ScopeTree(a.left, a.right, s, t);
	}

	// produit une chaîne pour lecture
	public String toString() {
		String result = new String();
		result += symbol;
		if ((left != null) || (right != null)){
			result +="(";
			if (left != null)
				result += left.toString();
			result+=",";
			if (right != null)
				result += right.toString();
			result+=")";
		}
		return result;
	}

	// 
	protected void toDot(StringBuffer str) {
		if (!flag){
			flag=true;
			str.append(this.id+" [label=\""+symbol+": "+type.toString()+"\"];"+"\n");

			if (left != null){
				left.toDot(str);
				str.append(this.id+" -> "+left.id+" [label=\"\"];\n");
			}
			if (right != null){
				right.toDot(str);
				str.append(this.id+" -> "+right.id+" [label=\"\"];\n");
			}
		}
	}

	// produit un fichier dot (graphviz)
	public void toDot(String file) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("./"+file+".dot"));
			out.write("digraph ArbreBinaire {");
			StringBuffer str = new StringBuffer();
			toDot(str);
			out.write(str.toString());
			out.write("}");
			out.close();
		} catch (IOException e) {
			System.out.println("ERROR: build dot");
		}		
	}
}
