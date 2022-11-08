package study.baseball;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FunctionTest{

    @Nested
    class isEndTest {

        private Application functionTest = new Application();

        @Test
        void case1() {
            String number = "1";
            boolean result = true;
            assertThat(functionTest.isEnd(number)).isEqualTo(result);
        }

        @Test
        void case2() {
            String number = "2";
            boolean result = false;
            assertThat(functionTest.isEnd(number)).isEqualTo(result);
        }

        @Test
        void 예외_테스트1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> functionTest.isEnd("helloworld"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }
}