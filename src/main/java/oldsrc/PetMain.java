package oldsrc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

import external.ExternalPetAuditService;
import external.PetAuditRecord;
import external.PetAuditSystem;

/**
 * This program features a zookeeper feeding her pets.
 * 
 * @author Jason Yoder, Matt Boutell, Mark Hays, and their colleagues.
 *
 */
public class PetMain {
	private List<Pet> pets; 
	private Zookeeper zookeeper;
	
	public static void main(String[] args) {
		new PetMain();
	}

	public PetMain() {
		this.zookeeper = new Zookeeper("Mary");
		this.pets = loadPets();
		feedPets();
		countPetsEating();
		showPetSpecialAbilities();
	}

	public List<Pet> loadPets() {
		List<Pet> pets = null;

		try(Scanner in = new Scanner(new FileInputStream("pets.txt"))){
			pets = loadPetsFromFile(in);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Error loading pets", e);
		}
		System.out.println("Loaded " + pets.size() + " pets.");
		return pets;
	}

	private List<Pet> loadPetsFromFile(Scanner in) {
		List<Pet> pets = new ArrayList<Pet>();
		HashMap<String, Supplier<Pet>> petConstructionMap = new HashMap<>();
		petConstructionMap.put("Cat", () -> new Cat(in.next()));
		petConstructionMap.put("Dog", () -> new Dog(in.next()));
		petConstructionMap.put("Fish", () -> new Fish(in.next(), in.nextInt()));
		
		while(in.hasNext()) {
			String petType = in.next();
			Pet constructedPet = petConstructionMap.get(petType).get();
			pets.add(constructedPet);
			
			// Sneak in a quick snack
			this.zookeeper.feedOnePet(constructedPet);
		}
		return pets;
	}
	
	public void feedPets() {
		this.zookeeper.feedPets(this.pets);
	}
	
	public void countPetsEating() {
		int count = 0;
		for (Pet pet : this.pets) {
			if (pet.isEating()) {
				count++;
			}
		}
		System.out.printf("There are %d pets eating\n", count);
	}

	private void showPetSpecialAbilities() {
		for (Pet pet : this.pets) {
			pet.doSpecialAbility();
		}
	}
}