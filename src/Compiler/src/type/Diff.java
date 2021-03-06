package type;

public class Diff {
	private Type var;	
	private Type cons;

	public Type getVar(){
		return this.var;
	}

	public Type getCons(){
		return this.cons;
	}

	public Diff(Type var, Type cons) {
		this.var=var;
		this.cons=cons;
	}

	public Diff() {
		this.var=null;
		this.cons=null;
	}

	public String toString() {
		String result = new String();
		if ((var!=null) && (cons!=null))
			result += "<"+var.toString()+","+cons.toString()+">";
		return result;
	}
}
