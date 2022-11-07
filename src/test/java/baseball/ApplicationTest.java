package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

@DisplayName("숫자야구 게임은")
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
class ApplicationTest extends NsTest {

    @Nested
    @Order(1)
    @DisplayName("게임 종료 후")
    class 종료_테스트 {

        @Test
        @DisplayName("1을 입력해 다시 시작하거나 2를 입력해 종료할 수 있어야 한다.")
        void 게임종료_후_재시작() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "1", "597", "589", "2");
                        assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                    },
                    1, 3, 5, 5, 8, 9
            );
        }
    }

    @Nested
    @Order(2)
    @DisplayName("잘못된 값을 입력할 경우")
    class 오류_테스트 {

        @Test
        @DisplayName("IllegalArgumentException 에러를 호출한다.")
        void 예외_테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
