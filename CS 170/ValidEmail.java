public class ValidEmail{
	public static void main(String[] args){
      System.out.println(isvalidEmail("user_123@domain.ext"));//true
      System.out.println(isvalidEmail("erin123@joyce.com"));//true
      System.out.println(isvalidEmail("user123alpha@domain.com"));//false
      System.out.println(isvalidEmail("Emory_2023@Collegemoney.educ"));//true
      System.out.println(isvalidEmail("0user_12@domain.ext"));//false
      System.out.println(isvalidEmail("user_123@6omain.ext"));//false
      System.out.println(isvalidEmail("babygirl@abby.com"));//true
      System.out.println(isvalidEmail("user_123@domain.snailmail"));//false
	}
//This method returns true if an inputed String s matches the conditions of the regular expression
	//It returns false otherwise
public static boolean isvalidEmail(String s){
		if(s.matches("([a-z]|[A-Z])\\w{0,10}\\@([a-z]|[A-Z])\\w{0,12}\\.[a-z]{0,4}")){ 
		//Returns true if the string starts with a capital or lowercase letter followed by 1 - 9 word characters
			//Followed by the symbol @,an upper or lowercase letter, and 1-11 word characters
				//Lastly followed by a period and 1-3 lowercase letters
			return true;//if allconditions are met return true

		}
			else{ //if any of the conditions in the regular expression is not met 
			return false; //method returns false
			}
	}
}