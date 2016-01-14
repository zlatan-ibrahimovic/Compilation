package type;

import type.*;
import stree.*;

public class Type {
        private Type left;
        private Type right;
        private EnumType type;  
        private Integer integer; // array size
        private String str;
		private static int COUNT=0;
		private int id;

        public Type(Type left, Type right, Integer i, EnumType type) {
                this.left=left;
                this.right=right;
                this.integer=i;
                this.type=type;
				this.id=COUNT++;
        }

        public Type(Type left, Type right, EnumType type) {
                this(left,right,0, type);
        }
       
        public Type(String left, EnumType type) {
                this(null, null,0, type);
                this.str = left;
        }

        public Type(EnumType type) {
                this(null,null,type);
        }

        public Type getLeft() {
                return left;
        }

        public void setLeft(Type left) {
                this.left = left;
        }

        public Type getRight() {
                return right;
        }

        public void setRight(Type right) {
                this.right = right;
        }

        public EnumType getEnumType() {
                return this.type;
        }

        public boolean compareTo(Type t){
        switch (this.type) {
        case CHARACTER:
        case INT:
        case FLOAT:
        case STRING:
        case BOOLEAN:
                if (this.type == t.type)
                return true;
                else return false;
        case ARRAY:
        case POINTER:
                if (this.type == t.type)
                return this.left.compareTo(t.left);
                else return false;
        };
        return false;  
    	}

        public String toString() {
                String result = new String();
                switch (type) {
                case INT:
                case CHARACTER:
                case STRING:
                case FLOAT:
                case BOOLEAN:  
                        result += type.toString();break;
                case ARRAY:result += left.toString() + "["+integer+"]"; break;
                case POINTER:result += "POINTER OF "+left.toString(); break;
                case LIST:
                        result += "ArrayList<" + left.toString()+ ">"; break;
                };
                return result;
        }

		// Algorithme de Robinson
	// Cette fonction provoqe un effet sur ses arguments
	public boolean unify(Type with){
		//System.err.println("############################### UNIFICATION DE "+toString()+", ET DE "+with.toString());
		Diff theta=diff(with);
		if (theta==null)
			return true;
		if (theta.getVar().type!=EnumType.VARIABLE)
			return false;
		//System.err.println("############################### THETA: " + theta.toString());
		int k=0;
		while (theta!=null && k++<10){
			this.substitue(theta);
			with.substitue(theta);
			//System.err.println("############################### RES: "+this.toString()+", "+with.toString());
			boolean test=eq(with);
			theta=diff(with);
			if (theta!=null){
				if (theta.getVar().type!=EnumType.VARIABLE)
					return false;
				//System.err.println("############################### THETA: " + theta.toString());
			}
		}
		return true;
	}

	// Remplace une variable par une constante
	public void substitue(Diff diff){
		switch (type) {
		case INT:
		case FLOAT:
		case STRING:
		case BOOLEAN:
		case ERROR:
			break;
		case POINTER:
			left.substitue(diff);
			break;
		case FUNCTION: 
		case TIMES:
			left.substitue(diff);
			right.substitue(diff);
			break;
		case VARIABLE:
			if ((diff.getVar().id==this.id)){
				this.left=diff.getCons().left;
				this.right=diff.getCons().right;
				this.type=diff.getCons().type;
				if (diff.getCons().type==EnumType.VARIABLE)
					this.id=diff.getCons().id;
			}
			break;
		}
	}

	// Teste si deux types sont quivalents
	public boolean eq(Type with){
		//System.err.println("############################### EQ ENTRE "+toString()+" ET "+with.toString());
		if ((with.type!=type)
				&& (with.type!=EnumType.VARIABLE)
				&& (type!=EnumType.VARIABLE))
			return false;
		if ((with.type!=type)
				&& ((with.type==EnumType.VARIABLE)
						|| (type==EnumType.VARIABLE)))
			return true;

		switch (type) {
		case INT:
		case FLOAT:
		case STRING:
		case BOOLEAN:
		case VARIABLE: 
		case ERROR: 
			break;
		case POINTER:
		case LIST:
			return left.eq(with.left);
		case FUNCTION:
		case TIMES:
			return (left.eq(with.left)
					&& 
					right.eq(with.right));
		}
		return true;
	}

	public Diff diff(Type with){
		//System.err.println("############################### DIFF ENTRE "+toString()+" ET "+with.toString());
		switch (type) {
		case ERROR:
			return null;
		case INT: 
		case FLOAT:
		case STRING:
		case BOOLEAN:
			if (with.type==type){
				return null;
			} else if (with.type!=EnumType.VARIABLE)
				return new Diff(this, with);
			break;
		case POINTER:
		case LIST:
			if (with.type==type)
				return left.diff(with.left);
		case FUNCTION:
		case TIMES:
			if (with.type == type){
				Diff l=left.diff(with.left);
				if (l!=null)
					return l;
				Diff r=right.diff(with.right);
				if (r!=null)
					return r;
			}
			break;
		case VARIABLE: 
			if ((with.type!=EnumType.VARIABLE) ||
					(with.id!=id))
				return new Diff(this, with);
			break;
		default: 
			System.err.printf("*** bug %s\n", type.toString());
		}
		if (with.type==EnumType.VARIABLE)
			if ((type!=EnumType.VARIABLE) ||
					(+id!=with.id))
				return new Diff(with, this);
		return null;
	}
}

