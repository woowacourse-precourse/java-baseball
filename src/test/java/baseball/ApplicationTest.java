package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import User.Input;
import User.Outputs;
import User.Validator;
import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {
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
		List<Integer> result = List.of(Constant.LENGTH_OF_NUMBER, Constant.RESTART_GAME, Constant.END_GAME);
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
