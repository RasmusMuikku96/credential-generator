package account.generator.osrs.mod;

import java.util.concurrent.ThreadLocalRandom;

import account.generator.osrs.mod.Lists;

public class Emails {
	
	public String makeEmailOfusername(){
		String sub;
		if(Lists.usernameCapitalized.length() == 2){
			return sub = Lists.usernameCapitalized;
		}
		if(Lists.usernameCapitalized.length() <= 4){
			sub = Lists.usernameCapitalized.substring(0, 3);
		}else{
			sub = Lists.usernameCapitalized.substring(0, 4);
		}
		return sub;
	}
	
	public String generateRandomNumberForEmail(){
		int i = ThreadLocalRandom.current().nextInt(0, 999);
		return String.valueOf(i);
	}
}
