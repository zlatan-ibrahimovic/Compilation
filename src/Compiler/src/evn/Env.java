package evn;

import java.io.*;
import type.*;

/* stack of scopes implementing the environnement */

public class Env {
	protected static int nb=0;      
   protected static int scopenb=0;

	private Env prev;
	private Env next;
	private ScopeTree root=null;
	private int id;
	private int scopenum;

	public Env(Env prev, Env next, ScopeTree root) {
		this.prev=prev;
		this.next=next;
		this.root=root;
		this.id=nb++;
	}

	public Env(Env prev, Env next) {
		this.prev=prev;
		this.next=next;
		this.root=null;
		this.id=nb++;
	}

	public Env(Env prev) {
		this.prev=prev;
		this.next=null;
		this.root=null;
		this.id=nb++;
	}

	public Env() {
		this.prev=null;
		this.next=null;
		this.root=null;
		this.id=nb++;
	}

	public int getId() {
		return id;
	}

	public Env getPrev() {
		return prev;
	}

	public void putPrev(Env prev) {
		this.prev = prev;
	}

	public Env getNext() {
		return next;
	}

	public void putNext(Env next) {
		this.next = next;
	}

	public ScopeTree getRoot() {
		return root;
	}

	// produit un fichier dot (graphviz)
	public void toDot(String file) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("./"+file));
			StringBuffer str = new StringBuffer();
			str.append("digraph Env {");
			for (Env e=this; e!=null; e=e.next){
				str.append(e.id+" [shape=\"box\", label=\"s"+e.id+"\"];"+"\n");
			}
			for (Env e=this; e!=null; e=e.next){
				if (e.root!=null){
					e.root.toDot(str);
					str.append(e.id+" -> "+e.root.getId()+";\n");
				}
			}
			str.append("}");
			out.write(str.toString());
			out.close();
		} catch (IOException e) {
			System.out.println("ERROR: build dot");
		}		
	}

	// Ajoute un symbole dans l'environnement
	public void add(String s, Type t) {
		//System.err.printf("********************************* %s \n", s, t);  
		if (root==null){
			if (prev!=null && prev.root!=null){
				root=new ScopeTree(prev.root.getLeft(), prev.root.getRight(), prev.root.getSymbol(), prev.root.getType()); 
				root=root.add(s, t, root);
			} else {
				root=new ScopeTree(s, t);
				root=root.add(s, t, root);
			}
		} else {		
			root=root.add(s, t, root);
		}
	}

	// retrouve un symbole dans l'environnement
	public Type find(String s){
		if (root!=null)
			return root.find(s);
		else
			return null;

	}
}
