import java.io.FileNotFoundException;
import java.io.IOException;

public class lab7send {
	lab7send(){
		
	}
	private String dataword[] = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
	private String codeWord[] = {"0000000","0001101","0010111","0011010","0100011","0101110","0110100","0111001","1000110","1001011","1010001","1011100","1100101","1101000","1110010","1111111"};
	public void doTask() throws IOException{
		ConverterClass cnvclass = new ConverterClass();
		InputClass inpclass = new InputClass();
		OutputClass outclass = new OutputClass();
		Sender sndr = new Sender();
		//set input file
		inpclass.setFileName("in1.txt");
		//set output file
		outclass.setFileName("tempERRDIT.txt");
		while(!inpclass.isEOF()){
			String readString = inpclass.takeInput(150);
			for(int i=readString.length();i<150;i++)readString+=" ";
			readString = cnvclass.StringToBinary(readString);
			readString = sndr.getSender(readString);
			String writeString = "";
			for(int i=0;i<readString.length();i+=4){
				String tempString = readString.substring(i,i+4);
				for(int j=0;j<16;j++)if(dataword[j].equals(tempString)){
					writeString += codeWord[j];
					break;
				}
			}
			outclass.writeFile(writeString);
		}
		outclass.closeFile();
	}
}
