package baseball;

public class InputError {
	static int MAX_LENGHT = 3;
	
	boolean checkLengthError(int userAnswer) {
		int length = (int)(Math.log10(userAnswer)+1);
		if(length != MAX_LENGHT) {
			return false;
		}else {
			return true;
		}
	}
	
	boolean checkOverlapError(int userAnswer) {
		if(checkLengthError(userAnswer)) {
			int firth = userAnswer/100;
			int second = (userAnswer%100)/10;
			int thirth = userAnswer%10;
			int disFirstToSecond = firth-second;
			int disThirthToSecond = thirth-second;
			
			if(disFirstToSecond == disThirthToSecond) {
				return false;
			}else if(disFirstToSecond == 0) {
				return false;
			}else if(disThirthToSecond == 0) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	
	boolean checkTextError(String userAnswer){
		try {
			Integer.parseInt(userAnswer);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
}
