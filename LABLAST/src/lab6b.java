import java.io.FileNotFoundException;
import java.io.IOException;

public class lab6b {
	lab6b(){
		
	}
	public void dotasksender() throws IOException{
		String barker[] = {"01001000110","10110111001"};    //barker for 0 and one
		//set every object
		ConverterClass cnvclass = new ConverterClass();
		InputClass inpclass = new InputClass();
		OutputClass outclass = new OutputClass();
		Sender sndr = new Sender();
		//set input file
		inpclass.setFileName("in1.txt");
		//set output file
		outclass.setFileName("tempDHSS.txt");
		while(!inpclass.isEOF()){
			String readString = inpclass.takeInput(125); //take 125 character for input
			for(int i=readString.length();i<125;i++)readString+=" "; //if can't take then take space
			readString = cnvclass.StringToBinary(readString); //convert them to binary
			readString = sndr.getSender(readString); //add OSI protocol layer
			//encode using barker chart
			String encode = "";
			for(int i=0;i<readString.length();i++){
				if(readString.charAt(i)=='0')encode+=barker[0];
				else if(readString.charAt(i)=='1') encode+=barker[1];
			}
			//write to file
			outclass.writeFile(encode);
		}
		outclass.closeFile();
	}
}