package utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerInputUtilTest {

	@Test
	@DisplayName("야구공 3개 미만 입력 예외케이스")
	void 플레이어입력_예외_테스트() {
		// given, when
		String twoLengthBall = "12";
		String oneLengthBall = "9";
		String zeroLengthBall = "";
		// then
		assertThatThrownBy(() -> PlayerInputUtil.checkLessThanThreeExecption(twoLengthBall))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> PlayerInputUtil.checkLessThanThreeExecption(oneLengthBall))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> PlayerInputUtil.checkLessThanThreeExecption(zeroLengthBall))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("야구공 3개 초과 입력 예외케이스")
	void 플레이어입력_예외_테스트2() {
		// given, when
		String fourLengthBall = "1234";
		String tenLengthBall = "1234567890";
		// then
		assertThatThrownBy(() -> PlayerInputUtil.checkMoreThanThreeException(fourLengthBall))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> PlayerInputUtil.checkMoreThanThreeException(tenLengthBall))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("야구공 숫자가 아닌 입력 예외케이스")
	void 플레이어입력_예외_테스트3() {
		// given, when
		String nonNumericBallOne = "1-2";
		String nonNumericBallTwo = "가12";
		String nonNumericBallThree = "1!";
		String zeroBall = "210";
		// then
		assertThatThrownBy(() -> PlayerInputUtil.checkOutOfRangeException(nonNumericBallOne))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> PlayerInputUtil.checkOutOfRangeException(nonNumericBallTwo))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> PlayerInputUtil.checkOutOfRangeException(nonNumericBallThree))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> PlayerInputUtil.checkOutOfRangeException(zeroBall))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("야구공 중복 숫자 입력 예외케이스")
	void 플레이어입력_예외_테스트4() {
		// given, when
		String duplicateBallOne = "112";
		String duplicateBallTwo = "525";
		String duplicateBallThree = "677";
		String duplicateBallFour = "777";
		// then
		assertThatThrownBy(() -> PlayerInputUtil.checkDuplicateBallsException(duplicateBallOne))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> PlayerInputUtil.checkDuplicateBallsException(duplicateBallTwo))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> PlayerInputUtil.checkDuplicateBallsException(duplicateBallThree))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> PlayerInputUtil.checkDuplicateBallsException(duplicateBallFour))
				.isInstanceOf(IllegalArgumentException.class);
	}

}
