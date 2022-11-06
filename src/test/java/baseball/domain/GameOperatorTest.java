package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.constants.GuideSentences;
import baseball.testhelper.ComparingResultExample;

public class GameOperatorTest {
	GameOperator gameOperator = new GameOperator();

	@Test
	@DisplayName("숫자 야구 게임 테스트")
	void numberBaseballGameTest() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		setCommand();
		setExpected();

		InputStream inputStream = new ByteArrayInputStream(command.getBytes());
		System.setIn(inputStream);

		gameOperator.numberBaseballGame();

		assertThat(out.toString()).isEqualTo(expected);

		System.setOut(System.out);
	}

	String command = "";
	String expected = "";
	String oneBall = ComparingResultExample.ONE_BALL.getNumbers()
			.toString().replaceAll("[^1-9]", "");
	String threeStrike = ComparingResultExample.THREE_STRIKE.getNumbers()
			.toString().replaceAll("[^1-9]", "");

	void setCommand() {
		List<String> commandList = new ArrayList<>();

		// 실행 예시 ComparingResultExample 의 1볼, 3스트라이크 커맨드 입력 저장
		commandList.add(oneBall);
		commandList.add(threeStrike);

		// 재시작 기능 확인을 위해 아래와 같이 커맨드 입력
		// 1 -> 3스트라이크 숫자 -> 2
		commandList.add("1");
		commandList.add(threeStrike);
		commandList.add("2");

		command = String.join("\n", commandList);
	}

	void setExpected() {
		List<String> expectedList = new ArrayList<>();

		// 시작 안내문 출력
		expectedList.add(GuideSentences.START_GUIDE.getSentence());

		// 커맨드 입력 "1볼, 3스트라이크"에 맞추어 '입력 안내문'과 '비교 결과' 출력
		expectedList.add(GuideSentences.INPUT_GUIDE.getSentence() + oneBall);
		String oneBallResult = ComparingResultExample.ONE_BALL.getResultSentence();
		expectedList.add(oneBallResult);

		expectedList.add(GuideSentences.INPUT_GUIDE.getSentence() + threeStrike);
		String threeStrikeResult = ComparingResultExample.THREE_STRIKE.getResultSentence();
		expectedList.add(threeStrikeResult);

		// 게임 종료 안내문 및 재시작 여부
		expectedList.add(GuideSentences.END_GUIDE.getSentence());
		expectedList.add(GuideSentences.RESTART_GUIDE.getSentence());

		// 재시작 -> 3스트라이크 -> 종료
		expectedList.add("1");
		expectedList.add(GuideSentences.INPUT_GUIDE.getSentence() + threeStrike);
		expectedList.add(GuideSentences.END_GUIDE.getSentence());
		expectedList.add(GuideSentences.RESTART_GUIDE.getSentence());
		expectedList.add("2");

		expected = String.join("\n", expectedList);
	}
}
