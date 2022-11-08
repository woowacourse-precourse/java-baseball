package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @ParameterizedTest
    @ValueSource(strings = {"123"})
    void getUserInputTest(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        List<Integer> userInput = List.of(1,2,3);
        assertEquals(userInput,getUserInput());
    }

    @Test
    void checkInputValueTest() {
        List<Integer> errorCase = List.of(0,1,3);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            checkInputValue(errorCase);
        });
    }

    @Test
    void checkEndGameInputTest() {
        String errorCase = "3";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            checkEndGameInput(errorCase);
        });
    }

    @Test
    void checkBallTest1() {
        List<Integer> answer = List.of(3,1,2);
        List<Integer> userInput = List.of(1,7,5);
        int result = 1;
        assertEquals(result,checkBall(answer,userInput));
    }

    @Test
    void checkBallTest2() {
        List<Integer> answer = List.of(6,3,5);
        List<Integer> userInput = List.of(3,4,5);
        int result = 2;
        assertEquals(result,checkBall(answer,userInput));
    }

    @Test
    void checkStrikeTest1() {
        List<Integer> answer = List.of(5,7,8);
        List<Integer> userInput = List.of(5,4,8);
        int result = 2;
        assertEquals(result,checkStrike(answer,userInput));
    }

    @Test
    void checkStrikeTest2() {
        List<Integer> answer = List.of(1,6,2);
        List<Integer> userInput = List.of(2,1,6);
        int result = 0;
        assertEquals(result,checkStrike(answer,userInput));
    }

    @Test
    void printStrikeAndBallTest1() {
        int ball = 2;
        int strike = 1;
        init();
        printStrikeAndBall(ball,strike);
        String result  = output();
        assertEquals("2볼 1스트라이크",result);
    }

    @Test
    void printStrikeAndBallTest2() {
        int ball = 0;
        int strike = 1;
        init();
        printStrikeAndBall(ball,strike);
        String result  = output();
        assertEquals("1스트라이크",result);
    }

    @Test
    void printStrikeAndBallTest3() {
        int ball = 3;
        int strike = 0;
        init();
        printStrikeAndBall(ball,strike);
        String result  = output();
        assertEquals("3볼",result);
    }

    @Test
    void printStrikeAndBallTest4() {
        int ball = 0;
        int strike = 0;
        init();
        printStrikeAndBall(ball,strike);
        String result  = output();
        assertEquals("낫싱",result);
    }

    @Test
    void returnAnswerTest1() {
        boolean result = true;
        List<Integer> answer = List.of(1,2,3);
        List<Integer> userInput = List.of(1,2,3);
        assertEquals(result,returnAnswer(answer,userInput));
    }

    @Test
    void returnAnswerTest2() {
        boolean result = false;
        List<Integer> answer = List.of(1,2,3);
        List<Integer> userInput = List.of(1,2,4);
        assertEquals(result,returnAnswer(answer,userInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2"})
    void endGameTest1(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        boolean result = true;
        assertEquals(result,endGame());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void endGameTest2(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        boolean result = false;
        assertEquals(result,endGame());
    }

    @ParameterizedTest
    @ValueSource(strings = {"3"})
    void endGameTest3(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            checkEndGameInput(input);
        });
    }

    @Test
    void makeAnswerSizeTest() {
        int answerSize = 3;
        assertEquals(answerSize,makeAnswer().size());
    }

    @Test
    void makeAnswerValueTest() {
        List<Integer> answerList = makeAnswer();
        Set<Integer> answerSet = new HashSet<>(answerList);
        assertEquals(answerList.size(),answerSet.size());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
