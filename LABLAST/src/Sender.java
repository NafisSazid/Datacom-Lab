
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
		return dh(tmp + str);
	}
	private String dh(String str){
		String tmp = cnv.StringToBinary("D-H");
		return phh(tmp + str);
	}
	private String phh(String str){
		String tmp = cnv.StringToBinary("PH-H");
		return (tmp + str);
	}
	public String getSender(String str){
		return ah(str);
	}
}
