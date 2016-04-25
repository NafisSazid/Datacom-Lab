
import java.util.Random;

public class Receiver {
	Receiver(){
		
	}
	private int frame=0;
	private String ah(String str){
		String ans = str.substring(3);
		return ans;
	}
	private String ph(String str){
		String ans = str.substring(3);
		return ah(ans);
	}
	private String sh(String str){
		String ans = str.substring(3);
		return ph(ans);
	}
	private String th(String str){
		String ans = str.substring(3);
		return sh(ans);
	}
	private String nh(String str){
		String ans = str.substring(3);
		return th(ans);
	}
	private String dh(String str){
		String ans = str.substring(3);
		return nh(ans);
	}
	private String dataLink(String str){
		frame++;
		//System.out.println(frame);
		str = pushError(str);
		String redundant = str.substring(str.length()-16);
		String divisor = "10001000000100001";
		String dividend = str;
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
		//System.out.println(remeinder);
		if(remeinder.equals("0000000000000000")){
			str = str.substring(0, str.length()-16);
			int i=0, j=0;
            String byt="", temp="";
            for( i=0; i<str.length(); ){
                for(j=i; j<i+8; j++){
                    byt+=str.charAt(j);
                }
                temp+=(char) Integer.parseInt(byt, 2);
                i=j;
                byt="";
            }
            str = temp;
            str=str.substring(3);
            return nh(str);
		}
		return "$";
	}
	private String phh(String str){
		//String ans = str.substring(4);
		//return dh(ans);
		return dataLink(str);
	}
	private String pushError(String str){
		Random rand = new Random();
		char ret[] = new char[str.length()];
		str.getChars(0, str.length(), ret, 0);
		int check = rand.nextInt(100);
		//System.out.println(check);
		if(check<=5){
			System.out.println("Pushing error in frame: "+frame);
			int pos = (rand.nextInt(str.length())+str.length())%str.length();
			if(ret[pos]=='1')ret[pos]='0';
			else ret[pos]='1';
		}
		return new String(ret);
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
	public String getReceiver(String str){
		return phh(str);
	}
}
