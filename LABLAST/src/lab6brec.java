import java.io.FileNotFoundException;
import java.io.IOException;

public class lab6brec {
	lab6brec(){
		
	}
	public void dotaskreceiver() throws IOException{
		String barker[] = {"01001000110","10110111001"};
		//set objects
		ConverterClass cnvclass = new ConverterClass();
		InputClass inpclass = new InputClass();
		OutputClass outclass = new OutputClass();
		Receiver rcvr = new Receiver();
		//set input
		inpclass.setFileName("tempDHSS.txt");
		//set output
		outclass.setFileName("outDHSS.txt");
		while(!inpclass.isEOF()){
			String writeString="";
			for(int takeinput=0;takeinput<147 && !inpclass.isEOF();takeinput++){
				String temp = "";
				for(int i=0;i<8;i++){ //take 8 bits
					String XX = inpclass.takeInput(11);
					if(XX.equals(barker[0]))temp+="0";
					else if(XX.equals(barker[1]))temp+="1";
				}
				//convert them to character
				writeString+=cnvclass.BinaryToString(temp).toString();
			}
			//create whole message
			writeString=rcvr.getReceiver(writeString);
			//write output
			outclass.writeFile(writeString);
		}
		outclass.closeFile();
	}
}