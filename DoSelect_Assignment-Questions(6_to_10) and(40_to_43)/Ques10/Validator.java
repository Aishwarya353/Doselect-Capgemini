/*
 Q10)
Your task here is to implement a Java code based on the following specifications. Note that your code should match the specifications in a precise manner. Consider default visibility of classes, data fields and methods are public unless mentioned otherwise.
Specifications
class definitions:
 class Student:
    Data members:
       name: String
       score: int[]
       status: String    
Define a parameterized constructor for name and score data members.

  class Validator:
      validateScore(Student s) with throws Exception
        return type: String
        visibility: public   
 
      getPercentage(Student s) 
        return double 
        visibility: public  
   
  class InvalidScoreException:
    method definitions:
     InvalidScoreException(String str)
      visibility: public   
Task
Class Student
- define the String variable name
- define the int[] variable score
- define the String variable status
-define a parameterized constructor for the name and score data member.
Class Validator
Implement the below methods for this class:
-String validateScore(Student s):
•	throw an InvalidScoreException "Invalid score" if the score is not valid. Score is valid if 0<=score<=100.
•	return "Valid score" if no exception found.
-double getPercentage(Student s):
•	Percentage = Sum of all the score divided by the total length of score.
•	set the s.status to "pass" if percentage >= 33, else set s.status to "fail".
•	return the percentage of the score if valid, else return 0.0.
Class InvalidScoreException
•	define custom exception class InvalidScoreException by extending the Exception class.
•	define a parameterized constructor with a String argument to pass the message to the super class.
Sample Input
int score[] = {50,40,80,67,69};
Student s = new Student("Aman",score);
Validator val = new Validator();
String ans = val.validateScore(s);
double per =  val.getPercentage(s);
Sample Output
ans = Valid score
per = 61.2
NOTE:
•	You can make suitable function calls and use the RUN CODE button to check your main() method output.
ALLOWED TECHNOLOGIES
•	Java 8

 */

package Ques10;

class InvalidScoreException extends Exception{

	private static final long serialVersionUID = 1L;
	
	InvalidScoreException(String str){
		super(str);
	}
	
	
}

class Student{
	String name;
	int[] score;
	String status;
	
	Student(String name , int[] score)
	{
		this.name = name;
		this.score = score;
	}
}


public class Validator {
	
	public String validateScore(Student s) throws Exception
	{
		for(int i =0; i<s.score.length;i++) {
			if(s.score[i]<0 || s.score[i]>100) {
				throw new InvalidScoreException("Invalid score");
			}
		}
		
		return "Valid Score";
	}
	public double getPercentage(Student s) 
	
	{
		
		
		double percentage = 0.0;
		int len = s.score.length;
		int sum=0;
		for(int j=0;j<s.score.length;j++) {
			if(s.score[j]>=0 && s.score[j]<=100) {
			sum += s.score[j];
			}
			else
			{
				return 0.0;
			}
		}
		percentage = sum/len;
		
		if(percentage>=33)
		{
			s.status="pass";
		}
		else
		{
			s.status = "fail";
		}
		return percentage;
	}
	
	public static void main(String[] args) throws Exception{
		int score[] = {50,40,80,67,69};
		Student s = new Student("Aman",score);
		Validator val = new Validator();
		try
		{
			String ans = val.validateScore(s);
			System.out.println("ans = "+ans);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		finally {
			double per =  val.getPercentage(s);
			System.out.println("per = "+per);
		}
		

		
	}

}
