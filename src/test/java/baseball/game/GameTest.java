package baseball.game;

import baseball.playerComputer.PlayerComputer;
import baseball.playerUser.PlayerUser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;



import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

// todo: 테스트코드 작성 다시 시도해보기 <- NsTest의 assertRandomNumberInRangeTest를 이해할 필요있음
public class GameTest extends NsTest {
	private static PlayerComputer computer;
	private static PlayerUser user;
	private static Game game;

	@BeforeAll static void initAll() {
		//		computer = PlayerComputer.getInstance();
		//		user = PlayerUser.getInstance();
		//		game = Game.getInstance();
	}

	// 3스트라이크 테스트
	@Test void gamePrintMsgTest() {
		//		game.play(computer, user);
		//		assertRandomNumberInRangeTest(
		//			() -> {
		//				run(game.randomNumberForTest);
		//				assertThat(output()).contains("3스트라이크", "게임 종료");
		//			},
		//			1, 3, 5, 5, 8, 9
		//		);
	}

	@Override protected void runMain() {
	}
}
