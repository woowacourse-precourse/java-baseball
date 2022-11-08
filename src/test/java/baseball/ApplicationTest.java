package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void checkInputConditionTest_NormalCase() throws Exception {
        //given
        int inputNumber = 123;
        //when
        //then
        assertThatThrownBy(() -> Application.checkInputCondition(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void checkInputConditionTest_MoreDigits() throws Exception {
        //given
        int inputNumber = 1234;
        //when
        //then
        assertThatThrownBy(() -> Application.checkInputCondition(inputNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void checkInputConditionTest_LessDigits() throws Exception {
        //given
        int inputNumber = 12;
        //when
        //then
        assertThatThrownBy(() -> Application.checkInputCondition(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void checkInputConditionTest_RedundantNumber() throws Exception {
        //given
        int inputNumber = 122;
        //when
        //then
        assertThatThrownBy(() -> Application.checkInputCondition(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void convertIntegerIntoListTest() throws Exception {
        //given
        int number = 123;
        List<Integer> actual = Arrays.asList(1, 2, 3);
        //when
        List<Integer> expected = Application.convertIntegerIntoList(number);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void countBallsAndStrikesTest_ThreeStrikes() throws Exception {
        //given
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<Integer> input = Arrays.asList(1, 2, 3);

        //when
        int[] expectedResult = new int[]{0, 3};
        int[] actualResult = Application.countBallsAndStrikes(answer, input);

        //then
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void countBallsAndStrikesTest_TwoBallsOneStrike() throws Exception {
        //given
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<Integer> input = Arrays.asList(3, 2, 1);
        //when
        int[] expectedResult = new int[]{2, 1};
        int[] actualResult = Application.countBallsAndStrikes(answer, input);
        //then
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void countBallsAndStrikesTest_ThreeBallsNoStrike() throws Exception{
        //given
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<Integer> input = Arrays.asList(3, 1, 2);
        //when
        int[] expectedResult = new int[]{3, 0};
        int[] actualResult = Application.countBallsAndStrikes(answer, input);
        //then
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void countBallsAndStrikesTest_Nothing() throws Exception{
        //given
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<Integer> input = Arrays.asList(4, 5, 6);
        //when
        int[] expectedResult = new int[]{0, 0};
        int[] actualResult = Application.countBallsAndStrikes(answer, input);
        //then
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void getResultTest() throws Exception{
        //given
        int[] countResult1 = new int[]{1, 2};
        String expectedOneBallTwoStrike = "1볼 2스트라이크";

        int[] countResult2 = new int[]{1, 1};
        String expectedOneBallOneStrike = "1볼 1스트라이크";


        //when
        String actualOneBallTwoStrike = Application.getResultMessage(countResult1);
        String actualOneBallOneStrike = Application.getResultMessage(countResult2);

        //then
        assertEquals(expectedOneBallTwoStrike, actualOneBallTwoStrike);
        assertEquals(expectedOneBallOneStrike, actualOneBallOneStrike);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
