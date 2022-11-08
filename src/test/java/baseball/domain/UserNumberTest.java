package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserNumberTest {

	@Test
	void 입력_길이_초과_예외_테스트() {
		String input = "1234";
		assertThrows(IllegalArgumentException.class, () -> {
			new UserNumber(input);
		});
	}

	@Test
	void 숫자_외_문자_예외_테스트() {
		String input = "1~3";
		assertThrows(IllegalArgumentException.class, () -> {
			new UserNumber(input);
		});
	}

	@Test
	void 숫자_중복_예외_테스트() {
		String input = "333";
		assertThrows(IllegalArgumentException.class, () -> {
			new UserNumber(input);
		});
	}

	@Test
	void 숫자_제대로_받는지_확인() {
		String input = "123";
		int[] nums = {1, 2, 3};

		int[] userNums = new UserNumber(input).getUserNumber().stream().mapToInt(num -> num).toArray();

		assertArrayEquals(nums, userNums);
	}
}
