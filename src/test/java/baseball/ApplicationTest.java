package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import baseball.count.Game;
import baseball.player.User;
import baseball.service.Exception;
import baseball.service.GameService;
import baseball.view.SystemMessage;
import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {
	Game game = new Game();
	Exception exception = new Exception();
	GameService service = new GameService();
	User user = new User();
	SystemMessage systemMessage = new SystemMessage();
	Controller controller = new Controller();

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

	@Test
	void 사용자_숫자_생성() {
		int[] userNumber = new int[] {1, 2, 3};
		user.setUserNumber(userNumber);
		assertThat(3).isEqualTo(user.userSize());
	}

	@Test
	void 컴퓨터_숫자_생성() {
		service.ramdomNumberSetting();
		assertThat(3).isEqualTo(service.computerSize());
	}

	@Test
	void 컴퓨터와_사용자의_숫자비교_후_카운트() {
		int[] userNumber = new int[] {1, 2, 3};
		user.setUserNumber(userNumber);
		service.compare(user, Arrays.asList(1, 2, 3));
		assertThat(3).isEqualTo(service.strikeCount());
	}

	@Test
	void 사용자의_숫자를_지움() {
		int[] userNumber = new int[] {1, 2, 3};
		user.setUserNumber(userNumber);
		user.userReset();
		assertThat(0).isEqualTo(user.userSize());
	}

	@Test
	void 스트라이크_볼_카운트를_초기화() {
		game.strikeAdd();
		game.gameSetting();
		assertThat(0).isEqualTo(game.getStrikeCount());
	}

}