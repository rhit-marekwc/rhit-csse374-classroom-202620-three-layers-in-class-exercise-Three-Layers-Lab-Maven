package presentation;

import java.util.List;
import domain.*;
import data.*;


/**
 * This program features a zookeeper feeding her pets.
 * 
 * @author Jason Yoder, Matt Boutell, Mark Hays, and their colleagues.
 *
 */
public class PetMain {
	private List<Pet> pets; 
	private Zookeeper zookeeper;
	private loadPets loaded;
	public static void main(String[] args) {
		new PetMain();
	}

	public PetMain() {
		this.zookeeper = new Zookeeper("Mary");
		this.loaded = new loadPets();
		this.pets = loaded.loadInPets(); //Made static to call at any point from the same class, might change if requested
		for(Pet pet : pets){
			this.zookeeper.feedOnePet(pet);
		}
		feedPets();
		countPetsEating();
		showPetSpecialAbilities();
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
			pet.exercise();
		}
	}
}