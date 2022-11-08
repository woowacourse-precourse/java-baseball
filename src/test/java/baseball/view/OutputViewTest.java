package baseball.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.domain.UserBall;

class OutputViewTest {

	private final OutputView outputView = new OutputView();
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@Test
	void printUserBallStatus() {

		UserBall userBall = UserBall.createUserBall();
		userBall.updateStrikeCount(3);
		userBall.updateStatus();

		outputView.printUserBallStatus(userBall);
		assertThat(outContent.toString()).contains(userBall.createUserBallStatusStringDto());
	}

	@Test
	void printSuccess() {
		outputView.printSuccess();
		assertThat(outContent.toString()).contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
}
