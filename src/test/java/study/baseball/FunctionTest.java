package study.baseball;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Nested
    class CheckInputTest {

        private Application functionTest = new Application();

        @Test
        void case1() {
            String number = "123";
            boolean result = true;
            assertThat(functionTest.CheckInput(number)).isEqualTo(result);
        }

        @Test
        void case2() {
            String number = "999";
            boolean result = true;
            assertThat(functionTest.CheckInput(number)).isEqualTo(result);
        }

        @Test
        void 예외_테스트1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> functionTest.CheckInput("helloworld"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Nested
    class GetHintTest {

        private Application functionTest = new Application();

        @Test
        void case1() {
            String number = "123";
            String input = "234";
            ArrayList<Integer> result = new ArrayList<>(Arrays.asList(2, 0));
            assertThat(functionTest.GetHint(number, input)).isEqualTo(result);
        }

        @Test
        void case2() {
            String number = "246";
            String input = "555";
            ArrayList<Integer> result = new ArrayList<>(Arrays.asList(0, 0));
            assertThat(functionTest.GetHint(number, input)).isEqualTo(result);
        }
        @Test
        void case3() {
            String number = "345";
            String input = "345";
            ArrayList<Integer> result = new ArrayList<>(Arrays.asList(0, 3));
            assertThat(functionTest.GetHint(number, input)).isEqualTo(result);
        }

        @Test
        void case4() {
            String number = "135";
            String input = "333";
            ArrayList<Integer> result = new ArrayList<>(Arrays.asList(2, 1));
            assertThat(functionTest.GetHint(number, input)).isEqualTo(result);
        }
    }
}