package oldsrc;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Zookeeper {
	private String name;
	
	public Zookeeper(String name) {
		this.name = name;
	}
	
	public void feedOnePet(Pet pet) {
		try(PrintStream stream = new PrintStream(new FileOutputStream("petLog.txt", true))) {
			stream.printf("%s is feeding %s. "+System.lineSeparator(), this.name, pet.getName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		pet.eatFood();
	}

	public void feedPets(List<Pet> pets) {
		try(Scanner in = new Scanner(System.in)){
			while(true) {
				System.out.println("Enter the name of a pet to feed, or STOP to stop:");
				String petName = in.nextLine();
				if("STOP".equals(petName)) break;
				Pet petToFeed = pets.stream().filter(p -> petName.equals(p.getName())).findFirst().get();
				feedOnePet(petToFeed);
			}
		}
	}
}
