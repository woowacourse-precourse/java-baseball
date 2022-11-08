package baseball.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.config.GameConfig;

class GameCenterControllerTest {

	private GameCenterController gameCenterController = new GameConfig().config();

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

}
