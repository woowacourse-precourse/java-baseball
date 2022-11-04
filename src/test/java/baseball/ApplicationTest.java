package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("야구공 3개 미만 입력 예외케이스")
    void 플레이어입력_예외_테스트() {
    	//given, when
    	String twoLengthBall = "12";
    	String oneLengthBall = "9";
    	String zeroLengthBall = "";
    	//then
    	assertThatThrownBy(() -> Application.checkLessThanThreeExecption(twoLengthBall)).isInstanceOf(IllegalArgumentException.class);
    	assertThatThrownBy(() -> Application.checkLessThanThreeExecption(oneLengthBall)).isInstanceOf(IllegalArgumentException.class);
    	assertThatThrownBy(() -> Application.checkLessThanThreeExecption(zeroLengthBall)).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
