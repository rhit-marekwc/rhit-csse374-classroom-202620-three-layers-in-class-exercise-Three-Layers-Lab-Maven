package data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;


public class PetAuditSystem {
	private String filename;

	public PetAuditSystem() {
		this.filename = "audit.txt";
	}
	
	public void storeAudit(PetAuditRecord record) {
		
		try (PrintStream stream = new PrintStream(new FileOutputStream(filename, true))) {
			stream.println(record.toParsableString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
