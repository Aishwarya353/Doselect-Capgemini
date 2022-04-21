package Q29;

import java.util.*;

public class Program {
	
	String name;
	boolean value;
	ArrayList<String> tags;

	public Program(String name, boolean value, ArrayList<String> tags) {
		super();
		this.name = name;
		this.value = value;
		this.tags = tags;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public String getName() {
		return name;
	}

	public boolean isValue() {
		return value;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public static void main(String[] args) {
		Program p = new Program("reconcile program", true, new ArrayList<String>(Arrays.asList("C","D")));
		Menu m = new Menu(p);
		System.out.println(m.addProgram());
		System.out.println(m.runQuery("C,B"));
		System.out.println(p.getName());
		System.out.println(p.getTags());

	}

}
