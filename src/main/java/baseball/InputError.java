package baseball;

public class InputError {
	static int MAX_LENGHT = 3;
	
	static boolean checkLengthError(String userAnswer) throws IllegalArgumentException{
		int userNumber = Integer.parseInt(userAnswer);

		int length = (int)(Math.log10(userNumber)+1);
		if(length != MAX_LENGHT) {
			throw new IllegalArgumentException();
		}else {
			return true;
		}
	}
	
	static boolean checkOverlapError(String userAnswer) throws IllegalArgumentException{
		int userNumber = Integer.parseInt(userAnswer);

		int firth = userNumber/100;
		int second = (userNumber%100)/10;
		int third = userNumber%10;
		int disFirstToSecond = firth-second;
		int disThirdToSecond = third-second;
			
		if(disFirstToSecond != disThirdToSecond && disFirstToSecond != 0 && disThirdToSecond != 0) {
			return true;
		}else {
			throw new IllegalArgumentException();
		}
	}
	
	static boolean checkTextError(String userAnswer)  throws IllegalArgumentException {
		try {
			Integer.parseInt(userAnswer);
			return true;
		}catch(Exception e) {
			throw new IllegalArgumentException();
		}
	}
}
