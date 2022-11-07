package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    //====== 테스트 코드 ========/
    @DisplayName("입력한 숫자가 3개인가")
    @Test
    void test1() {
        assertThrows(IllegalArgumentException.class,
                () -> run("1234")
        );
    }

    @DisplayName("숫자만 입력했는가")
    @Test
    void test2() {
        assertThrows(IllegalArgumentException.class,
                () -> run("q13"));
    }

    @DisplayName("1부터 9까지의 숫자만 입력했는가")
    @Test
    void test3() {
        assertThrows(IllegalArgumentException.class,
                () -> run("012"));
    }

    @DisplayName("게임 종료 여부를 물을 때 1 또는 2만 입력헀는가")
    @Test
    void test4() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThrows(IllegalArgumentException.class,
                            () -> run("246", "135", "3"));
                    assertThat(output()).contains("낫싱", "3스트라이크");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @DisplayName("사용자가 중복된 수를 입력하지 않았는가")
    @Test
    void test() {
        assertThrows(IllegalArgumentException.class,
                () -> run("112"));
    }
}
