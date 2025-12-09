package oldsrc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Dog extends Pet {
	
	public boolean goodDog = true;
	
	public Dog(String name) {
		super(name);
		askIfGoodDog(name);
	}

	public void askIfGoodDog(String name) {
		Scanner in = new Scanner(System.in);
		System.out.print("Is "+name+" a good dog? (yes/no): ");
		goodDog = "yes".equals(in.next());
	}

	@Override
	public void doSpecialAbility() {
		try(PrintStream stream = new PrintStream(new FileOutputStream("petLog.txt", true))) {
			stream.print(getName() + " says: ");
			if (startsWithVowel(this.getName())) {
				stream.println("Arf!");
			} else {
				stream.println("Bow wow!");
			}
			stream.println(goodDog ? "Good dog!" : "Bad dog!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private boolean startsWithVowel(String s) {
		char ch = Character.toLowerCase(s.charAt(0));
		// When y is the first letter of a word, it isn't a vowel.
		return ch == 'a' || ch == 'e' || ch == 'i' 
				|| ch == 'o' || ch == 'u';
	}	
}
