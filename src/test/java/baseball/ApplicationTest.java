package baseball;

import static Controller.Printer.*;
import static baseball.Constant.*;
import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static computer.BallsAndStrikesCountCalculator.*;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import User.Input;
import User.Outputs;
import User.Validator;
import camp.nextstep.edu.missionutils.test.NsTest;
import computer.RandomNumberGenerator;

class ApplicationTest extends NsTest {
	@Test
	void printBallsCountMessage_메소드로_볼_개수_출력() {
		int ballsCount = 3;
		printBallsCount(ballsCount);
		assertThat(output()).isEqualTo("3볼");
	}
	@Test
	void printNothingMessage_메소드로_낫싱_출력() {
		printNothingMessage();
		System.out.print("이 문장은 낫싱 다음 줄에 출력되어야 합니다.");
		assertThat(output()).isEqualTo("낫싱\n이 문장은 낫싱 다음 줄에 출력되어야 합니다.");
	}
	@Test
	void printAskInputMessage_메소드로_숫자_입력_안내_출력() {
		printAskInputMessage();
		System.out.print("이 문장은 숫자 입력 안내 문장과 같은 줄에 출력되어야 합니다.");
		assertThat(output()).isEqualTo("숫자를 입력해주세요 : 이 문장은 숫자 입력 안내 문장과 같은 줄에 출력되어야 합니다.");
	}
	@Test
	void printGameStartMessage_메소드로_게임_시작_안내_출력() {
		printGameStartMessage();
		System.out.print("이 문장은 게임 시작 안내 문장 다음 줄에 출력되어야 합니다.");
		assertThat(output()).isEqualTo("숫자 야구 게임을 시작합니다.\n이 문장은 게임 시작 안내 문장 다음 줄에 출력되어야 합니다.");
	}

	@Test
	void calculateBallsCount_메소드로_볼_수_계산() {
		List<Integer> number = List.of(3, 2, 1);
		List<Integer> answer = List.of(2, 3, 1);
		assertThat(calculateBallsCount(number, answer)).isEqualTo(2);
	}

	@Test
	void calculateStrikesCount_메소드로_스트라이크_수_계산() {
		List<Integer> number = List.of(3, 8, 4);
		List<Integer> answer = List.of(2, 8, 5);
		assertThat(calculateStrikesCount(number, answer)).isEqualTo(1);
	}

	@Test
	void generateRandomNumber_메소드로_서로_다른_세개의_숫자_선택() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		assertThat(randomNumberGenerator.generateRandomNumber()).doesNotHaveDuplicates();
	}

	@Test
	void validateRestartOrNot_메소드로_재시작_여부에_대한_유효하지_않은_입력_예외_처리() {
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
	void getUserInput_메소드로_유저_입력_받기() {
		String input = "768";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		assertThat(Input.getUserInput()).isEqualTo("768");
	}

	@Test
	void print_메소드로_출력할_문자열_리턴() {
		List<String> result = new ArrayList<>();
		for (Outputs output : Outputs.values()) {
			result.add(output.get());
		}
		assertThat(result).containsExactly("숫자 야구 게임을 시작합니다.", "숫자를 입력해주세요 : ", "%d볼", "%d스트라이크", "낫싱",
			"%d개의 숫자를 모두 맞히셨습니다! 게임 종료", "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.");
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
