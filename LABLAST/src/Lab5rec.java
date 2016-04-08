
import java.io.IOException;
public class Lab5rec {
	private String dataSeq [] = {"0000", "0001", "0010", "0011", "0100",
            "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101",
            "1110", "1111"};
	private String enCode [] = {"11110", "01001", "10100", "10101", "01010",
            "01011", "01110", "01111", "10010", "10011", "10110", "10111", "11010",
            "11011", "11100", "11101"};
	Lab5rec(){
		
	}
	void doTask() throws IOException{
		InputClass inpClass = new InputClass();
		OutputClass outputClass1= new OutputClass();
		OutputClass outputClass2= new OutputClass();
		OutputClass outputClass3= new OutputClass();
		OutputClass outputClass4= new OutputClass();
		ConverterClass cnvClass = new ConverterClass();
		Receiver rcvr = new Receiver();
		inpClass.setFileName("temp2.txt");
		outputClass1.setFileName("out.txt");
		outputClass2.setFileName("out2.txt");
		outputClass3.setFileName("out3.txt");
		outputClass4.setFileName("out4.txt");
		while(!inpClass.isEOF()){
			String str = "";
			inpClass.takeInput(1);
			for(int i=0;i<147 && !inpClass.isEOF();i++){
				String temp = inpClass.takeInput(5);
				String XX="";
				for(int ind=0;ind<16;ind++)if(temp.equals(enCode[ind])){
					XX+=(dataSeq[ind]);
					break;
				}
				temp = inpClass.takeInput(5);
				for(int ind=0;ind<16;ind++)if(temp.equals(enCode[ind])){
					XX+=(dataSeq[ind]);
					break;
				}
				temp = XX;
				temp = cnvClass.BinaryToString(temp).toString();
				str+=temp;
			}
			str = rcvr.getReceiver(str);
			outputClass1.writeFile(str);
			
			str = "";
			for(int i=0;i<147 && !inpClass.isEOF();i++){
				String temp = inpClass.takeInput(5);
				String XX="";
				for(int ind=0;ind<16;ind++)if(temp.equals(enCode[ind])){
					XX+=(dataSeq[ind]);
					break;
				}
				temp = inpClass.takeInput(5);
				for(int ind=0;ind<16;ind++)if(temp.equals(enCode[ind])){
					XX+=(dataSeq[ind]);
					break;
				}
				temp = XX;
				temp = cnvClass.BinaryToString(temp).toString();
				str+=temp;
			}
			str = rcvr.getReceiver(str);
			outputClass2.writeFile(str);
			
			str = "";
			for(int i=0;i<147 && !inpClass.isEOF();i++){
				String temp = inpClass.takeInput(5);
				String XX="";
				for(int ind=0;ind<16;ind++)if(temp.equals(enCode[ind])){
					XX+=(dataSeq[ind]);
					break;
				}
				temp = inpClass.takeInput(5);
				for(int ind=0;ind<16;ind++)if(temp.equals(enCode[ind])){
					XX+=(dataSeq[ind]);
					break;
				}
				temp = XX;
				temp = cnvClass.BinaryToString(temp).toString();
				str+=temp;
			}
			str = rcvr.getReceiver(str);
			outputClass3.writeFile(str);
			
			str = "";
			for(int i=0;i<147 && !inpClass.isEOF();i++){
				String temp = inpClass.takeInput(5);
				String XX="";
				for(int ind=0;ind<16;ind++)if(temp.equals(enCode[ind])){
					XX+=(dataSeq[ind]);
					break;
				}
				temp = inpClass.takeInput(5);
				for(int ind=0;ind<16;ind++)if(temp.equals(enCode[ind])){
					XX+=(dataSeq[ind]);
					break;
				}
				temp = XX;
				temp = cnvClass.BinaryToString(temp).toString();
				str+=temp;
			}
			str = rcvr.getReceiver(str);
			outputClass4.writeFile(str);
		}
		outputClass1.closeFile();
		outputClass2.closeFile();
		outputClass3.closeFile();
		outputClass4.closeFile();
	}
}
