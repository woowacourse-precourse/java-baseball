package baseball.controller;

import static baseball.constant.GameConstants.*;
import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;

class GameControllerTest extends NsTest {
	private GameController gameController;
	private OutputStream captor;

	@BeforeEach
	void initialize() {
		gameController = new GameController();
		captor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(captor));
	}

	@Test
	void start_메소드로_게임_시작_안내_출력() {
		//when
		gameController.start();

		//then
		assertThat(captor.toString().trim()).isEqualTo("숫자 야구 게임을 시작합니다.");
	}

	@Test
	void control() {
		assertRandomNumberInRangeTest(() -> {
			//given
			final byte[] buf = String.join("\n", "624", "135", "361", "531", "371").getBytes();
			System.setIn(new ByteArrayInputStream(buf));

			//when
			gameController.control();

			//then
			assertThat(captor.toString().trim()).contains("낫싱", "2볼", "2스트라이크", "1볼 1스트라이크", "3스트라이크");
		}, 3, 7, 1);
	}

	@Test
	void hasRestartRequest_메소드로_게임_재시작_여부_입력_안내_출력() {
		//given
		System.setIn(new ByteArrayInputStream(RESTART_GAME.getBytes()));

		//when
		gameController.hasRestartRequest();

		//then
		assertThat(captor.toString().trim()).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	@Test
	void hasRestartRequest_메소드로_게임_종료_리턴() {
		//given
		System.setIn(new ByteArrayInputStream(END_GAME.getBytes()));

		//when, then
		assertThat(gameController.hasRestartRequest()).isFalse();
	}

	@Test
	void hasRestartRequest_메소드로_게임_재시작_리턴() {
		//given
		System.setIn(new ByteArrayInputStream(RESTART_GAME.getBytes()));

		//when, then
		assertThat(gameController.hasRestartRequest()).isTrue();
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}