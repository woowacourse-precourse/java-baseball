package baseball;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.validation.Validation;
import baseball.view.View;
import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

class ApplicationTest extends NsTest {
	Computer computer;
	List<Integer> randomNumberList;
	List<Integer> userNumberList;
	Player player;

	@BeforeEach
	void setUp() {
		computer = new Computer();
		computer.makeRandomNumber();
		player = new Player();

		randomNumberList = computer.getRandomNumber();
		userNumberList = player.getPlayerNumberList();
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
	void isSameNumberExistInRandomNumber_메서드로_숫자_중복_알아냄() {
		int randomNumber = randomNumberList.get(0);
		randomNumberList = computer.getRandomNumber();

		assertThat(Validation.isSameNumberExistInRandomNumber(randomNumber, randomNumberList)).isTrue();
	}

	@Test
	void showResult_메서드로_결과_출력() {
		int ball = 2;
		int strike = 1;
		View.showResult(ball, strike);
		assertThat(output()).contains("2볼", "1스트라이크");

		ball = 0;
		strike = 0;
		View.showResult(ball, strike);
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