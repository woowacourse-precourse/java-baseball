package baseball;

public class Input {
	static int MAX_LENGHT = 3;
	
	boolean checkLengthError(String userAnswer) {
		if(userAnswer.length() != MAX_LENGHT) {
			return false;
		}else {
			return true;
		}
	}
}
