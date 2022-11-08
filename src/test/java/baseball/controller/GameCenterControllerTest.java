package baseball.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.Application;
import baseball.config.GameConfig;
import camp.nextstep.edu.missionutils.test.NsTest;

class GameCenterControllerTest extends NsTest {

	private GameCenterController gameCenterController = new GameConfig().config();

	@DisplayName("GameCenterController 의 startApplication() 테스트1")
	@Test
	void 모든_볼_경우() {
		assertRandomNumberInRangeTest(
			() -> {
				run("513", "153", "317", "157", "135", "2");
				assertThat(output()).contains("3볼", "2볼 1스트라이크", "2볼", "1볼 1스트라이크", "3스트라이크", "게임 종료");
			},
			1, 3, 5
		);
	}

	@DisplayName("GameCenterController 의 startApplication() 테스트2")
	@Test
	void 모든_스트라이크_경우() {
		assertRandomNumberInRangeTest(
			() -> {
				run("153", "137", "153", "157", "135", "2");
				assertThat(output()).contains("2볼 1스트라이크", "2스트라이크", "2볼 1스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
			},
			1, 3, 5
		);
	}

	@ParameterizedTest(name = "exit() 메서드 올바른 입력값 확인 테스트")
	@ValueSource(strings = {"1", "2"})
	void exitTest(String text) {
		InputStream in = new ByteArrayInputStream(text.getBytes());
		System.setIn(in);
		if (text.equals("1")) {
			Assertions.assertThat(gameCenterController.exit()).isFalse();
			return;
		}
		Assertions.assertThat(gameCenterController.exit()).isTrue();
	}

	@ParameterizedTest(name = "exit() 잘못된 입력값 테스트")
	@ValueSource(strings = {"132", "4234", "!!!"})
	void valid_exitTest(String text) {
		InputStream in = new ByteArrayInputStream(text.getBytes());
		System.setIn(in);
		Assertions.assertThatThrownBy(() -> gameCenterController.exit()).isInstanceOf(IllegalArgumentException.class);
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}

}
