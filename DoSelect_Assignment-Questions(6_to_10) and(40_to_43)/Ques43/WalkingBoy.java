/*
 Q43

Complete the classes using the Specifications given below. Consider default visibility of classes, data fields, and methods unless mentioned otherwise.
Specifications
class definitions:
 class WalkingBoy:
  int stepSize
  int blockSize
   visibility : public

  WalkingBoy(int stepSize, int blockSize) : Constructor with public visibility

  method definition:
   targetHit(String platform) throws Exception:
    return type: String
    visibility: public

 class BombBlast extends Exception:
   method definition:
     BombBlast(String msg)
      visibility: public  
Task
Class WalkingBoy
-define all the data members as per the given specifications.
-define the constructor with public visibility.
-Implement the below methods for this class:
-String targetHit(String platform) throws Exception:
•	Write a code that checks whether a boy hit the target/bomb or not.
•	platform is a string that contains alphanumeric values. divide the platform into N block of length blockSize. For every block check if the first stepSize character contains x in it then throw BombBlast Exception with a message "You hit the target".
•	Else return "Win".
Class BombBlast extends Exception:
-Define BombBlast class derived from the Exception class

Example for Reference
stepSize = 2, blockSize = 3, platform = "1212121x212"
After dividing the platform into N blocks of blockSize = 3 -> ["121", "212", "1x2", "12"]
After consedering only stepSize for every block -> ["12", "21", "1x", "12"]
3rd block contains x. therefore it throw BombBlast exception.
Sample Input
WalkingBoy boy = new WalkingBoy(2,3);
boy.targetHit("1212121x212");
Sample Output
BombBlast : You hit the target
NOTE:
•	You can make suitable function calls and use the RUN CODE button to check your main() method output.
•	stepSize is always less than equal to the blockSize not possibly for the last block.
ALLOWED TECHNOLOGIES
•	Java 8

 */

package Ques43;

class BombBlast extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BombBlast(String msg) {
		super(msg);
	}
	
}

public class WalkingBoy {
	
	int stepSize;
	int blockSize;
	
	WalkingBoy(int stepSize, int blockSize)
	{
		this.blockSize = blockSize;
		this.stepSize = stepSize;
	}
	

	public String targetHit(String platform) throws Exception{
		
		int len = platform.length();
		// int i=0;
		 String[] block = new String[10] ;
		 String[] step = new String[10];
		 int j=0;
		 int m=0;
		 int temp = len %blockSize;
		 int quotient = len - temp; 
		
		 for(int i=0;i<quotient;i=i+blockSize)
		 {
			block[j] = platform.substring(i,i+blockSize);
			
			j=j+1;
		 }
		 block[j]= platform.substring(quotient, len); 
		// System.out.println("j="+j);
		 /*
		 for(int k=0; k<=j;k++)
		{
		System.out.println(block[k]);
		}
		*/
		
		
		 
		 for (m =0 ; m<j;m++)
		 {
			 step[m] = block[m].substring(0,stepSize);
			 
		 }
		 int k = m;
		 step[k] = block[k].substring(0,block[k].length());
		 /*
		 for (m =0 ; m<=k;m++)
		 {
			
			 System.out.println(step[m]);
		 }
		 */
		 for( m=0; m<=j ;m++)
			{
			
			if(block[m].contains("x")) {
				throw new BombBlast("You hit the target");
			}
			
			}
		 return "win";
		 
			
		
	}
	
	public static void main(String[] args) throws Exception {
		WalkingBoy boy = new WalkingBoy(2,3);
		try {
		System.out.println("BombBlast :"+boy.targetHit("1212121x212"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
