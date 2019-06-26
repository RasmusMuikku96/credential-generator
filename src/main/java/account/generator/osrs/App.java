package account.generator.osrs;

import java.io.IOException;
import java.util.Scanner;

import account.generator.osrs.mod.Emails;
import account.generator.osrs.mod.Lists;
import account.generator.osrs.mod.Password;

public class App 
{
	public static final Scanner SCN = new Scanner(System.in);
	public static boolean RUN = true;
	public static Lists list = new Lists();
	public static Emails email = new Emails();
	public static Password pass = new Password();
	
    public static void main( String[] args ) throws IOException{
    	while(RUN){
    		System.out.println("[Press Enter to generate new bot credentials, Input 1 to exit]");
    		String sn = SCN.nextLine();
    		if(!sn.equals("1")){
    			String s = list.processFinal(list.processUsername(list.getWordsFromListAndMakeUsername()));
    	    	String p = pass.makeRandomPassword();
    	    	System.out.println("Username[" + s.length() + "]: " + s);
    	    	System.out.println("Password[" + p.length() + "]: " + p);
    	    	System.out.println("Email: " + email.makeEmailOfusername() + email.generateRandomNumberForEmail() + "@protonmail.com");
    		}else{
    			RUN = false;
    			System.out.println("[Exiting]...");
    		}
    	}
    	
    }
	 
}
