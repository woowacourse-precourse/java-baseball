package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {
//    @Test
//    void 게임종료_후_재시작() {
//        assertRandomNumberInRangeTest(
//                () -> {
//                    run("246", "135", "1", "597", "589", "2");
//                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
//                },
//                1, 3, 5, 5, 8, 9
//        );
//    }


    @Test
    void 예외_테스트_입력이_3자리가_아닌_경우_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_입력이_3자리가_아닌_경우_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("41"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_입력을_int로_변환이_불가능한_경우_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_입력을_int로_변환이_불가능한_경우_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_입력에_0이_포함된_경우_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_입력에_0이_포함된_경우_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("102"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_입력에_0이_포함된_경우_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Nested
    class UnitTest {
        @Test
        void 토큰화_test() {
            String input = "123";
            List<Character> result = List.of('1','2','3');

            assertThat(Application.tokenizeString(input)).isEqualTo(result);
        }

        @Test
        void character_list_int_list로_변환() {
            List<Character> input = List.of('1','2','3');
            List<Integer> result = List.of(1,2,3);

            assertThat(Application.convertCharListToIntList(input)).isEqualTo(result);
        }

        @Test
        void 생성된_random_숫자_자리수가_올바른지() {
            int digitSize1 = 3;

            assertThat(Application.generateRandomNumber(digitSize1).size()).isEqualTo(digitSize1);
        }

        @Test
        void 생성된_random_숫자는_다른_숫자들로_구성되어야함() {
            int digitSize1 = 3;

            List<Integer> generatedRandomNumber = Application.generateRandomNumber(digitSize1);

            assertAll(
                    ()-> assertEquals(
                            Collections.frequency(generatedRandomNumber, generatedRandomNumber.get(0)),1),
                    ()-> assertEquals(
                            Collections.frequency(generatedRandomNumber, generatedRandomNumber.get(1)),1),
                    ()-> assertEquals(
                            Collections.frequency(generatedRandomNumber, generatedRandomNumber.get(2)),1)
            );
        }

        @Test
        void 베이스볼_결과_계산() {
            List<Integer> randomNumber = List.of(1,2,3);

            assertAll(
                    ()-> assertEquals(
                           Application.calculateBaseBallResult(randomNumber,List.of(1,2,3)), List.of(3,0)),
                    ()-> assertEquals(
                            Application.calculateBaseBallResult(randomNumber,List.of(1,4,3)), List.of(2,0)),
                    ()-> assertEquals(
                            Application.calculateBaseBallResult(randomNumber,List.of(5,6,3)), List.of(1,0)),
                    ()-> assertEquals(
                            Application.calculateBaseBallResult(randomNumber,List.of(5,2,1)), List.of(1,1)),
                    ()-> assertEquals(
                            Application.calculateBaseBallResult(randomNumber,List.of(2,1,3)), List.of(1,2)),
                    ()-> assertEquals(
                            Application.calculateBaseBallResult(randomNumber,List.of(7,8,9)), List.of(0,0))
            );
        }
    }
}
