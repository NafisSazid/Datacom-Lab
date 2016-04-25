
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Lab8send send = new Lab8send();
		Lab8rec rec = new Lab8rec();
		//lab7send send = new lab7send();
		//lab7rec rec = new lab7rec();
		send.doTask();
		rec.doTask();
		//rec.doTask();
	}
}
