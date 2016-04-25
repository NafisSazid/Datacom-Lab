
public class Sender {
	private ConverterClass cnv;
	Sender(){
		cnv = new ConverterClass();
	}
	private String ah(String str){
		String tmp = cnv.StringToBinary("A-H");
		return ph(tmp + str);
	}
	private String ph(String str){
		String tmp = cnv.StringToBinary("P-H");
		return sh(tmp + str);
	}
	private String sh(String str){
		String tmp = cnv.StringToBinary("S-H");
		return th(tmp + str);
	}
	private String th(String str){
		String tmp = cnv.StringToBinary("T-H");
		return nh(tmp + str);
	}
	private String nh(String str){
		String tmp = cnv.StringToBinary("N-H");
		return dataLink(tmp + str);
	}
	private String dataLink(String str){
		String tmp = cnv.StringToBinary("D-H");
		tmp = tmp + str;
		String divisor = "10001000000100001";
		String dividend = tmp + "0000000000000000";
		String remeinder = dividend.substring(0, 17);
		for(int i=17;i<dividend.length();i++){
			if(!remeinder.startsWith("0")){
				remeinder = XOR(divisor,remeinder);
			}
			remeinder = remeinder.substring(1, 17) + dividend.charAt(i);
		}
		if(!remeinder.startsWith("0")){
			remeinder = XOR(divisor,remeinder);
		}
		remeinder = remeinder.substring(1, 17);
		return phh(tmp + remeinder);
	}
	/*
	 * now unused for Lab8 task
	 * but for other it's compulsory.
	 * 
	private String dh(String str){
		String tmp = cnv.StringToBinary("D-H");
		return phh(tmp + str);
	}*/
	private String phh(String str){
		//String tmp = cnv.StringToBinary("PH-H");
		//return (tmp + str);
		return str;
	}
	private String XOR(String s1 , String s2){
		String temp="";
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)==s2.charAt(i))
                temp+="0";
            else
                temp+="1";
        }
        return temp;
	}
	
	public String getSender(String str){
		return ah(str);
	}
}
