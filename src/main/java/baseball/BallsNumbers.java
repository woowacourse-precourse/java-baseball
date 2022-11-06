package baseball;

import java.util.ArrayList;
import java.util.Random;

public class BallsNumbers {
	static ArrayList<Integer> randomNumbers;
	static ArrayList<Integer> userInputNumbers;
	
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
		Random random = new Random();
		int randomNumber = 0;
		while(isDuplicated(randomNumbers, randomNumber))
			randomNumber = 1 + random.nextInt(8);
		return randomNumber;
	}
	
	public static ArrayList<Integer> makeRandomNumbers() {
		ArrayList<Integer> randomNumbers = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			randomNumbers.add(makeRandomNumber(randomNumbers));
		}
		
		return randomNumbers;
	}
	
}
