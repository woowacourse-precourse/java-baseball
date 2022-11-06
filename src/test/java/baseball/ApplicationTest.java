package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void 게임_결과_출력_테스트(){
        Application.checkResult(List.of(5,6,7), List.of(5,6,9));
        assertEquals(output(), "2스트라이크");
        init();

        Application.checkResult(List.of(8,6,1), List.of(8,2,7));
        assertEquals(output(), "1스트라이크");
        init();

        Application.checkResult(List.of(1,7,8), List.of(4,6,7));
        assertEquals(output(), "1볼");
        init();

        Application.checkResult(List.of(7,1,5), List.of(1,5,7));
        assertEquals(output(), "3볼");
        init();

        Application.checkResult(List.of(5,7,2), List.of(1,7,5));
        assertEquals(output(), "1볼 1스트라이크");
        init();

        Application.checkResult(List.of(7,1,5), List.of(7,5,1));
        assertEquals(output(), "2볼 1스트라이크");
        init();

        Application.checkResult(List.of(4,5,6), List.of(3,2,1));
        assertEquals(output(), "낫싱");
        init();

        Application.checkResult(List.of(4,1,7), List.of(4,1,7));
        assertEquals(output(), "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        init();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
