package Q26;

import java.util.*;

public class Member {
	public List<String> match(List<String> memberNames){
		List<String> l=new ArrayList<String>();
		for(String i:memberNames) {
			l.add(i.toUpperCase());
		}
		return l;
		
	}
	
	public long countA(List<String> memberNames) {
		long count=0;
		for(String i:memberNames) {
			
			if(Character.valueOf(i.charAt(0)).equals('A')) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		List<String> memberNames = new ArrayList<>(Arrays.asList("Amitabh", "Shekhar", "Aman", "Rahul","Shahrukh", "Salman", "Yana", "Lokesh"));
		Member m=new Member();
		System.out.println(m.match(memberNames));
		System.out.println(m.countA(memberNames));

	}

}
