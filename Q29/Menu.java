package Q29;

import java.util.*;

public class Menu {
	
	Program prog;

	public Menu(Program prog) {
		super();
		this.prog = prog;
	}
	
	public String addProgram() {
		if(prog.isValue()==false) {
			prog.setValue(true);
			return "Boolean changed";
		}
		String firstLetter = prog.getName().substring(0, 1);
	    String remainingLetters = prog.getName().substring(1, prog.getName().length());
	    firstLetter = firstLetter.toUpperCase();
		prog.setName(firstLetter+remainingLetters);
		return "Program ready";
	}
	public String runQuery(String query) {
		List<String> l=new ArrayList<>();
		
			String[] s=query.split(",");
			for(int i=0;i<s.length;i++) {
				l.add(s[i]);
			}
		int count=0;
		for(String i:l) {
			if(!prog.getTags().contains(i)) {
				prog.getTags().add(i);
				count++;
			}
		}
		if(count==0) {
			return "No changes";
		}else
		return count+" tags added";
	}

}
