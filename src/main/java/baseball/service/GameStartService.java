package baseball.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class GameStartService {

	//Todo: 정답 숫자 만들기
	public List<Integer> makeAnswerNumber() {
		List<Integer> answer = new ArrayList<>();
		while (answer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!answer.contains(randomNumber)) {
				answer.add(randomNumber);
			}
		}
		//inputview 에서 게임 시작 출력문 출력
		return answer;
	}

}
