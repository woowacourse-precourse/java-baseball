package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import User.Outputs;
import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {
	@Test
	void print_메소드로_출력할_문자열_리턴() {
		List<String> result = new ArrayList<>();
		for (Outputs output : Outputs.values()) {
			result.add(output.print());
		}
		assertThat(result).containsExactly("숫자 야구 게임을 시작합니다.", "숫자를 입력해주세요 : ", "%d볼", "%d스트라이크", "낫싱",
			"%d개의 숫자를 모두 맞히셨습니다! 게임 종료", "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.");
	}

	@Test
	void 상수_확인() {
		List<Integer> result = List.of(Constant.NUMBER_AMOUNT, Constant.RESTART_GAME, Constant.END_GAME);
		assertThat(result).containsExactly(3, 1, 2);
	}

	@Test
	void 게임종료_후_재시작() {
		assertRandomNumberInRangeTest(
			() -> {
				run("246", "135", "1", "597", "589", "2");
				assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
			},
			1, 3, 5, 5, 8, 9
		);
	}

	@Test
	void 예외_테스트() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("1234"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
