public class StoryTeller{
public static void main (String[] args){
// System.out.println(storyteller("Pam", "Ana", "mirrors", 6, "frogs", "blue", "Germany"));
	
 // System.out.println(spell1("Pam")); // works
 //  System.out.println(spell1("David")); // works
 System.out.println(spell2("Pam"));
 System.out.println(spell2("Gerald")); // X


}
public static String storyteller(String girl1, String girl2, String possession, int numPossession, 
	String transformation, String color, String country){
return girl1+ " was a beautiful princess. " + girl2 + " was a wicked witch. " + girl1 + " had " + numPossession 
+ " " + possession + ", whereas " + girl2 + " had only " + (numPossession/2) + ". Because of envy, " + girl2 + " cast a spell on " + girl1 
+ ", yelling these arcane magical words: " + spell1(girl1) + " Suddenly, " + girl1 + "'s " + numPossession + " " + possession + " turned into " 
+ color + " " + transformation + ". " + girl1 + " became very unhappy. Seeing that " + girl1 +" was unhappy, "
 + girl2 + " realized she was wrong, and reversed the spell. " + girl1 + " and " + girl2 + " became friends, and they lived happily ever after in "
 + country + ".";
}
public static String spell1(String girl1) {
String result = "";
		for(int i = girl1.length() - 1; i >= 0; i-=girl1.length()) {
			result += girl1.charAt(i);
}
return result;
}
public static String spell2(String girl1) {
String result ="";
		for(int i = 0; i < girl1.length(); i += girl1.length()) {
			result += girl1.charAt(i) + girl1.toLowerCase();
}
return result;
}
}
