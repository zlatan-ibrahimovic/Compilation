
import java.io.FileReader;
import java_cup.runtime.Symbol;
import stree.*;
import itree.*;
import java.io.*;
import type.*;
import evn.*;
import ICode.*;

public class Main {
	public static int id = 0;
	public static Env firstEnv = null;
	public static Env currentEnv = null;
	public static boolean globaleEnv = false;
	public static boolean envp = true;
	public static Quadruples quadruples=new Quadruples();

	public static void main(String[] args) {
		try {
			FileReader myFile = new FileReader(args[0]);
			CompilerLexer myLex = new CompilerLexer(myFile);
			CompilerParser myParser = new CompilerParser(myLex);
			Symbol result = myParser.debug_parse();
			
			Stree stree = (Stree) result.value;
			stree.toDot("data/AST.dot");
			 
			try {
				try {

					ITree itree = ITree.toITree(stree);
					itree.toDot("data/IR.dot");
					stree.genCodeIR("data/3_adress_code.txt");
				} catch (TypeException ex) {
					PrintWriter pw = new PrintWriter("data/error.txt");
					pw.write(ex.getMessage());
					pw.close();
				}
				firstEnv.toDot("data/Env.dot");
			} catch (Exception e) {
				System.out.println("parse error");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
