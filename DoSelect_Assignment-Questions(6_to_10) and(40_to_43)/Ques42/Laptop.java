/*
 Question 42)
 Complete the classes using the Specifications given below. Consider default visibility of classes, data fields, and methods unless mentioned otherwise.
Specifications
class definitions:
 class Laptop:
    data members: 
        int price
        String details
    Rating(String details, int price): constructor with public visibility

class Afford:
 method definitions:
     checkConfiguration(Laptop laptop) throws Exception:     
        return type: String
        visibility: public     

     purchaseLaptop(Laptop laptop) throws Exception:
        return type: String
        visibility: public   

 class LaptopException:
   method definitions:
      LaptopException(String msg)
         visibility: public  
Task
Class Laptop
- define the int variable price.
- define the String variable details
The string variable contains the RAM, HardDisk storage, and Type of hard-disk ie SSD or HDD separated by a '/'. For example, "8/512/HDD".
-define a constructor according to the above specifications.
Class Afford
Implement the below methods for this class:
-String checkConfiguration(Laptop laptop) throws Exception:
•	Write a code to validate the criteria for purchasing the laptop.
•	throw a LaptopException if the price is greater than 70000 with the message "Price too high".
•	throw a LaptopException if RAM is less than 8 with the message "Minimum 8 RAM required".
•	throw a LaptopException if HardDisk storage is less than 256 with the message "Minimum 256 space required".
•	throw a LaptopException if HardDisk type is HDD with the message "SSD required".
•	If no above exception is found then return a string message "Can be purchased".
-String purchaseLaptop(Laptop laptop):
•	Write a code to send an invite to the nominee.
•	If checkConfiguration method throws a LaptopException then return a message "Change configuration".(Use try-catch block)
•	If it throws any other exception then return a message "other exception".
•	If no exception is found then return a message "Perfect configuration".
Sample Input
Laptop laptop=new Laptop("8/512/SSD", 58000);
Afford af=new Afford(); 
String s=af.checkConfiguration(laptop);
String t=af.purchaseLaptop(laptop);
s.toLowerCase();
t.toLowerCase();
Sample Output
can be purchased
perfect configuration
NOTE:
•	You can make suitable function calls and use the RUN CODE button to check your main() method output.
ALLOWED TECHNOLOGIES
•	Java 8

 */

package Ques42;

class Afford{
	
	
	
	public String checkConfiguration(Laptop laptop) throws Exception
	{
		if(laptop.price >70000)
		{
			throw new LaptopException("Price too high");
		}
		String[] detArr = laptop.details.split("/");
		int ram = Integer.parseInt(detArr[0]); 
		int storage = Integer.parseInt(detArr[1]);
		if(ram < 8) {
			throw new LaptopException("Minimum 8 RAM required");
		}
		if(storage < 256) {
			throw new LaptopException("Minimum 256 space required");
		}
		if(detArr[2].equals("HDD")) {
			throw new LaptopException("SSD required");
		}
		
		return "Can be purchased";
	
	}	
	
	public String purchaseLaptop(Laptop laptop) throws Exception{
		
		try {
			
		//String check = checkConfiguration(laptop);
		
		String check = checkConfiguration(laptop);
		if(check.equals("Can be purchased"));
		{
			
			return "Perfect Configuration";
		}
		}
		catch(LaptopException e)
		{
			return "Change Configuration";
		}
		
	catch(Exception e)
	{
		return "Other Exception";
	}
		
	
	}
	
}

class LaptopException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	LaptopException(String msg)
	{
		super(msg);
	}
}

public class Laptop {
	
	int price;
	String details;
	
	public Laptop(String details, int price) {
		this.details = details;
		this.price = price;
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Laptop laptop=new Laptop("8/256/SSD", 58000);
		Afford af=new Afford(); 
		try {
		String s=af.checkConfiguration(laptop);
		String t=af.purchaseLaptop(laptop);
		System.out.println(t.toLowerCase());
		System.out.println(s.toLowerCase());
		//System.out.println(t.toLowerCase());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}


	}

}
