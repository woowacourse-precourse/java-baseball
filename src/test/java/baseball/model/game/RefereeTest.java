package baseball.model.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RefereeTest {
	Referee referee = new Referee();

	@DisplayName("결과 출력 기능을 확인한다 : 낫싱")
	@Test
	void canPrintAnswerMessageCase1() {
		Rule.STRIKE = 0;
		Rule.BALL = 0;
		String answer = "낫싱";
		assertEquals(referee.getMessage(), answer);
	}

	@DisplayName("결과 출력 기능을 확인한다 : 1볼 1스트라이크")
	@Test
	void canPrintAnswerMessageCase2() {
		Rule.STRIKE = 1;
		Rule.BALL = 1;
		String answer = "1볼 1스트라이크";
		assertEquals(referee.getMessage(), answer);
	}

	@DisplayName("결과 출력 기능을 확인한다 : 1볼")
	@Test
	void canPrintAnswerMessageCase3() {
		Rule.STRIKE = 0;
		Rule.BALL = 1;
		String answer = "1볼";
		assertEquals(referee.getMessage(), answer);
	}

	@DisplayName("결과 출력 기능을 확인한다 : 2스트라이크")
	@Test
	void canPrintAnswerMessageCase4() {
		Rule.STRIKE = 2;
		Rule.BALL = 0;
		String answer = "2스트라이크";
		assertEquals(referee.getMessage(), answer);
	}
}
