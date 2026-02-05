package domain;

import data.PetAuditRecord;
import data.PetAuditSystem;
import data.PetAuditRecord.ActivityType;

public class Audit {
    private PetAuditSystem pas;
    public Audit(){
        this.pas = new PetAuditSystem();
    }
    public void auditFed(String petName){
		PetAuditRecord record = new PetAuditRecord(petName, ActivityType.FEED);
		pas.storeAudit(record);
		
	}
    public void auditExercise(String petName){
		PetAuditRecord record = new PetAuditRecord(petName, ActivityType.EXERCISE);
		pas.storeAudit(record);
		
	}
}
