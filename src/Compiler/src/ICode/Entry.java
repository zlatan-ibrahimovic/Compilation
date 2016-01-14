
package ICode;

public class Entry{
	private Object op;
	private Object arg1;
	private Object arg2;
	private Object place;

	public Entry(Object op,Object arg1,Object arg2,Object place){
		this.op=op;
		this.arg1=arg1;
		this.arg2=arg2;
		this.place=place;
	}
	public String toString(){
		if(place==null){
			if(arg2==null)
				return ""+arg1+"\n";
			return arg1+""+op+""+arg2+"\n";
		}
		else
			return place+"="+arg1+""+op+""+arg2+"\n";
		//return String.format("%s\t%s\t%s\t%s", op, place, arg1, arg2 );
	}
}
