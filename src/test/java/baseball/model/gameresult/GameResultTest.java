package baseball.model.gameresult;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameResultTest {

	@Test
	public void 게임_결과_출력_테스트_낫싱() {
		//given
		GameResult gameResult = new GameResult();

		//when
		gameResult.addSingleResult(SingleResultType.NOTHING);
		gameResult.addSingleResult(SingleResultType.NOTHING);
		gameResult.addSingleResult(SingleResultType.NOTHING);

		//then
		Assertions.assertThat(gameResult.toString()).isEqualTo("낫싱");
	}

	@Test
	public void 게임_결과_출력_테스트_볼_스트라이크() {
		//given
		GameResult gameResult = new GameResult();

		//when
		gameResult.addSingleResult(SingleResultType.NOTHING);
		gameResult.addSingleResult(SingleResultType.BALL);
		gameResult.addSingleResult(SingleResultType.STRIKE);

		//then
		Assertions.assertThat(gameResult.toString()).isEqualTo("1볼 1스트라이크");
	}

	@Test
	public void 게임_결과_출력_테스트_볼() {
		//given
		GameResult gameResult = new GameResult();

		//when
		gameResult.addSingleResult(SingleResultType.NOTHING);
		gameResult.addSingleResult(SingleResultType.BALL);
		gameResult.addSingleResult(SingleResultType.BALL);

		//then
		Assertions.assertThat(gameResult.toString()).isEqualTo("2볼");
	}

}