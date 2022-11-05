package baseball.game;

import baseball.playerComputer.PlayerComputer;
import baseball.playerUser.PlayerUser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
	private static PlayerComputer computer;
	private static PlayerUser user;
	private static Game game;
	private static final String msg1 = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임종료";

	@BeforeAll static void initAll() {
		computer = PlayerComputer.getInstance();
		user = PlayerUser.getInstance();
		game = Game.getInstance();
	}

	// 3스트라이크 테스트
	@Test void gamePrintMsgTest() {
		String answer = computer.getRandomNumber();
		String input = answer;

		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		game.play();

		Assertions.assertThat(msg1).isEqualTo(out.toString());
	}
}
