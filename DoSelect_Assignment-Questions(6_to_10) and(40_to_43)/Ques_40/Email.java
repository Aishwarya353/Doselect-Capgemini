package Ques_40;

/*
Q40
Complete the classes using the Specifications given below. Consider default visibility of classes, data fields, and methods unless mentioned otherwise.
Specifications
class definitions:
 class Email:
    data members: 
        String username
        String domain
    Email(String username, String domain): constructor with public visibility

class Validator:
 method definitions:
     checkEmail(Email email) throws Exception:     
        return type: String
        visibility: public     

     signIn(Email email) throws Exception:
        return type: String
        visibility: public   

 class EmailException:
   method definitions:
      EmailException(String msg)
         visibility: public  
Task
Class Email
- define the String variable username.
- define the String variable domain
-define a constructor according to the above specifications.

Class Validator
Implement the below methods for this class:
-String checkEmail(Email email) throws Exception:
•	Write a code to validate the criteria for getting the award.
•	throw an EmailException if the username contains any special symbol with the message "Invalid username".
•	throw an EmailException if the domain is other than "outlook", "gmail", "hotmail", or "godaddy" with a message "Invalid domain".
•	If no above exception is found then return a string message "Continue".

-String signIn(Email email) throws Exception:
•	Write a code to send an invite to the nominee.
•	If checkEmail() method throws an EmailExceptionthen returns a message "Failed".(Use try-catch block)
•	If it throws any other exception then return a message "Other exception".
•	If no exception is found then return a message "Signed in".
class EmailException extends Exception
•	Define EmailException class derived from Exception class

Sample Input
Email e=new Email("Shoyab@","gmail");
Validator v = new Validator();
String s = v.checkEmail(e);
String t = v.signIn(e);
s.toLowerCase();
 t.toLowerCase();

Sample Output
continue
signed in

*/

class EmailException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailException(String str)
    {
        super(str);
    }
}

public class Email {
    String username;
    String domain;

    public Email(String username, String domain)
    {
        this.username=username;
        this.domain=domain;
    }

    public static void main(String[] args) throws Exception {
        Email e=new Email("Shoyab","gmail");
        Validator2 v = new Validator2();
        try{
        String s = v.checkEmail(e);
        String t = v.signIn(e);
        System.out.println(s.toLowerCase());
        System.out.println(t.toLowerCase());
        }
        catch(Exception en)
        {
            System.out.println(en.getMessage());
        }

    }
}

class Validator2{
    Validator2(){
    }

    public String checkEmail(Email e) throws EmailException
    {
        String domain1=e.domain;
        
        for(int i=0;i<e.username.length();i++)
        {
        if(e.username.charAt((i))=='!' || e.username.charAt((i))=='#' || e.username.charAt((i))=='$' || e.username.charAt((i))=='%'
        || e.username.charAt((i))=='*'||e.username.charAt((i))=='@')
        {
            throw new EmailException("Invalid username");
        }
        }
        if(!(domain1.equals("outlook")) && !(domain1.equals("hotmail")) && !(domain1.equals("gmail"))
        && !(domain1.equals("godaddy"))){
            
			throw new EmailException("Invalid domain");
        }
        return "Continue";
    }

    public String signIn(Email e) throws Exception
    {
        try{
            String s=checkEmail(e);
            if(s.equals("Continue"))
            {
                return "Signed in";
            }
        }
        catch(EmailException en)
        {
            return "Failed";
        }

        catch(Exception en)
        {
            return "Other exception";
        }
        return null;
    }
}


