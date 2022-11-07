package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
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
	void exceptionTest() {
		assertRandomNumberInRangeTest(
			() -> {
				assertThatThrownBy(() -> runException("246", "135", "1", "597", "589", "3"))
					.isInstanceOf(IllegalArgumentException.class);
			},
			1, 3, 5, 5, 8, 9
		);
	}

	@Test
	void normalGameStartTest() {
		assertRandomNumberInRangeTest(
			() -> {
				run("987", "654", "321", "312", "132", "213", "123", "2");
				assertThat(output()).contains("낫싱", "낫싱", "2볼 1스트라이크", "3볼", "2볼 1스트라이크", "3스트라이크", "게임 종료");
			},
			1, 2, 3
		);
	}

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
