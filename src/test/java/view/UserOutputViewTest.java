package view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.BaseballGameResult;
import baseball.view.UserOutputView;

public class UserOutputViewTest {

	private ByteArrayOutputStream outContent;

	@BeforeEach
	void init() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	@Test
	@DisplayName("사용자에게 0볼 0스트라이크일 때 출력을 테스트")
	void printResultWhenZeroBallAndZeroStrike() {
		// given
		BaseballGameResult result = new BaseballGameResult(0, 0);

		// when
		UserOutputView.printResult(result);

		// then
		assertThat(outContent.toString()).isEqualTo("낫싱\n");
	}

	@Test
	@DisplayName("사용자에게 1볼 1스트라이크일 때 출력을 테스트")
	void printResultWhenOneBallAndOneStrike() {
		// given
		BaseballGameResult result = new BaseballGameResult(1, 1);

		// when
		UserOutputView.printResult(result);

		// then
		assertThat(outContent.toString()).isEqualTo("1볼 1스트라이크\n");
	}
}
