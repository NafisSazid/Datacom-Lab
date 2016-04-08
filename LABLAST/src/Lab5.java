
import java.io.IOException;

public class Lab5 {
	private String dataSeq [] = {"0000", "0001", "0010", "0011", "0100",
            "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101",
            "1110", "1111"};
	private String enCode [] = {"11110", "01001", "10100", "10101", "01010",
            "01011", "01110", "01111", "10010", "10011", "10110", "10111", "11010",
            "11011", "11100", "11101"};
	Lab5(){
		
	}
	public void doTask() throws IOException{
		InputClass inpClass1 = new InputClass();
		InputClass inpClass2 = new InputClass();
		InputClass inpClass3 = new InputClass();
		InputClass inpClass4 = new InputClass();
		OutputClass outputClass= new OutputClass();
		ConverterClass cnvClass = new ConverterClass();
		//Setting Input for Sender
		inpClass1.setFileName("in1.txt");
		inpClass2.setFileName("in2.txt");
		inpClass3.setFileName("in3.txt");
		inpClass4.setFileName("in4.txt");
		outputClass.setFileName("temp2.txt");
		Sender sndr = new Sender();
		int COUNT = 0;
		int flag = 1;
		String str = "";
		String writingString = null;
		while(true){
			String str1 , str2 , str3 , str4;
			str1 = str2 = str3 = str4="";
			if(flag ==1){
				str = "1";
			}
			else str="0";
			flag ^=1;
			str1 = inpClass1.takeInput(125);
			str2 = inpClass2.takeInput(125);
			str3 = inpClass3.takeInput(125);
			str4 = inpClass4.takeInput(125);
			if(str1.length()==0)str1=" ";
			if(str2.length()==0)str2=" ";
			if(str3.length()==0)str3=" ";
			if(str4.length()==0)str4=" ";
			if(inpClass1.isEOF() && inpClass2.isEOF() && inpClass3.isEOF() && inpClass4.isEOF())break;
			str1 = cnvClass.StringToBinary(str1);
			str1 = sndr.getSender(str1);
			writingString = "";
			for(int i=0;i<str1.length();i+=4){
				String temp = str1.substring(i,i+4);
				for(int ind = 0; ind<16;ind++)if(dataSeq[ind].equals(temp)){
					writingString+=(enCode[ind]);
					COUNT++;
					break;
				}
			}
			str += writingString;
			
			writingString="";
			
			
			str2 = cnvClass.StringToBinary(str2);
			str2 = sndr.getSender(str2);
			writingString = "";
			for(int i=0;i<str2.length();i+=4){
				String temp = str2.substring(i,i+4);
				for(int ind = 0; ind<16;ind++)if(dataSeq[ind].equals(temp)){
					writingString+=(enCode[ind]);
					COUNT++;
					break;
				}
			}
			str += writingString;
			
			writingString="";
			
			
			
			str3 = cnvClass.StringToBinary(str3);
			str3 = sndr.getSender(str3);
			writingString = "";
			for(int i=0;i<str3.length();i+=4){
				String temp = str3.substring(i,i+4);
				for(int ind = 0; ind<16;ind++)if(dataSeq[ind].equals(temp)){
					writingString+=(enCode[ind]);
					COUNT++;
					break;
				}
			}
			str += writingString;
			
			writingString="";
			
			
			str4 = cnvClass.StringToBinary(str4);
			str4 = sndr.getSender(str4);
			writingString = "";
			for(int i=0;i<str4.length();i+=4){
				String temp = str4.substring(i,i+4);
				for(int ind = 0; ind<16;ind++)if(dataSeq[ind].equals(temp)){
					writingString+=(enCode[ind]);
					COUNT++;
					break;
				}
			}
			str += writingString;
			outputClass.writeFile(str);
			str = "";
			writingString="";
		}
		outputClass.closeFile();
	}
}
