
public class ConverterClass {
	ConverterClass(){
		
	}
	public String StringToBinary(String str){
		byte[] ByteSet = str.getBytes();
		StringBuilder sh = new StringBuilder();
		for(byte b: ByteSet){
			sh = toBinary(sh,b);
		}
		return sh.toString();
	}
	private StringBuilder toBinary(StringBuilder sh , int val){
		for(int i=0;i<8;i++){
			sh.append((val &128)==0?0:1);
			val<<=1;
		}
		return sh;
	}
	public String NumberToBinary(int number){
		String ret = "";
		while(number>0){
			int a = number%2;
			number/=2;
			if(a==1)ret+="1";
			else if(a==0)ret+="0";
		}
		StringBuilder rev = new StringBuilder();
		rev.append(ret);
		ret = rev.reverse().toString();
		return ret;
	}
	public Character BinaryToString(String str){
		return (char)Integer.parseInt(str,2);
	}
}
