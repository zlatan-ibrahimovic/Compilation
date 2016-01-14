package itree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;

import stree.*;
import type.*;
import ICode.*;
import java.util.*;

public abstract class ITree {
	protected int id; // used in toDot
	protected static int uniqId = 0;
	protected static Quadruples quadruples = new Quadruples();

	public ITree() {
		id = uniqId++;
	}

	public String toString() {
		return new String("ITree");
	};

	public void toDot(StringBuffer str) {
		str.append("e_" + id + " [");
		str.append("shape=\"ellipse\", label=\"" + toString());
		str.append("\"];\n");
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

	public static ITree toITree(Stree stree) throws TypeException {
		return stree.toITree();
	}
}
