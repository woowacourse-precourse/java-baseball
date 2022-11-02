package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ComputerTest {
	@DisplayName("랜덤하게 발생시킨 숫자야구 정답 리스트의 크기가 3인지 확인하는 테스트")
	@Test
	void validRandomNumberCountTest() {
		// given : computer 객체가 주어졌을 때
		Computer computer = new Computer();

		// when : 숫자야구 정답 리스트 크기를 구할 때
		List<Integer> answer = computer.getAnswerList();
		int answerSize = answer.size();

		// then : 3개의 원소가 있어야 한다
		final int VALID_ANSWER_SIZE = 3;
		assertThat(answerSize).isEqualTo(VALID_ANSWER_SIZE);
	}

}