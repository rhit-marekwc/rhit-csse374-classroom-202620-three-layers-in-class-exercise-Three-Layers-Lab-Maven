package oldsrc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Cat extends Pet {

	public Cat(String name) {
		super(name);
	}

	@Override
	public void doSpecialAbility() {
		try(PrintStream stream = new PrintStream(new FileOutputStream("petLog.txt", true))) {
			stream.println(getName() + " says: Yawn. Zzz...");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
