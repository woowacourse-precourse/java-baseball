package baseball.domain;

import java.util.ArrayList;

import baseball.constants.Constants;
import camp.nextstep.edu.missionutils.Randoms;

// 랜덤한 숫자 3자리 문자 구현
public class Computer {
	
	public ArrayList<Integer> setComputerNumber() {
		ArrayList<Integer> computerNumber = new ArrayList<>();
		computerNumber = makeComputerNumber(computerNumber);
		return computerNumber;
	}
	
	public static ArrayList<Integer> makeComputerNumber(ArrayList<Integer> computerNumber) {
		while(computerNumber.size() < Constants.NUMBER_MAX_LENGTH) {
			randomNumberInList(randomNumber(), computerNumber);
		}
		return computerNumber;
	}
	
	public static void randomNumberInList(Integer number, ArrayList<Integer> computerNumber) {
		if(computerNumber.contains(number) == false) {
			computerNumber.add(number);
		}
	}
	
	public static Integer randomNumber() {
		return Randoms.pickNumberInRange(Constants.MIN_RANGE, Constants.MAX_RANGE);
	}
}
