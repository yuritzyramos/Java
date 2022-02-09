public  class LetterCount{
	public static void main(String[] args){
 System.out.println(letterCount("aaamb-cc-lmcop", "m" )); // 2
 System.out.println(letterCount("a", "a")); //1
 System.out.println(letterCount("aba", "a")); //2
 System.out.println(letterCount("", "c")); //0
 System.out.println(letterCount("Abc", "b")); //1
 System.out.println(letterCount("zers", "l")); //0
	}
// This method returns the number of times a character appears within a string
public static int letterCount(String s, String c){
int result = 0; 
int i = 0; 
while(i < s.length() && result <= s.length() ){
//Retrieves the character between i and i + 1 and checks if it is are equal to string c
//If the character is equal to c then a value of 1 is added to the result
	if(s.substring(i, i+1).equals(c)){ 
		result += 1;
	}
//If the character is not equal to c then 0 is added to the result
	else{
		result += 0;
	}
i++;
}
return result; 

}
}