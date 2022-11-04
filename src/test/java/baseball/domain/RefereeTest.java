package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.Application;

import camp.nextstep.edu.missionutils.test.NsTest;

class RefereeTest extends NsTest {

	@Test
	@DisplayName("스트라이크 갯수 확인")
	void case1() {
		assertThat(3).isEqualTo(
			Referee.getStrikeCount(
				Arrays.asList(1, 2, 3),
				Arrays.asList(1, 2, 3))
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[]{});
	}

}