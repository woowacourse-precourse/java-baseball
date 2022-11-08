package baseball.view;

import static baseball.constant.GameConstants.*;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {
	OutputView outputView;
	private OutputStream captor;

	@BeforeEach
	void init() {
		outputView = new OutputView();
		captor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(captor));
	}

	String output() {
		return captor.toString().trim();
	}

	@Test
	void printGettingRightAnswerMessage_메소드로_정답을_맞춘_경우_게임_종료를_안내() {
		//when
		outputView.printFinishingGameMessage(LENGTH_OF_NUMBER);
		System.out.print("이 문장은 다음 줄에 출력되어야 합니다.");

		//then
		assertThat(output()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n이 문장은 다음 줄에 출력되어야 합니다.");
	}

	@Test
	void printResult_메소드로_결과_안내_출력() {
		//given, when
		outputView.printResult(0, 0);
		outputView.printResult(2, 0);
		outputView.printResult(0, 1);
		outputView.printResult(1, 2);
		System.out.print("이 문장은 다음 줄에 출력되어야 합니다.");

		//then
		assertThat(output()).isEqualTo("낫싱\n2볼\n1스트라이크\n1볼 2스트라이크\n이 문장은 다음 줄에 출력되어야 합니다.");
	}

	@Test
	void printStrikesCountMessage_메소드로_스트라이크_개수_출력() {
		//given
		int strikesCount = 2;

		//when
		outputView.printStrikesCountMessage(strikesCount);

		//then
		assertThat(output()).isEqualTo("2스트라이크");
	}

	@Test
	void printBallsCountMessage_메소드로_볼_개수_출력() {
		//given
		int ballsCount = 3;

		//when
		outputView.printBallsCountMessage(ballsCount);

		//then
		assertThat(output()).isEqualTo("3볼");
	}

	@Test
	void printNothingMessage_메소드로_낫싱_출력() {
		//when
		outputView.printNothingMessage();
		System.out.print("이 문장은 낫싱 다음 줄에 출력되어야 합니다.");

		//then
		assertThat(output()).isEqualTo("낫싱\n이 문장은 낫싱 다음 줄에 출력되어야 합니다.");
	}

	@Test
	void printGameStartMessage_메소드로_게임_시작_안내_출력() {
		//when
		outputView.printGameStartMessage();
		System.out.print("이 문장은 게임 시작 안내 문장 다음 줄에 출력되어야 합니다.");

		//then
		assertThat(output()).isEqualTo("숫자 야구 게임을 시작합니다.\n이 문장은 게임 시작 안내 문장 다음 줄에 출력되어야 합니다.");
	}
}