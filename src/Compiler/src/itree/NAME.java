package itree;

import type.*;

public class NAME extends Exp {
	public Label label;

	public NAME(Label l) {
		super();
		label = l;
	}

	public String toString() {
		return label.toString();
	};

}
