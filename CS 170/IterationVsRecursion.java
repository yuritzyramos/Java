public class IterationVsRecursion{
	public static void main(String[] args){
 System.out.println(factorialFor(5));
 System.out.println(factorialRec(5));
 System.out.println(reverseFor("Hello"));
 System.out.println(reverseWhile("Emory"));
 System.out.println(reverseRec("HI!"));
	}
//calculates the factorial of a numver using a FOR loop
public static int factorialFor(int n){
	int result = 1;
	for(int i = 1; i <= n; i++){ //<= becuase you are including the last number
		result *= i;
	}
	return result;
//Remember the only part where i is accessible in the for loop block
}
public static int factorialWhile(int n){
	int result = 1; 
	int i = 1; 
	int k = n;
	while(k > 0){
		result*=k;
		k--;
	}
	return result;
}
public static int factorialRec(int n){
	if(n <= 0){
		return 1; 
	}else{
		return n * factorialRec(n-1);
	}
}
//Reverse a string using a FOR loop
public static String reverseFor(String s){
String result = ""; 
for(int i = s.length() - 1; i >= 0; i--){
      result += s.charAt(i);
}
return result; 
}
//Reverses a string using a while loop
public static String reverseWhile(String s){
 int i = s.length() - 1; //remember: for strings s.length() for arrays array.length
 String result = "";
 while(i >= 0){
 	result += s.charAt(i);
 	i--;//to change the value of i, operation is neede inside of the while loop
 }
 return result; 
 }
public static String reverseRec(String s){
	if(s.length() == 0){
		return "";
	}
	else{
		return "" + s.charAt(s.length() - 1) + reverseRec(s.substring(0,s.length() - 1));
		//remember: substring is all lowercase!
		//BEWARE SYNTAX ERRORS!
	}
}
}