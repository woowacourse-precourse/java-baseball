package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ComputerTest {
	@DisplayName("랜덤하게 발생시킨 숫자야구 정답 리스트의 크기가 3인지 확인하는 테스트")
	@Test
	void validRandomNumberCountTest() {
		// given : computer 객체가 주어졌을 때
		Computer computer = new Computer();

		// when : 숫자야구 정답 리스트 크기를 구할 때
		List<Integer> answer = computer.generateRandomNumberList();
		int answerSize = answer.size();

		// then : 3개의 원소가 있어야 한다
		final int VALID_ANSWER_SIZE = 3;
		assertThat(answerSize).isEqualTo(VALID_ANSWER_SIZE);
	}

	@ParameterizedTest(name = "정답이{0}이고, 사용자의 입력이 {1}일 때 '{'ball={2}, strike={3}'}' ")
	@MethodSource("generateBallAndStrikeCntInput")
	void countBallAndStrikeTest(List<Integer> answer, String playerBaseballNumber, int expectedBallCnt, int expectedStrikeCnt) {
		/**
		 *	given : computer, player 객체가 주어졌을 때
		 *	computer : 랜덤하게 만든 숫자야구 정답이 answer 로 주어짐
		 *	player : playerBaseballNumber 이라는 숫자야구 입력을 콘솔에 입력한 상황
 		 */
		Computer computer = new Computer() {
			@Override
			public List<Integer> generateRandomNumberList() {
				return answer;
			}
		};
		Player player = new Player();
		player.setCurrentUserAnswer(playerBaseballNumber);

		// when : computer 가 player 의 정답을 비교하여 볼, 스트라이크 개수를 반환한다.
		CompareResultDto compareResultDto = computer.countBallAndStrike(player);

		// then : 그 때 볼, 스트라이크 개수 확인
		assertThat(compareResultDto.getBallCnt()).isEqualTo(expectedBallCnt);
		assertThat(compareResultDto.getStrikeCnt()).isEqualTo(expectedStrikeCnt);
	}

	private static Stream<Arguments> generateBallAndStrikeCntInput() {
		/**
		 * answer list: List
		 * playerBaseballInput: String
		 * expected ball count: int
		 * expected strike count: int
		 */
		return Stream.of(
				Arguments.of(List.of(1, 2, 3), "123", 0, 3),
				Arguments.of(List.of(1, 4, 3), "123", 0, 2),
				Arguments.of(List.of(1, 4, 6), "123", 0, 1),
				Arguments.of(List.of(2, 3, 1), "123", 3, 0),
				Arguments.of(List.of(2, 1, 4), "123", 2, 0),
				Arguments.of(List.of(2, 6, 4), "123", 1, 0),
				Arguments.of(List.of(2, 4, 3), "123", 1, 1),
				Arguments.of(List.of(3, 2, 1), "123", 2, 1),
				Arguments.of(List.of(4, 5, 6), "123", 0, 0)
		);
	}
}