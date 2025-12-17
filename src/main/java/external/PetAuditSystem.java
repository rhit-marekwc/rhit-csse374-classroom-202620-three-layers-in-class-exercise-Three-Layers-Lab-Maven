package external;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PetAuditSystem {
	private String filename;
	
	public PetAuditSystem(String filename) {
		this.filename = filename;
	}
	
	public void storeAudit(PetAuditRecord record) {
		try (PrintStream stream = new PrintStream(new FileOutputStream(filename, true))) {
			stream.println(record.toParsableString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
