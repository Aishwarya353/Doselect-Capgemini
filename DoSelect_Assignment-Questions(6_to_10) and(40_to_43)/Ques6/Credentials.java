package Ques6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Credentials {
	public String userName;
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String password;
	
	public Credentials(String userName,String password) {
		this.userName=userName;
		this.password=password;
	}
	
	public static void main(String[] args) throws Exception {
		Implementation obj = new Implementation();
		try {
			System.out.println(obj.passwordValidator(new Credentials("Steve", "Akjsdhhj@1")));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
		try {
			System.out.println(obj.signUp(new Credentials("Bob", "jsdhJS12*&$1")));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		/*
		String a=obj.passwordValidator(new Credentials("Steve", "Akjsdhhj@1"));
		String b=obj.signUp(new Credentials("Bob", "jsdhJS12*&$1"));
		System.out.println(a);
		System.out.println(b);
		*/
	}
}

class Implementation {
	public String passwordValidator(Credentials details) throws Exception{
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{0,}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(details.getPassword());
		if(!m.matches())
	    	throw new MissingCharacterException("password must contain at least one special character, at least one upper case alphabet, at least one lower case alphabet, and at least one digit");

		if(details.getPassword().length()<8 || details.getPassword().length()>40)
	    	throw new LengthMismatchException("length of the password is not between 8 to 40");
		return "valid password";
	}
	
	public String signUp(Credentials details) {
		
		try {
			passwordValidator(details);
		}
		catch(MissingCharacterException | LengthMismatchException e) {
			return "invalid password" ;
		}
		catch(Exception e) {
			return "other exception";
		}
		return "signup successfully";
	}

}

@SuppressWarnings("serial")
class MissingCharacterException extends Exception{
	public MissingCharacterException(String str) {
		super(str);
	}
		
}
@SuppressWarnings("serial")
class LengthMismatchException extends Exception{
	public LengthMismatchException(String str) {
		super(str);
	}
	
}