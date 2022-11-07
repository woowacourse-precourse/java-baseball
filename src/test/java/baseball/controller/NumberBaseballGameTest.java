package baseball.controller;

import org.junit.jupiter.api.Test;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberBaseballGameTest extends NsTest {

	@Test
	void 게임진행_반복_테스트() {
		assertRandomNumberInRangeTest(
			() -> {
				run("246", "431", "135", "2");
				assertThat(output()).contains("낫싱", "1볼 1스트라이크", "3스트라이크");
			},
			1, 3, 5
		);
	}

	@Test
	void 예외_테스트() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("1234"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 재시작_입력_예외_테스트() {
		assertThatThrownBy(() ->
			assertRandomNumberInRangeTest(
				() -> {
					run("135", "0");
					assertThat(output()).contains("3스트라이크");
				},
				1, 3, 5
			)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}