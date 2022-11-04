package baseball.myTest;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;

public class RunTest extends NsTest {

	@Test
	void 모든_볼_경우() {
		assertRandomNumberInRangeTest(
			() -> {
				run("513", "153", "317", "157", "135", "2");
				assertThat(output()).contains("3볼", "2볼 1스트라이크", "2볼", "1볼 1스트라이크", "3스트라이크", "게임 종료");
			},
			1, 3, 5
		);
	}

	@Test
	void 모든_스트라이크_경우() {
		assertRandomNumberInRangeTest(
			() -> {
				run("153", "137", "153", "157", "135", "2");
				assertThat(output()).contains("2볼 1스트라이크", "2스트라이크", "2볼 1스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
			},
			1, 3, 5
		);
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}
