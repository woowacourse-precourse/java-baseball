package baseball;

import static baseball.constant.GameConstants.*;
import static baseball.util.Converter.*;
import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import baseball.constant.ViewConstants;
import baseball.controller.GameController;
import baseball.domain.NumberComparator;
import baseball.util.Converter;
import baseball.util.RandomNumberGenerator;
import baseball.util.Validator;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {
	private final OutputView outputView = new OutputView();

	@Test
	void restart_메소드로_게임_재시작_여부_리턴() {
		GameController gameController = new GameController();
		System.setIn(new ByteArrayInputStream(END_GAME.getBytes()));
		assertThat(gameController.askRestart()).isFalse();
		assertThat(output()).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

		System.setIn(new ByteArrayInputStream(RESTART_GAME.getBytes()));
		assertThat(gameController.askRestart()).isTrue();

	}

	@Test
	void control_메소드로_게임_실행() {
		assertRandomNumberInRangeTest(() -> {
			final byte[] buf = String.join("\n", "624", "135", "361", "531", "371").getBytes();
			System.setIn(new ByteArrayInputStream(buf));
			GameController gameController = new GameController();
			gameController.control();
			assertThat(output()).contains("낫싱", "2볼", "2스트라이크", "1볼 1스트라이크", "3스트라이크");
		}, 3, 7, 1);
	}

	@Test
	void Comparator_클래스로_정답과_입력을_비교하는_기능_구현() {
		List<Integer> answer = List.of(4, 9, 2);
		NumberComparator numberComparator = new NumberComparator(answer);
		String wrongInput = "283";
		System.setIn(new ByteArrayInputStream(wrongInput.getBytes()));
		List<Integer> digits1 = Converter.convertStringToIntegerList(wrongInput);
		numberComparator.compare(digits1);
		assertThat(numberComparator.isCorrect()).isFalse();

		String rightInput = "492";
		System.setIn(new ByteArrayInputStream(rightInput.getBytes()));
		List<Integer> digits2 = Converter.convertStringToIntegerList(rightInput);
		numberComparator.compare(digits2);
		assertThat(numberComparator.isCorrect()).isTrue();
	}

	@Test
	void convertStringToIntegerList_메소드로_문자열을_정수_리스트로_변환() {
		assertThat(convertStringToIntegerList("746")).isInstanceOf(ArrayList.class);
	}

	@Test
	void printGettingRightAnswerMessage_메소드로_정답을_맞춘_경우_게임_종료를_안내() {
		outputView.printGettingRightAnswerMessage(LENGTH_OF_NUMBER);
		System.out.print("이 문장은 다음 줄에 출력되어야 합니다.");
		assertThat(output()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n이 문장은 다음 줄에 출력되어야 합니다.");
	}

	@Test
	void printResult_메소드로_결과_안내_출력() {
		outputView.printResult(0, 0);
		outputView.printResult(2, 0);
		outputView.printResult(0, 1);
		outputView.printResult(1, 2);
		System.out.print("이 문장은 다음 줄에 출력되어야 합니다.");
		assertThat(output()).isEqualTo("낫싱\n2볼\n1스트라이크\n1볼 2스트라이크\n이 문장은 다음 줄에 출력되어야 합니다.");
	}

	@Test
	void printStrikesCountMessage_메소드로_스트라이크_개수_출력() {
		int strikesCount = 2;
		outputView.printStrikesCountMessage(strikesCount);
		assertThat(output()).isEqualTo("2스트라이크");
	}

	@Test
	void printBallsCountMessage_메소드로_볼_개수_출력() {
		int ballsCount = 3;
		outputView.printBallsCountMessage(ballsCount);
		assertThat(output()).isEqualTo("3볼");
	}

	@Test
	void printNothingMessage_메소드로_낫싱_출력() {
		outputView.printNothingMessage();
		System.out.print("이 문장은 낫싱 다음 줄에 출력되어야 합니다.");
		assertThat(output()).isEqualTo("낫싱\n이 문장은 낫싱 다음 줄에 출력되어야 합니다.");
	}

	@Test
	void printGameStartMessage_메소드로_게임_시작_안내_출력() {
		outputView.printGameStartMessage();
		System.out.print("이 문장은 게임 시작 안내 문장 다음 줄에 출력되어야 합니다.");
		assertThat(output()).isEqualTo("숫자 야구 게임을 시작합니다.\n이 문장은 게임 시작 안내 문장 다음 줄에 출력되어야 합니다.");
	}

	@Test
	void generateRandomNumber_메소드로_서로_다른_세개의_숫자_선택() {
		assertThat(RandomNumberGenerator.generateRandomNumber()).doesNotHaveDuplicates();
	}

	@Test
	void validateRestartOrNotInput_메소드로_재시작_여부에_대한_유효하지_않은_입력_예외_처리() {
		String input = "3";
		assertThatThrownBy(() -> Validator.validateRestartOrNotInput(input)).isInstanceOf(
			IllegalArgumentException.class);
	}

	@Test
	void haveInvalidLength_메소드로_유효하지_않은_길이의_입력에_대한_예외_처리() {
		String input = "1243";
		assertThatThrownBy(() -> Validator.validateNumberInput(input)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void existInvalidLetter_메소드로_유효하지_않은_글자를_입력하는_예외_처리() {
		String input = "2a3";
		assertThatThrownBy(() -> Validator.validateNumberInput(input)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void existDuplicateNumber_메소드로_중복된_숫자를_입력하는_예외_처리() {
		String input = "233";
		assertThatThrownBy(() -> Validator.validateNumberInput(input)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void print_메소드로_출력할_문자열_리턴() {
		List<String> result = new ArrayList<>();
		for (ViewConstants output : ViewConstants.values()) {
			result.add(output.get());
		}
		assertThat(result).containsExactly("숫자 야구 게임을 시작합니다.", "숫자를 입력해주세요 : ", "%d볼", "%d스트라이크", "낫싱",
			"%d개의 숫자를 모두 맞히셨습니다! 게임 종료", "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.");
	}

	@Test
	void 상수_확인() {
		List<Integer> result = List.of(LENGTH_OF_NUMBER, Integer.parseInt(RESTART_GAME), Integer.parseInt(END_GAME));
		assertThat(result).containsExactly(3, 1, 2);
	}

	@Test
	void 게임종료_후_재시작() {
		assertRandomNumberInRangeTest(() -> {
			run("246", "135", "1", "597", "589", "2");
			assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
		}, 1, 3, 5, 5, 8, 9);
	}

	@Test
	void 예외_테스트() {
		assertSimpleTest(
			() -> assertThatThrownBy(() -> runException("1234")).isInstanceOf(IllegalArgumentException.class));
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
