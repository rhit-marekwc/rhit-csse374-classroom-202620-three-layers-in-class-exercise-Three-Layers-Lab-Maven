package data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PetAuditRecord {
	public enum ActivityType {
		FEED, EXERCISE
	}
	
	private String petName;
	private ActivityType activityType;
	private LocalDateTime timestamp;
	
	public PetAuditRecord(String petName, ActivityType activityType) {
		this.petName = petName;
		this.activityType = activityType;
		this.timestamp = LocalDateTime.now();
	}
	
	public String getPetName() {
		return petName;
	}
	
	public ActivityType getActivityType() {
		return activityType;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	public String toParsableString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return String.format("%s|%s|%s", 
			timestamp.format(formatter), 
			petName, 
			activityType);
	}
}
