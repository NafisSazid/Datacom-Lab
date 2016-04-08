
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
	public Character BinaryToString(String str){
		return (char)Integer.parseInt(str,2);
	}
}
