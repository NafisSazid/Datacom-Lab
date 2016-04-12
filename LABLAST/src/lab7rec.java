import java.io.IOException;
import java.util.Random;

public class lab7rec {
	lab7rec(){
		
	}
	private String dataword[] = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
	private String codeWord[] = {"0000000","0001101","0010111","0011010","0100011","0101110","0110100","0111001","1000110","1001011","1010001","1011100","1100101","1101000","1110010","1111111"};
	Random rand = new Random();
	
	private String randPush(String str){
		String temp = "";
		int isIn = (rand.nextInt(100))%100;
		if(isIn<5){
			int bit = (rand.nextInt(2)+100)%2;
			if(bit==1){
				int pos = (rand.nextInt(2)+100)%7;
				for(int i=0;i<str.length();i++){
					if(i==pos){
						if(str.charAt(pos)=='1')temp+="0";
						else temp+="1";
					}
					else temp+=str.charAt(i);
				}
			}
			else {
				return "";
			}
		}
		else return str;
		return temp;
	}
	private String correct(String str){
		String temp = "";
		for(int i=0;i<16;i++){
			int count = 0;
			for(int j=0;j<str.length();j++)if(str.charAt(j)!=codeWord[i].charAt(j))count++;
			if(count<2){
				return dataword[i];
			}
		}
		return temp;
	}
	public void doTask() throws IOException{
		ConverterClass cnvclass = new ConverterClass();
		InputClass inpclass = new InputClass();
		OutputClass outclass = new OutputClass();
		Receiver rcvr = new Receiver();
		//set input
		inpclass.setFileName("tempERRDIT.txt");
		//set output
		outclass.setFileName("outERRDIT.txt");
		while(!inpclass.isEOF()){
			String readFile = "";
			for(int take = 0; take < 172 && !inpclass.isEOF();take++){
				
				String read1 = inpclass.takeInput(7);
				String read2 = inpclass.takeInput(7);
				read1 = randPush(read1);
				read2 = randPush(read2);
				if(read1.length() + read2.length()<8){
					readFile+="$";
					continue;
				}
				read1 = correct(read1);
				read2 = correct(read2);
				read1+=read2;
				readFile+=cnvclass.BinaryToString(read1).toString();
			}
			String writeString = rcvr.getReceiver(readFile);
			outclass.writeFile(writeString);
		}
		outclass.closeFile();
	}
}
