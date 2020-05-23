package problems;

public class UsernamePattern {
    
    public static boolean validate(String username) {
    	String regex = "(^[A-Za-z]+)([a-zA-Z0-9]*)(\\.?)([a-zA-Z0-9]+)$";
    	if(username.length()>5 && username.length()<21 && username.matches(regex)) {
    		return true;
    	}    	
		return false;
    }
    
    public static void main(String[] args) {
        System.out.println(validate("Robert.Domek")); // Valid username
        System.out.println(validate("Robert Domek")); // Invalid username
        System.out.println(validate("Robert.DomekThomasJohn"));
    }
}
