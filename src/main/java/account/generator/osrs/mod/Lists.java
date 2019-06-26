package account.generator.osrs.mod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Lists {
	
	public static int listIndexAmountAdjectives = 0;
	public static int listIndexAmountUsernames = 0;
	public static String usernameCapitalized;
	public static String adjectiveCapitalized;
	
	public static int generateRandom(){
		int toRandomValue = ThreadLocalRandom.current().nextInt(0, 3);
				
		return toRandomValue;
	}
	
    public String makeRandomWordFromListAdjectives() throws IOException{
    	listIndexAmountAdjectives = 0;
    	ArrayList<String> hangmanList = new ArrayList<String>();
    	try (BufferedReader br = new BufferedReader(new FileReader("Adjectives"))) {
            while (br.ready()) {
            	hangmanList.add(br.readLine());
            	listIndexAmountAdjectives++;
            }
    	}
    	String selectedWord = returnRandomFromList(hangmanList,listIndexAmountAdjectives);
        return selectedWord;
    }
    
    public String makeRandomWordFromListUsernames() throws IOException{
    	listIndexAmountUsernames = 0;
    	ArrayList<String> hangmanList = new ArrayList<String>();
    	try (BufferedReader br = new BufferedReader(new FileReader("Usernames"))) {
            while (br.ready()) {
            	hangmanList.add(br.readLine());
            	listIndexAmountUsernames++;
            }
    	}
    	String selectedWord = returnRandomFromList(hangmanList,listIndexAmountUsernames);
        return selectedWord;
    }
    
    public String getWordsFromListAndMakeUsername() throws IOException{
    	String adjective = makeRandomWordFromListAdjectives();
    	String username = makeRandomWordFromListUsernames();
    	
    	String s1 = username.substring(0, 1).toUpperCase();
        usernameCapitalized = s1 + username.substring(1);
        
        String s2 = adjective.substring(0, 1).toUpperCase();
        adjectiveCapitalized = s2 + adjective.substring(1);
        
        return adjectiveCapitalized + usernameCapitalized;
    }
    
    public String processUsername(String s){
    	//boolean pass = false;
    	String result = s;
    	//while(!pass){
		if(s.length() < 12){
			int t = 12 - s.length();
			//System.out.println(t);
			
			if(t == 1){
				for(int i = 0; i == 0; i++){
		    		result = result + newRandNumberOneToNine();
		    	}
			}else if(t == 2){
				for(int i = 0; i <= 1; i++){
		    		result = result + newRandNumberOneToNine();
		    	}
			}else if(t >= 3){
				for(int i = 0; i <= 2; i++){
		    		result = result + newRandNumberOneToNine();
		    	}
	        }
		}
		return result;
    }
    
    public String processFinal(String s){
    	if(s.length() > 12){
    		String p = s.substring(0, 12);
        	System.out.println(p.length());
        	return p;
    	}
    	return s;
    }
		
    
    
    public String newRandNumberOneToNine(){
    	int i = ThreadLocalRandom.current().nextInt(1, 9);
    	return String.valueOf(i);
    }
    
    public static String returnRandomFromList(ArrayList<String> list, int listIndexAmount) {
      	int index = ThreadLocalRandom.current().nextInt(listIndexAmount);
        String element = list.get(index);
        return element;
    }
    
}
