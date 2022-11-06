package validator;

import static baseball.constant.Constants.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.validator.BallValidator;

public class BallValidatorTest {

	@Test
	@DisplayName("서로 다른 공 3개의 중복 테스트")
	void validateDifferentBallsDuplicate() {
		// given
		List<Integer> testCase = Arrays.asList(1, 2, 3);

		// when, then
		assertThatCode(() -> BallValidator.validateDuplicate(testCase)).doesNotThrowAnyException();
	}

	@Test
	@DisplayName("중복되는 3개의 공 중복 테스트")
	void validateDuplicateForDuplicateBalls() {
		// given
		List<Integer> testCase = Arrays.asList(2, 2, 1);

		// when, then
		assertThatThrownBy(() -> BallValidator.validateDuplicate(testCase))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("3개의 공이 입력되었을 때 야구 게임 규칙의 개수와 맞는지 테스트")
	void validateFitTheRuleWhenThreeBallsInput() {
		// given
		List<Integer> testCase = Arrays.asList(1, 2, 3);

		// when, then
		assertThatCode(() -> BallValidator.validateNumberOfBalls(testCase)).doesNotThrowAnyException();
	}

	@Test
	@DisplayName("규칙과 다른 공의 개수가 입력되었을 때 예외 테스트")
	void validateFitTheRuleWhenWrongNumberOfBallsInput() {
		// given
		List<Integer> testCase = new ArrayList<>();
		int numberOfBall = 1;
		while (numberOfBall <= NUMBER_OF_BALLS_FOR_BASEBALL_GAME * 2) {
			testCase.add(numberOfBall++);
		}

		// when, then
		assertThatThrownBy(() -> BallValidator.validateNumberOfBalls(testCase))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("사용자의 입력 중에 숫자가 아닌 타입이 입력을 검증하는 테스트")
	void validateInputWhenNotNumeric() {
		// given
		String input = "test123";

		// when, then
		assertThatThrownBy(() -> BallValidator.validateInputIsNumeric(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("사용자의 입력이 모두 정상적으로 숫자일 때 테스트")
	void validateInputWhenAllNumeric() {
		// given
		String input = "123";

		// when, then
		assertThatCode(() -> BallValidator.validateInputIsNumeric(input)).doesNotThrowAnyException();
	}
}
