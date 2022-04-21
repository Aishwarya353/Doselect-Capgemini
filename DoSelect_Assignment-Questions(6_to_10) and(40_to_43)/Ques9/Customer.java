/*
 Question 9
 Q9
Your task here is to implement a Java code based on the following specifications. Note that your code should match the specifications in a precise manner. Consider default visibility of classes, data fields and methods are public unless mentioned otherwise.
Specifications
class definitions:
 class Customer:
  Data members:
       name: String
       mobileNo: String
       cId: String 
   Define a parameterized constructor for all the data members.

  class Validator:
      validateCId(Customer c) throws Exception
        return type: String
        visibility: public   
 
      validateMobileNo(Customer c) throws Exception
        return type: String 
        visibility: public  
   
  class InvalidCIdException:
   method definitions:
    InvalidCIdException(String str)
      visibility: public   

  class InvalidMobileNoException:
   method definitions:
    InvalidMobileNoException(String str)
      visibility: public     
Task
Class Customer
- define the String variable name
- define the String variable mobileNo
- define the String variable cId
-define a parameterized constructor for all the data members.
Class Validator
Implement the below methods for this class:
-String validateCId(Customer c):
•	throw an InvalidCIdException "Invalid CId" if CId is not valid. cId is valid if it starts with first 4 character of mobileNo and end with last 2 character of name.
Example:
name = "Steve", mobileNo = "9898111111" then valid cId = "9898ve".
•	return "Valid CId" if no exception found.
-String validateMobileNo(Customer c):
•	throw an InvalidMobileNoException "Invalid MobileNo" if mobileNo is not valid. mobileNo is valid if it has 10 digits and starts with [9,8,7,6] only.
•	return "Valid MobileNo" if no exception found.
Class InvalidCIdException
•	define a custom exception class InvalidCIdException by extending the Exception class.
•	define a parameterized constructor with a String argument to pass the message to the super class.
Class InvalidMobileNoException
•	define a custom exception class InvalidMobileNoException by extending the Exception class.
•	define a parameterized constructor with a String argument to pass the message to the super class.
Sample Input
Customer obj = new Customer("Steve","9898111111","9898ve");
Validator val = new Validator();
String CID = val.validCId(obj);
String mob = val.validMobileNo(obj);
Sample Output
CID = "Valid CId"
mob = "Valid MobileNo"
NOTE:
•	You can make suitable function calls and use the RUN CODE button to check your main() method output.
ALLOWED TECHNOLOGIES
•	Java 8

 */


package Ques9;

class InvalidCidException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	InvalidCidException(String str){
		super(str);
	}
	
}

class InvalidMobileNoException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	InvalidMobileNoException(String str){
		super(str);
	}
}

class Validator{
	public String validateCID(Customer c) throws Exception
	{
		String mobileNoTemp = c.cId.substring(0, 4);
		//System.out.println(mobileNoTemp);
		
		String nameTemp = c.name.substring(c.name.length()-2);
		//System.out.println(c.name.charAt(0));
		
		if(!c.cId.equals(mobileNoTemp+nameTemp)) {
			throw new InvalidCidException("Invalid CId");
		}
		
		return "Valid CId";
	}
	
	public String validateMobileNo(Customer c) throws Exception
	{
		
		if(!(c.mobileNo.length()==10 &&
				(c.mobileNo.charAt(0)=='9' ||
				c.mobileNo.charAt(0)=='8' ||
				c.mobileNo.charAt(0)=='7' ||
				c.mobileNo.charAt(0)=='6') ))
		{
			throw new InvalidMobileNoException("Invalid MobileNo");
		}
		return "Valid MobileNo";
		
	
	}
}

public class Customer {
	String name;
	String mobileNo;
	String cId;
	public Customer(String name, String mobileNo, String cId)
	{
		this.name = name;
		this.mobileNo = mobileNo;
		this.cId = cId;
	}
	
	public static void main(String[] args)
	{
		Customer obj = new Customer("Steve","9898111111","9898ve");
		Validator val = new Validator();
		try
		{
			String CID = val.validateCID(obj);
			String mob = val.validateMobileNo(obj);
			System.out.println("CID = "+CID);
			System.out.println("mob = "+mob);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		

	}

}
