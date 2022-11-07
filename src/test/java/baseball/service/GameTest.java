package baseball.service;

import baseball.domain.Opponent;
import baseball.domain.Player;
import baseball.domain.StrikeAndBall;
import baseball.util.RandomUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

	@Test
	@DisplayName("플레이어의 잘못된 입력시 예외 발생이 되는지 확인")
	void 플레이어_입력_예외_확인() {
		Game game = new Game();
		String[] testString1 = new String[] {"7", "0", "5"};
		String[] testString2 = new String[] {"@", "3", "5"};
		String[] testString3 = new String[] {"6", "a", "5"};
		String[] testString4 = new String[] {"6", "4", "5", "7"};
		String[] testString5 = new String[] {"6", "4"};
		String[] testString6 = new String[] {"2", "4", "4"};

		assertThatThrownBy(() ->
				game.checkInput(testString1))
						.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() ->
				game.checkInput(testString2))
						.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() ->
				game.checkInput(testString3))
						.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() ->
				game.checkInput(testString4))
						.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() ->
				game.checkInput(testString5))
						.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() ->
				game.checkInput(testString6))
						.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 볼과_스트라이크_판정_확인() {
		Opponent opponent = new Opponent(List.copyOf(RandomUtil.getRandomUniqueNumbers(1, 9, 3)));
		List<Integer> opponentAnswer = opponent.getAnswerNumbers();

		Player player1 = new Player(List.of(opponentAnswer.get(0), opponentAnswer.get(2), opponentAnswer.get(1)));
		Player player2 = new Player(List.of(opponentAnswer.get(0), opponentAnswer.get(1), opponentAnswer.get(2)));
		List<Integer> tempPlayerNumbers = new ArrayList<>();
		for (int num : new int[]{1,2,3,4,5,6,7,8,9}) {
			if (tempPlayerNumbers.size() == 3) {
				break;
			}
			if (!opponentAnswer.contains(num)) {
				tempPlayerNumbers.add(num);
			}
		}
		Player player3 = new Player(tempPlayerNumbers);

		Game game1 = new Game(player1, opponent, new StrikeAndBall(0, 0));
		Game game2 = new Game(player2, opponent, new StrikeAndBall(0, 0));
		Game game3 = new Game(player3, opponent, new StrikeAndBall(0, 0));


		game1.judgeStrikeAndBallCount();
		assertThat(game1.strikeAndBall.getBall()).isEqualTo(2);
		assertThat(game1.strikeAndBall.getStrike()).isEqualTo(1);

		game2.judgeStrikeAndBallCount();
		assertThat(game2.strikeAndBall.getBall()).isEqualTo(0);
		assertThat(game2.strikeAndBall.getStrike()).isEqualTo(3);

		game3.judgeStrikeAndBallCount();
		assertThat(game3.strikeAndBall.getBall()).isEqualTo(0);
		assertThat(game3.strikeAndBall.getStrike()).isEqualTo(0);
	}
}
