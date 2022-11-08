package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class ApplicationTest extends NsTest {

	Computer computer;
	List<Integer> randomNumberList;
	List<Integer> userNumberList;
	Player player;

	@BeforeEach
	void setUp() {
		computer = new Computer();
		player = new Player();

		randomNumberList = computer.getRandomNumber();
		userNumberList = player.getUserNumberList();
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

	@Test
	void 컴퓨터_숫자_범위_테스트() {
		assertThat(randomNumberList.stream().allMatch(n -> n >= 1 && n <= 9)).isTrue();
	}

	@Test
	void 컴퓨터_숫자_개수_테스트() {
		assertThat(randomNumberList.size()).isEqualTo(3);
	}

	@Test
	void 컴퓨터_숫자_중복_테스트() {
		boolean isSameNumberExist = randomNumberList.stream()
			.distinct()
			.count() != randomNumberList.size();

		assertThat(isSameNumberExist).isFalse();
	}

	@Test
	void isSameNumberExistInRandomNumber_메서드로_숫자_중복_알아냄() {
		int input = randomNumberList.get(0);

		assertThat(Checker.isSameNumberExistInRandomNumber(input, randomNumberList)).isTrue();
	}

	@Test
	void selectNumber_메서드로_랜덤_숫자_선택() {
		컴퓨터_숫자_범위_테스트();
		컴퓨터_숫자_개수_테스트();
		컴퓨터_숫자_중복_테스트();
	}

	@Test
	void 사용자_입력_범위_테스트() {
		int input = 123;
		player.separateNumbersByUnit(input);

		assertThat(userNumberList.stream().allMatch(n -> n >= 1 && n <= 9)).isTrue();
	}

	@Test
	void 사용자_입력_숫자_개수_테스트() {
		사용자_입력_숫자_테스트();
		사용자_입력_종료_혹은_재시작_테스트();
	}

	@Test
	void 사용자_입력_숫자_테스트() {
		String input = "123";
		System.out.println(input);
		assertThat(input.length()).isEqualTo(3);
	}

	@Test
	void 사용자_입력_종료_혹은_재시작_테스트() {
		String input = "1";
		assertThat(input.length()).isEqualTo(1);
	}

	@Test
	void 사용자_입력_중복_테스트() {
		int input = 123;

		player.separateNumbersByUnit(input);

		boolean isSameNumberExist = userNumberList.stream()
			.distinct()
			.count() != userNumberList.size();

		assertThat(isSameNumberExist).isFalse();
	}

	@Test
	void separateNumbersByUnit_메서드로_각_자릿수_구분() {
		int input = 123;

		player.getUserNumberList().clear();
		player.separateNumbersByUnit(input);

		assertThat(player.getUserNumberList().get(0)).isEqualTo(1);
		assertThat(player.getUserNumberList().get(1)).isEqualTo(2);
		assertThat(player.getUserNumberList().get(2)).isEqualTo(3);
	}

	@Test
	void 숫자_외의_입력_예외_테스트() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("ㅁ"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 입력_길이_예외_테스트() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("1234"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 같은_숫자_입력_예외_테스트() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("1111"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 숫자_범위_예외_테스트() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("012"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void showResult_메서드로_결과_출력() {
		int ball = 2;
		int strike = 1;
		View.showResult(ball, strike, 0);
		assertThat(output()).contains("2볼", "1스트라이크");

		ball = 0;
		strike = 0;
		View.showResult(ball, strike, 0);
		assertThat(output()).contains("낫싱");
	}

	@Test
	void 스트라이크_3개_맞출시_출력_메세지_테스트() {
		assertRandomNumberInRangeTest(
			() -> {
				run("246", "135", "2");
				assertThat(output()).contains("낫싱", "3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료",
					"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			},
			1, 3, 5
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}