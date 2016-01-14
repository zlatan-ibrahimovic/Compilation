package ICode;

import java.util.*;
import java.io.*;

public class Quadruples implements Iterable<Entry>{
	private HashMap<String, Integer> labelMap; // Mapping of label names to line numbers
	private int lastLabelNum; // Last number used to generate a label
	private List<Entry> theTable; // Consecutive lines of 3-address code
	private int curIndex; // Current line of code to be generated

	public Quadruples() {
		labelMap = new HashMap<String, Integer>();
		theTable = new ArrayList<Entry>();
		curIndex = 0;
		lastLabelNum = 0;
	}

	public void add(Entry entry) {
		theTable.add(entry);
		curIndex++;
	}

	public void add(Collection<Entry> entries) {
		theTable.addAll(entries);
	}

	/**
	 * getIndex()
	 *
	 * @return the current line number in the codeTable.
	 */
	public int getIndex() {
		return curIndex;
	}

	public Entry get(int lineNo) {
		if(theTable.get(lineNo)==null)
			return null;
		return theTable.get(lineNo);
	}

	public int labelFor(String labelName) {
		if(labelMap.get(labelName)==null)
			return -1;
		return labelMap.get(labelName);
	}

	public Iterator<Entry> iterator() {
		return theTable.iterator();
	}

	public int size() {
		return theTable.size();
	}

	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("=======================================================\n");
		ret.append("3-ADDRESS CODE ========================================\n");
		ret.append("=======================================================\n");
		ret.append("#\tOP\tRESULT\tARG1\tARG2\n");
		for (int i = 0; i < theTable.size(); i++) {
			Entry line = get(i);
			ret.append("" + i + "\t");
			ret.append(line.toString());
			ret.append("\n");
		}
		return ret.toString();
	}

	public String formatCode(){
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < theTable.size(); i++) {
			Entry line = get(i);
			ret.append(line.toString());
		}
		return ret.toString();
	}
	public void saveFile(String name){
		try{
			PrintWriter pw=new PrintWriter(new File(name));
			pw.write(formatCode());
			pw.close();
		}catch(IOException e){}
	}

	public void genCodeIR(String name){
		saveFile(name);
	}
}
