package domain;
import data.*;
import data.PetAuditRecord.ActivityType;

public abstract class Pet {
	private int id;
	private String name;
	private boolean isEating;
	private PetAuditSystem pas;

	public Pet(String name) {
		this.name = name;
		this.isEating = false;
		this.pas = new PetAuditSystem();
	}
	
	public void eatFood() {
		System.out.println(this.getClass().getSimpleName()+ " " + name + " is eating food.");
		this.isEating = true;
	}
	
	public boolean isEating() {
		return this.isEating;
	}
	
	public String getName() {
		return this.name;
	}



	protected abstract void doSpecialAbility();

	public void exercise(){
		doSpecialAbility();
	}


}
