package baseball.service;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.restrict.RestrictIntegerConstants;
import camp.nextstep.edu.missionutils.test.NsTest;

class BaseballGameServiceImplTest extends NsTest implements RestrictIntegerConstants {

	private static final GameService baseballGameService = new BaseballGameServiceImpl();

	@Override
	protected void runMain() {
		baseballGameService.restartGame();
	}

	@Test
	void startGameTest() {
		assertRandomNumberInRangeTest(
			() -> {
				run("123", "965", "178", "597", "589", "2");
				assertThat(output()).contains("낫싱", "2볼", "1볼", "1볼 1스트라이크", "3스트라이크", "게임 종료");
			},
			5, 8, 9
		);
	}

	@Test
	void restartGameTest() {
		assertRandomNumberInRangeTest(
			() -> {
				run("123", "965", "178", "597", "589", "1", "123", "2");
				assertThat(output()).contains("낫싱", "2볼", "1볼", "1볼 1스트라이크", "3스트라이크", "게임 종료", "3스트라이크", "게임 종료");
			},
			5, 8, 9, 1, 2, 3
		);
	}
}
