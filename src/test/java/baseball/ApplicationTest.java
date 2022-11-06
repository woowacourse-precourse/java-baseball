package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import java.util.*;
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
    void disassembleDigitNumber_Test(){
        //425가 입력됐을 때 5, 20, 400인 리스트가 반환
        List<Integer> result = List.of(5, 20, 400);
        assertThat(result).isEqualTo(Application.disassembleDigitNumber(425));
    }


    @Nested
    class isValidData_Test {
        @Nested
        class success_case {
            @Test
            void case1() {
                assertThat(true).isEqualTo(Application.isValidData(425));
            }
        }

        @Nested
        class fail_case {
            @Test
            void case1() {
                assertThat(false).isEqualTo(Application.isValidData(445));
            }

            @Test
            void case2() {
                assertThat(false).isEqualTo(Application.isValidData(12));
            }
        }
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
