package baseball;

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
		int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER.getValue(), MAXIMUM_NUMBER.getValue());
		while (numberList.size() < DIGIT_NUMBER.getValue()) {
			if (!numberList.contains(randomNumber)) {
				numberList.add(randomNumber);
			}
		}
	}

}
