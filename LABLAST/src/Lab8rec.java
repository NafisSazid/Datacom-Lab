import java.io.IOException;
import java.util.Random;

public class Lab8rec {
	Lab8rec(){
		
	}
	Random rand = new Random();
	
	
	public void doTask() throws IOException{
		ConverterClass cnvclass = new ConverterClass();
		InputClass inpclass = new InputClass();
		OutputClass outclass = new OutputClass();
		Receiver rcvr = new Receiver();
		//set input
		inpclass.setFileName("tempCRC.txt");
		//set output
		outclass.setFileName("outCRC.txt");
		while(!inpclass.isEOF()){
			String readLine = inpclass.takeInput(1360);
			outclass.writeFile(rcvr.getReceiver(readLine));
		}
		outclass.closeFile();
	}
}
