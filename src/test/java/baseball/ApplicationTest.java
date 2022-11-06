package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
    void 같은_수를_입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("323"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("222"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("441"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 게임_결과_확인_함수_반환_테스트(){
        // 정답을 맞췄을 경우
        assertTrue(Application.checkResult(List.of(1,2,3), List.of(1,2,3)));
        assertTrue(Application.checkResult(List.of(5,6,7), List.of(5,6,7)));

        // 정답을 맞추지 못했을 경우
        assertFalse(Application.checkResult(List.of(5,6,7), List.of(5,6,9)));
        assertFalse(Application.checkResult(List.of(1,5,9), List.of(5,9,1)));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
