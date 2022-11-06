package baseball.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgeTest {
	final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	final PrintStream standardOut = System.out;

	@BeforeEach
	void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@AfterEach
	void tearDown() {
		System.setOut(standardOut);
	}

	@Test
	@DisplayName("스트라이크인 경우")
	void judgeStrikeTest() {
		int ballCount = 0;
		int strikeCount = 1;
		Judge.judgeStrike(ballCount, strikeCount);

		String result = "1스트라이크";
		assertThat(result).isEqualTo(outputStreamCaptor.toString().trim());
	}
	
	@Test
	@DisplayName("볼인 경우")
	void judgeBallTest() {
		int ballCount = 3;
		int strikeCount = 0;
		Judge.judgeBall(ballCount, strikeCount);

		String result = "3볼";
		assertThat(result).isEqualTo(outputStreamCaptor.toString().trim());
	}

	@Test
	@DisplayName("낫싱인 경우")
	void judgeNothingTest() {
		int ballCount = 0;
		int strikeCount = 0;
		Judge.judgeNothing(ballCount, strikeCount);

		String result = "낫싱";
		assertThat(result).isEqualTo(outputStreamCaptor.toString().trim());
	}

	@Test
	@DisplayName("볼, 스트라이크인 경우")
	void judgeBallAndStrikeTest() {
		int ballCount = 2;
		int strikeCount = 1;
		Judge.judgeBallAndStrike(ballCount, strikeCount);

		String result = "2볼 1스트라이크";
		assertThat(result).isEqualTo(outputStreamCaptor.toString().trim());
	}
}
