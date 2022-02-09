public class IsOrdered{
public static void main (String[] args){
	System.out.println(isOrdered("Abby"));
	System.out.println(isOrdered("hello"));
	System.out.println(isOrdered("AABBCC"));
	System.out.println(isOrdered("Alligator"));
	System.out.println(isOrdered("lossy"));
	System.out.println(isOrdered("serendipity"));
}
// This method compares each letter within input string to the one before it
//If the vaule of this comparison is postive the code repeats until it is proven false or the string ends
//Once the string is comp
//If the vaule of this comparison is negative the code returns "False" 
public static boolean isOrdered(String s){
	String word = s;
	boolean result = true;
	int i = 0;
	while(result == true || i < s.length()){
      	if((word.substring(i).compareTo(word.substring(i + 1))) < 0){

			 result = true;
		}
		else { 

			 result = false;
				}
				 i++;
	}
	return result;
}
}