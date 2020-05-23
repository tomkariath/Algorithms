package problems;

import java.util.Arrays;

public class RegexMatch {

	public static void main(String[] args) {
		String string = "thomas.123";
		String string2 = "198.10.0.1,abc,somevalue,someothervalue\n"+"164.12.3.10,xyz,some value, some value\n";
		
		//^ - Starts with
		//+ - 1 or more
		//* - 0 or more
		//? - 0 or 1
		//$ - ends with
		String regex = "(^[A-Za-z]+)([a-zA-Z0-9]*)(\\.?)([a-zA-Z0-9]+)$";
		//String regex2 = ",[\\w\\d\\s]+";
		String regex3 = "[,[a-zA-Z]\\s]+\\n";
		
		
		if (string.matches(regex)) {
			System.out.println("true");
			System.out.println(string.length());
		}
		else{
			System.out.println("false");
		}
		
		String[] tempArray = string2.split(regex3);
		
		Arrays.sort(tempArray);
		System.out.println(Arrays.toString(tempArray));
	}
	
}
