
import java.util.Random;

public class Receiver {
	Receiver(){
		
	}
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
	private String phh(String str){
		String ans = str.substring(4);
		return dh(ans);
	}
	private int get(int a, int b){
		Random rand = new Random();
		int ret = rand.nextInt(b-a+1)+a;
		return ret;
	}
	public String getReceiver(String str){
		return phh(str);
	}
}
