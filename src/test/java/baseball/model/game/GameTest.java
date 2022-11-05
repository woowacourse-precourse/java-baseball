package baseball.model.game;

import baseball.controller.computer.Computer;
import baseball.controller.user.User;
import baseball.model.data.Data;
import baseball.view.Output;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
	Game game = new Game();
	Calculation calculation = new Calculation();
	Rule rule = new Rule();
	Judge judge = new Judge();
	Data data = new Data();


	@DisplayName("스트라이크를 확인한다")
	@Test
	void verifyStrike() {
		assertThat(rule.isStrike(2, 1, 2, 1)).isTrue();
	}

	@DisplayName("볼을 확인한다")
	@Test
	void verifyBall() {
		assertThat(rule.isBall(6, 5, 6, 2)).isTrue();
	}



	@DisplayName("LinkedHashMap에서 key 값을 꺼내는 기능을 확인한다")
	@Test
	void canExtractKey() {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>() {
			{
				put(1, 0);
				put(2, 1);
				put(3, 2);
			}
		};
		assertThat(data.extractNumber(map, 0)).isEqualTo(1);
	}

	@DisplayName("LinkedHashMap에서 value 값을 꺼내는 기능을 확인한다")
	@Test
	void canExtractValue() {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>() {
			{
				put(1, 0);
				put(2, 1);
				put(3, 2);
			}
		};
		assertThat(data.extractIndex(map, 0)).isEqualTo(0);
	}



	@DisplayName("결과 출력 기능을 확인한다 : 낫싱")
	@Test
	void canPrintAnswerMessageCase1() {
		rule.STRIKE = 0;
		rule.BALL = 0;
		String answer = "낫싱";
		assertEquals(judge.getMessage(), answer);
	}

	@DisplayName("결과 출력 기능을 확인한다 : 1볼 1스트라이크")
	@Test
	void canPrintAnswerMessageCase2() {
		rule.STRIKE = 1;
		rule.BALL = 1;
		String answer = "1볼 1스트라이크";
		assertEquals(judge.getMessage(), answer);
	}

	@DisplayName("결과 출력 기능을 확인한다 : 1볼")
	@Test
	void canPrintAnswerMessageCase3() {
		rule.STRIKE = 0;
		rule.BALL = 1;
		String answer = "1볼";
		assertEquals(judge.getMessage(), answer);
	}

	@DisplayName("결과 출력 기능을 확인한다 : 2스트라이크")
	@Test
	void canPrintAnswerMessageCase4() {
		rule.STRIKE = 2;
		rule.BALL = 0;
		String answer = "2스트라이크";
		assertEquals(judge.getMessage(), answer);
	}

}
