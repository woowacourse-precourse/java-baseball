package baseball.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.domain.GameResult;

class OutputViewTest {

	private static ByteArrayOutputStream outputMessage;

	@BeforeEach
	void setUpStreams() {
		outputMessage = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputMessage));
	}

	@AfterEach
	void restoresStreams() {
		System.setOut(System.out);
	}

	@Test
	void 정상적으로_결과_출력하는지_확인() {
		List<Integer> comNums = List.of(1, 2, 3);
		List<Integer> userNums = List.of(1, 2, 3);

		GameResult gameResult = new GameResult(comNums, userNums);
		new OutputView(gameResult).printGameResult();
		String output = "3스트라이크\n";

		assertEquals(output, outputMessage.toString());
	}

	@Test
	void 정상적으로_결과_출력하는지_확인2() {
		List<Integer> comNums = List.of(1, 3, 2);
		List<Integer> userNums = List.of(1, 2, 3);

		GameResult gameResult = new GameResult(comNums, userNums);
		new OutputView(gameResult).printGameResult();
		String output = "2볼 1스트라이크\n";

		assertEquals(output, outputMessage.toString());
	}

	@Test
	void 정상적으로_결과_출력하는지_확인3() {
		List<Integer> comNums = List.of(3, 1, 2);
		List<Integer> userNums = List.of(1, 2, 3);

		GameResult gameResult = new GameResult(comNums, userNums);
		new OutputView(gameResult).printGameResult();
		String output = "3볼 \n";

		assertEquals(output, outputMessage.toString());
	}

	@Test
	void 정상적으로_결과_출력하는지_확인4() {
		List<Integer> comNums = List.of(4, 5, 6);
		List<Integer> userNums = List.of(1, 2, 3);

		GameResult gameResult = new GameResult(comNums, userNums);
		new OutputView(gameResult).printGameResult();
		String output = "낫싱\n";

		assertEquals(output, outputMessage.toString());
	}
}
