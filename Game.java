/*
 * Name: Youssef Hussein
 * NetID: yhussein
 * 
 * "the work on this project is totally my own and I didn't receive any help on it".
 */
public class Game {
	private String[] keyInput = {"w","q","a","s","d","r"};

	//check to see if the 
	public boolean contains(String in) {
		for(String a: keyInput) {
			if(a.equals(in)) {
				return true;			
			}
		}
		return false;
	}
}
