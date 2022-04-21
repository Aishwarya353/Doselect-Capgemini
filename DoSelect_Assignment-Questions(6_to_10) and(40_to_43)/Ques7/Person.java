
/*
Q7)

Your task here is to implement a Java code based on the following specifications. Note that your code should match the specifications in a precise manner. Consider default visibility of classes, data fields, and methods unless mentioned.
Specifications
class definitions:
class Person:
 data members:
        name: String
        dateOfBirth: String
        email: String
 Person(String name, String dateOfBirth, String email): constructor with public visibility

class Implementation:
  method definitions:
     validator(Person details) throws Exception
         return type: String
         visibility: public   
     submitDetails(Person details)
          return type: String
          visibility: public
  
class InvalidDateException:
       method definitions:
         InvalidDateException(String str)
         visibility: public
   
class InvalidEmailException:
       method definitions:
         InvalidEmailException(String str)
         visibility: public           
Task
Class Person
- define the String variable name.
- define the String variable dateOfBirth.
- define the String variable email.
-Define a parameterized constructor as specified above.
Class Implementation
Implement the below methods for this class:
-String validator(Person details):
•	Write a code to validate the details of the Person.
•	Date of birth(dd-mm-yyyy) is present in the given format,  throw an InvalidDateException with the message "date year must be less than 2000" if the date and year are not less than 2000
•	throw an InvalidEmailException with the message "only @doselect.com domain email are accepted", if the email is not of '@doselect.com' domain  
•	return String "valid details", if none of the above exceptions is found  
-String submitDetails(Person details):
•	Write a code to submit the details.
•	Use try-catch to validate the Person details using the validator(Person details) method. If the details are valid then return "details submitted successfully".
•	If InvalidDateException or InvalidEmailException is found then return "invalid details" in the catch block.
•	If any other exception is found then return "other exception" in the catch block.
Class InvalidDateException
•	define custom exception class InvalidDateException by extending the Exception class.
•	define a parameterized constructor with a String argument to pass the message to the super class.
Class InvalidEmailException
•	define custom exception class InvalidEmailException by extending the Exception class.
•	define a parameterized constructor with a String argument to pass the message to the super class.
Sample Input
Person data = new Person("Steve", "12-02-1998", "Steve12@doselect.com");
Implementation obj = new Implementation();
-----------------------------------------------
obj.validator(data);
obj.submitDetails(data);
Sample Output
valid details
details submit successfully
NOTE:
•	You can make suitable function calls and use RUN CODE button to check your main() method output.
ALLOWED TECHNOLOGIES
•	Java 8

*/


package Ques7;

class InvalidDateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDateException(String str) {
		super(str);
	}
}
class InvalidEmailException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidEmailException(String str) {
		super(str);
	}

}



class Implementation {
public String validator(Person p) throws Exception{
		
	
		String[] dob=p.getDateOfBirth().split("-");
		if(Integer.valueOf(dob[2])>2000)
			throw new InvalidDateException("date year must be less than 2000");
		
			
		String domain=p.getEmail().substring(p.getEmail().length()-13,p.getEmail().length());
		if(!domain.equals("@doselect.com"))
			throw new InvalidEmailException("only @doselect.com domain email are accepted");

		return "valid details"; 
	}
	
	public String submitDetails(Person p) {
		try {
			String s=validator(p);
			if(s.equals("valid details")) {
				return "details submitted successfully";
			}
		}
		catch (InvalidDateException e) {
			return "invalid details";
		}
		catch (InvalidEmailException e) {
			return "invalid details";
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return "invalid details";
	}

}

public class Person {
	public String name;
	public String dateOfBirth;
	public String email;
	
	public Person(String name,String dateOfBirth,String email) {
		this.name=name;
		this.dateOfBirth=dateOfBirth;
		this.email=email;
	}
		public String getName() {
			return name;
		}
		public String getDateOfBirth() {
			return dateOfBirth;
		}
		public String getEmail() {
			return email;
		}
	
	public static void main(String[] args) throws Exception {
		Person data = new Person("Steve", "12-22-2000", "Steve12@doselect.com");
		Implementation obj = new Implementation();
		
		try {
		System.out.println(obj.validator(data));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
		System.out.println(obj.submitDetails(data));
		}
	}

}



