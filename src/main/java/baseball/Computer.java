package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	private ArrayList<Integer> targetNumber;

	Computer(ArrayList<Integer> targetNumber){
		this.targetNumber = targetNumber;
	}

	public ArrayList<Integer> getTargetNumber() {
		return targetNumber;
	}

	public void generateNumber(){
		targetNumber = new ArrayList<>();
		while (targetNumber.size() < Constant.NUMBER_LENGTH.getNumber()) {
			int randomNumber = Randoms.pickNumberInRange(
				Constant.MIN_VALUE.getNumber(), Constant.MAX_VALUE.getNumber()
			);
			if (!targetNumber.contains(randomNumber)) {
				targetNumber.add(randomNumber);
			}
		}
	}
}
