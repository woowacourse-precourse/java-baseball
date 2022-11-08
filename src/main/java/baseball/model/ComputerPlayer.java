package baseball.model;

import static baseball.GameRules.*;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

 // 게임 다시 시작할때 초기화 어떻게 할지 고민하기
public class ComputerPlayer {
	private final ArrayList<Integer> numberList;

	public ComputerPlayer() {
		numberList = new ArrayList<>();
		selectNumbers();
	}

	public void selectNumbers() {
		Integer randomNumber;

		while (numberList.size() < DIGIT_NUMBER.getCode()) {
			randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER.getCode(), MAXIMUM_NUMBER.getCode());
			if (!numberList.contains(randomNumber)) {
				numberList.add(randomNumber);
			}
		}
	}

	 public ArrayList<Integer> getNumberList() {
		return numberList;
	 }

}
