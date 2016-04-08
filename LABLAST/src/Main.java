
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//lab6 send = new lab6(6);
		//lab6rec receive = new lab6rec(6);
		//send.doTask();
		//receive.doTask();
		lab6b send = new lab6b();
		lab6brec rec = new lab6brec();
		send.dotasksender();
		rec.dotaskreceiver();
	}
}
