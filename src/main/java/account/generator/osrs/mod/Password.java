package account.generator.osrs.mod;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Password {
	public char takeRandomFromString(){
        String random = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        return random.charAt(rnd.nextInt(random.length()));
    }
	
	public String makeRandomPassword(){
		StringBuilder sb = new StringBuilder();
		int rand = ThreadLocalRandom.current().nextInt(16, 32);
		for(int i = 0; i < rand; i++){
			sb.append(takeRandomFromString());
		}
		return sb.toString();
	}

}
