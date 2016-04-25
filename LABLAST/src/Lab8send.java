import java.io.FileNotFoundException;
import java.io.IOException;

public class Lab8send {
	Lab8send(){
		
	}
	public void doTask() throws IOException{
		ConverterClass cnvclass = new ConverterClass();
		InputClass inpclass = new InputClass();
		OutputClass outclass = new OutputClass();
		Sender sndr = new Sender();
		//set input file
		inpclass.setFileName("in1.txt");
		//set output file
		outclass.setFileName("tempCRC.txt");
		while(!inpclass.isEOF()){
			String readLine = inpclass.takeInput(150);
			for(int i=readLine.length();i<150;i++)readLine+=" ";
			readLine = cnvclass.StringToBinary(readLine);
			readLine = sndr.getSender(readLine);
			outclass.writeFile(readLine);
		}
		outclass.closeFile();
	}
}
