package Ques41;

/*
Q41

Case Study: There exists a monster who is going to fight the greatest warrior the world has ever seen. Before that, he needs to eat something. Given that, he eats only numbers. If anything other than numbers is found in his food he will throw the food and will not go for the war. For example, the food is like "1234$56". He will throw the food saying there exists a '$' which he considers as intolerable.
Complete the classes using the Specifications given below. Consider default visibility of classes, data fields, and methods unless mentioned otherwise.
Specifications

class definitions:
 class Food:
    data members: 
        String plate
        int numberOfSoldiers
    Food(String plate, int numberOfSoldiers): constructor with public visibility

class KhumbhKaran:
 method definitions:
     getReadyToFight(Food food) throws Exception:     
        return type: String
        visibility: public     

     winTheWar(Food food) throws Exception:
        return type: String
        visibility: public   

 class FoodException:
   method definitions:
      FoodException(String msg)
         visibility: public  

Task
Class Food
- define the String variable plate.
- define the int variable numberOfSoldiers
-define a constructor according to the above specifications.

Class KhumbhKaran
Implement the below methods for this class:
-String getReadyToFight(Food food) throws Exception:
•	Write a code to validate the criteria for going to fight.
•	throw a FoodException if the plate contains a special character with a message "Insect found in the food".
•	throw a FoodException if the plate contains an uppercase or lowercase character with a message "Not edible". Assuming that, either it will have special symbols or characters but not both simultaneously.
•	If the numberofSoldiers is less than 1000 then throw a FoodException with the message "Food was not sufficient".
•	If no above exception is found then return a string message "Ready for the war".

-String winTheWar(Food food):
•	Write a code to send an invite to the nominee.
•	If getReadyToFight() method throws a FoodException then returns a message "No war".(Use try-catch block)
•	If it throws any other exception then return a message "Other exception".
•	If no exception is found then return a message "Here the battle starts".

Sample Input
Food f = new Food("1234", 70000);
KhumbhKaran v = new KhumbhKaran();
String s = v.getReadyToFight(f);
String t = v.winTheWar(f);
s.toLowerCase();
t.toLowerCase();

Sample Output
ready for the war
here the battle starts

*/

class FoodException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FoodException(String str)
    {
        super(str);
    }
}

public class Food {
    String plate;
    int numberOfSoldiers;

    public Food(String plate, int numberOfSoldiers)
    {
        this.plate=plate;
        this.numberOfSoldiers=numberOfSoldiers;
    }

    public static void main(String[] args) throws Exception{
        try{
        Food f = new Food("1234", 70000);
        KhumbhKaran v = new KhumbhKaran();
        String s = v.getReadyToFight(f);
        String t = v.winTheWar(f);
        System.out.println(s.toLowerCase());
        System.out.println(t.toLowerCase());
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}

class KhumbhKaran{
    KhumbhKaran()
    {

    }

    public String getReadyToFight(Food f) throws Exception
    {
        String food=f.plate;
        for(int i=0;i<food.length();i++)
        {
            if(food.charAt(i)=='@' || food.charAt(i)=='#' || food.charAt(i)=='$' || food.charAt(i)=='%' || food.charAt(i)=='*')
            {
                throw new FoodException("Insect found in the food");
            }

            if(Character.isUpperCase(food.charAt(i)) || Character.isLowerCase(food.charAt(i)))
            {
                throw new FoodException("Not edible");
            }
        }
        if(f.numberOfSoldiers < 1000)
        {
            throw new FoodException("Food was not sufficient");
        }
      
        return "Ready for the war";
       
    }

    public String winTheWar(Food f) throws Exception
    {
        try{
            String s=getReadyToFight(f);
            if(s.equals("Ready for the war"))
            {
                return "Here the battle starts";
            }
        }
        catch(FoodException e)
        {
            return "No war";
        }

        catch(Exception e)
        {
            return "Other exception";
        }
        return null;
    }
}

