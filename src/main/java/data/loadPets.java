package data;
import domain.*;
import java.util.*;
import java.io.*;
import java.util.function.Supplier;


public class loadPets{
public List<Pet> loadInPets() {
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
			
		}
		return pets;
}
}