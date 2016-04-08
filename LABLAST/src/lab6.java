/*
 * lab6.java
 * Author: Anando
 */
import java.io.IOException;

public class lab6 {
	private int numberOfInput;
	//private int syncBit;
	private String dataSeq [] = {"0000", "0001", "0010", "0011", "0100",
            "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101",
            "1110", "1111"};
	private String enCode [] = {"11110", "01001", "10100", "10101", "01010",
            "01011", "01110", "01111", "10010", "10011", "10110", "10111", "11010",
            "11011", "11100", "11101"};
	lab6(int a){
		numberOfInput = a;
		//syncBit=1;
	}
	private int genRand(int i){                         //random file selection
		return (5 + 7*i)%numberOfInput;
	}
	public void doTask() throws IOException{
		InputClass[] fileInput =  new InputClass[numberOfInput];
		int key = 0;
		for(int i=0;i<numberOfInput;i++)fileInput[i] = new InputClass();
		OutputClass fileOutput = new OutputClass();
		ConverterClass convClass = new ConverterClass();
		//set input files
		for(Integer i = 1;i<=numberOfInput;i++)fileInput[i-1].setFileName("in"+i.toString()+".txt");
		//set output file
		fileOutput.setFileName("temp2.txt");
		int available = numberOfInput;                                  //number of files that can be read . if available is 0 then no reading file
		int availability[] = new int[numberOfInput];                    //condition of a file (readable / unreadable)
		for(int i=0;i<numberOfInput;i++)availability[i]=1;             //set every file readable(1)
		Sender sndr = new Sender(); 
		while(available !=0){
			String stringToWrite = "";
			//if(syncBit==1)stringToWrite="1";                       //set frame synchronize bit 1 or 0
			//else stringToWrite="0";                                
			//syncBit^=1;
			for(int fileNumber=0;fileNumber<numberOfInput && available!=0;fileNumber++){    //process files if they are available
				int fileIndexNo=genRand(key++);                                             //generate index number of current reading file
				String takingFile = fileInput[fileIndexNo].takeInput(125);                  //take 125 characters from that file
				for(int i=takingFile.length();i<125;i++)takingFile+=" ";                    //if there is not enough characters then fill it using space
				if(fileInput[fileIndexNo].isEOF())availability[fileIndexNo]=0;              //if EOF reached then make that file unavailable
				takingFile = convClass.StringToBinary(takingFile);                          //convert to binary
				takingFile = sndr.getSender(takingFile);                                    //add OSI layer protocols
				String encodingString = "";                                                 //4B/5B encoding scheme used here
				for(int i=0;i<takingFile.length();i+=4){
					String temp = takingFile.substring(i,i+4);
					for(int ind = 0; ind<16;ind++)if(dataSeq[ind].equals(temp)){
						encodingString+=(enCode[ind]);
						break;
					}
				}
				stringToWrite+=encodingString;                                             //save that encoded bit to write in a file
				available=0;
				for(int i=0;i<numberOfInput;i++)available+=availability[i];               //check if any file available
			}
			fileOutput.writeFile(stringToWrite);                                         //write the whole encoded message
		}
		fileOutput.closeFile();                                                          //close file
	}
}