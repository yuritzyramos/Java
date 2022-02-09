public class Problem_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(wordCount("Hello World"));
		System.out.println(wordCount("Hello"));
		System.out.println(wordCount("Hello World Hello!"));
		System.out.println(wordCount("Hello  Hello"));
		System.out.println(wordCount("Hello Hello Bob the  Builder"));
		System.out.println(wordCount(""));
		System.out.println(wordCount("Wahoo42!??!?!"));
		System.out.println(wordCount("This   is   a    test!!!!!"));


	}

	public static int wordCount(String s) {
		int indexOfSpace = 0;
		int result = 0;
		int i = 0;
		int numSpaces = 0;
		while (i < s.length()) {
			if (s.substring(i, i+1).equals(" ")) {
				indexOfSpace = i;
				numSpaces += 1;
				if ((s.charAt(i) < indexOfSpace || s.charAt(i) > indexOfSpace && s.substring(i) != " ")) {
					result += 1;
				} else{
					result += 0;
				}
			}
			else if (i == (s.length() - 1)) {
				result += 1;
			}
			if (s.substring(i, i+1).equals(" ") && s.substring(i+1, i+2).equals(" ") && numSpaces > 0) {
				 result -= 1;
			}
			i++;
		}
		return result;
	}
}