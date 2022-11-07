package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Arrays;

class ApplicationTest extends NsTest {
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

	@Test
	void 플레이어_빈_값_입력() {
		String input = "";
		assertThatThrownBy(() -> Application.getPlayerNumbers(input)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 플레이어_띄어쓰기_입력() {
		String input = " ";
		assertThatThrownBy(() -> Application.getPlayerNumbers(input)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 플레이어_문자_입력() {
		String input = "ㅇ";
		assertThatThrownBy(() -> Application.getPlayerNumbers(input)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 플레이어_숫자_0_입력() {
		String input = "012";
		assertThatThrownBy(() -> Application.getPlayerNumbers(input)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 플레이어_숫자_4자리_입력() {
		String input = "1234";
		assertThatThrownBy(() -> Application.getPlayerNumbers(input)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 플레이어_같은_숫자_입력() {
		String input = "112";
		assertThatThrownBy(() -> Application.getPlayerNumbers(input)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 스트라이크_수_계산() {
		List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
		List<Integer> playerNumbers = Arrays.asList(1, 2, 3);
		assertThat(Application.sumStrike(computerNumbers, playerNumbers)).isEqualTo(3);
	}

	@Test
	void 볼_수_계산() {
		List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
		List<Integer> playerNumbers = Arrays.asList(2, 3, 1);
		assertThat(Application.sumBall(computerNumbers, playerNumbers)).isEqualTo(3);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
