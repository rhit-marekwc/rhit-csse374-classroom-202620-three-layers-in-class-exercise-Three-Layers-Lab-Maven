package oldsrc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Fish extends Pet {
	private int numWiggles;

	public Fish(String name, int numWiggles) {
		super(name);
		this.numWiggles = numWiggles;
	}
	
	@Override
	public void doSpecialAbility() {
		try(PrintStream stream = new PrintStream(new FileOutputStream("petLog.txt", true))) {
			stream.println(getName() + " says, time to move!");
			for (int j = 1; j <= this.numWiggles; j++) {
				stream.println("Wiggle " + j);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
