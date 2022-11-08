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
    void 게임시_문자입력_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("da0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("숫자를 입력하세요")
        );
    }

    @Test
    void 게임시_숫자_영_포함여부_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1부터 9까지의 숫자를 입력하세요")
        );
    }
    
    @Test
    void 게임시_같은_숫자_포함_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("서로 다른 숫자를 입력하세요")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
