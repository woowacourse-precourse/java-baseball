package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RestartOrFinishTest extends NsTest {

    @DisplayName("종료 및 재시작 선택 기능")
    @Test
    void reStartAndFinishTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "456", "1", "789", "387", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                4, 5, 6, 3, 8, 7
        );
    }

    @DisplayName("1과 2가 아닌 다른 숫자 선택 시 예외 처리")
    @Test
    public void exceptionHandlingSelectNumNotOneOrTwo() {
        final  RestartOrFinish restartOrFinish = new RestartOrFinish();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> restartOrFinish.finishGameExceptionHandling(3))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    public void runMain() {
        Application.main(new String[]{});
    }
}
