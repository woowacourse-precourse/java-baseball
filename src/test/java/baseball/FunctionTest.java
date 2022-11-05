package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class FunctionTest {

	@Nested
	class ComputerRandomIntegerTest {
		@Test
		void 컴퓨터_랜덤숫자_길이확인() {
			List<Integer> computer = BaseballUtil.getRandomInteger();
			// list 사이즈 확인
			assertThat(computer).hasSize(3);
			// 중복 여부 확인
			for (Integer number : computer) {
				assertThat(computer).containsOnlyOnce(number);
			}
		}
	}
}