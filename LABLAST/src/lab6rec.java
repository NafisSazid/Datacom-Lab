
import java.io.IOException;
public class lab6rec {
	private int numberOfFile;
	private String dataSeq [] = {"0000", "0001", "0010", "0011", "0100",
            "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101",
            "1110", "1111"};
	private String enCode [] = {"11110", "01001", "10100", "10101", "01010",
            "01011", "01110", "01111", "10010", "10011", "10110", "10111", "11010",
            "11011", "11100", "11101"};
	lab6rec(int a){
		numberOfFile = a;
	}
	private int genRand(int i){
		return (5 + 7*i)%numberOfFile;
	}
	void doTask() throws IOException{
		Receiver rcvr = new Receiver();
		int key = 0;
		//set objects to be used
		InputClass fileInput = new InputClass();
		OutputClass fileOutput[] = new OutputClass[numberOfFile];
		ConverterClass cnvClass = new ConverterClass();
		for(int i=0;i<numberOfFile;i++)fileOutput[i]=new OutputClass();
		//set input file
		fileInput.setFileName("temp2.txt");
		//set output files
		for(Integer i=1;i<=numberOfFile;i++)fileOutput[i-1].setFileName("out"+i.toString()+".txt");
		//start processing
		while(!fileInput.isEOF()){
			//fileInput.takeInput(1);
			for(int k=0;k<numberOfFile &&!fileInput.isEOF();k++){
				String writeToFile = "";      //String to be written in the file
				int fileIndexNumber = genRand(key++);        //get writing file address (randomly)
				for(int i=0;i<147 && !fileInput.isEOF();i++){ 
					//4B/5B decoding
					String temp = fileInput.takeInput(5);
					String XX = "";
					for(int ind=0;ind<16;ind++)if(temp.equals(enCode[ind])){
						XX+=(dataSeq[ind]);
						break;
					}
					temp = fileInput.takeInput(5);
					for(int ind=0;ind<16;ind++)if(temp.equals(enCode[ind])){
						XX+=(dataSeq[ind]);
						break;
					}
					temp = XX;
					temp = cnvClass.BinaryToString(temp).toString();       //convert binary to character
					writeToFile+=temp;
					//if(writeToFile.length()==0)System.out.println(XX); //debugger 
				}
				//now write all 125 characters decoding them in receiver
				if(writeToFile.length()>0){
					writeToFile = rcvr.getReceiver(writeToFile);
					fileOutput[fileIndexNumber].writeFile(writeToFile);
				}
			}
		}
		for(int i=0;i<numberOfFile;i++)fileOutput[i].closeFile(); //close all files
	}
}
