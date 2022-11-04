package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.Application;

import camp.nextstep.edu.missionutils.test.NsTest;

class RefereeTest extends NsTest {

	@Test
	@DisplayName("스트라이크 개수 확인")
	void case1() {
		assertThat(3).isEqualTo(
			Referee.getStrikeCount(
				Arrays.asList(1, 2, 3),
				Arrays.asList(1, 2, 3))
		);
	}

	@Test
	@DisplayName("낫싱 확인")
	void case2() {
		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(4, 5, 6);
		Referee.printResult(list1, list2);
		assertThat(output()).contains("낫싱");
	}

	@Test
	@DisplayName("볼 개수 확인")
	void case3() {
		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(3, 5, 1);
		Referee.printResult(list1, list2);
		assertThat(output()).contains("2볼");
	}

	@Test
	@DisplayName("볼 + 스트라이크 개수 확인")
	void case4() {
		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(1, 3, 2);
		Referee.printResult(list1, list2);
		assertThat(output()).contains("2볼 1스트라이크");
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}

}