package baseball;

import java.util.ArrayList;

public class InputView {
	static void checkIllegalInput(ArrayList<Integer> userInputNumbers) {
		if(userInputNumbers.size() != userInputNumbers.stream().distinct().count()) exit();
		if(userInputNumbers.size() != 3 || userInputNumbers.contains(0)) exit();
	}
	
	static void exit() {
		try{
			throw new IllegalArgumentException();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
