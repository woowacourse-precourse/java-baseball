package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
	@Nested
	class assertComputerInRangeTest {
		@Test
		void 게임종료_후_재시작() {
			assertRandomNumberInRangeTest(
				() -> {
					run("246", "135", "1", "597", "589", "2");
					assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
				},
				1, 3, 5, 5, 8, 9
			);
		}

		@Test
		void 한_게임_후_게임종료() {
			assertRandomNumberInRangeTest(
				() -> {
					run("123", "456", "789", "164", "174", "2");
					assertThat(output()).contains("1볼", "1볼", "1볼", "2스트라이크", "3스트라이크", "게임 종료");
				},
				1, 7, 4
			);
		}
	}

	@Nested
	class assertSimpleTest {
		@Test
		@DisplayName("정해진 숫자의 개수보다 많을때")
		void 예외_테스트() {
			assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("1234"))
					.isInstanceOf(IllegalArgumentException.class)
			);
		}

		@Test
		@DisplayName("공백이 포함될때")
		void 예외_테스트2() {
			assertSimpleTest(() ->
				assertThatThrownBy(() -> runException(" 123"))
					.isInstanceOf(IllegalArgumentException.class)
			);
		}

		@Test
		@DisplayName("정해진 숫자의 개수보다 적을때")
		void 예외_테스트3() {
			assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("16"))
					.isInstanceOf(IllegalArgumentException.class)
			);
		}

		@Test
		@DisplayName("중복된 숫자가 포함될때")
		void 예외_테스트4() {
			assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("868"))
					.isInstanceOf(IllegalArgumentException.class)
			);
		}
	}

	@Override
	public void runMain() {
		Application.main(new String[]{});
	}
}
