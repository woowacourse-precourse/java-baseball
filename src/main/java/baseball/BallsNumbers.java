package baseball;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class BallsNumbers {
    static ArrayList<Integer> randomNumbers;  //Computers Balls Numbers
    static ArrayList<Integer> userInputNumbers;  //User Balls Numbers
	
    //Computers Balls Numbers
    @SuppressWarnings("unchecked")
    private static boolean isDuplicated(ArrayList<Integer> randomNumbers, int randomNumber) {
        if(randomNumber == 0) return true;
		ArrayList<Integer> randomNumbersAddedRandomNumber = (ArrayList<Integer>)randomNumbers.clone();
		randomNumbersAddedRandomNumber.add(randomNumber);
		if(randomNumbers.size() != randomNumbersAddedRandomNumber.stream().distinct().count()) {
			return false;
		}
		return true;
	}
	
	private static int makeRandomNumber(ArrayList<Integer> randomNumbers) {
		int randomNumber = 0;
		while(isDuplicated(randomNumbers, randomNumber))
			randomNumber = Randoms.pickNumberInRange(1, 9);
		return randomNumber;
	}
	
	public static ArrayList<Integer> makeRandomNumbers() {
		ArrayList<Integer> randomNumbers = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			randomNumbers.add(makeRandomNumber(randomNumbers));
		}
		
		return randomNumbers;
	}
	
	//User Balls Numbers
	public static ArrayList<Integer> makeUserInputNumbers(int inputNum) {
		ArrayList<Integer> userInputNumbers = new ArrayList<>();
		int num = inputNum;
		while(num != 0) {
			userInputNumbers.add(0, num % 10);
			num /= 10;
		}
		return  userInputNumbers;
	}
}
