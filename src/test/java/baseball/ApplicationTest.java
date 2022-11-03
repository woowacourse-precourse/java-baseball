package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {

	@Test
	void 상수_확인() {
		List<Integer> result = List.of(Constant.NUMBER_AMOUNT, Constant.RESTART_GAME, Constant.END_GAME);
		assertThat(result).containsExactly(3, 1, 2);
	}

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
	void 예외_테스트() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("1234"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
