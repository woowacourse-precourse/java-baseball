package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ImplementTest extends NsTest {

    final ByteArrayOutputStream captor = new ByteArrayOutputStream();
    final PrintStream out = System.out;

    @BeforeEach
    void setOutput() {
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(out);
    }

    @Test
    void 정답_생성_테스트() {
        List<Integer> answer = GameManager.createAnswer();
        assertThat(answer.size()).isEqualTo(3);
        for (int element : answer) {
            assertThat(element)
                .isGreaterThan(0)
                .isLessThan(10);
        }
    }

    @Test
    @DisplayName("정답 여부에 따른 게임 종료여부 테스트")
    void isFinish_test() {
        int strike = 3;
        int ball = 1;
        assertThat(GameManager.isFinish(strike)).isEqualTo(true);
        assertThat(GameManager.isFinish(strike - ball)).isEqualTo(false);
    }

    @Tag("isAgain test")
    @Test
    @DisplayName("게임 종료후 재시작 테스트")
    void isAgain_true_test() {
        String restart = "1";
        InputStream in = new ByteArrayInputStream(restart.getBytes());
        System.setIn(in);
        assertThat(GameManager.isAgain(true)).isEqualTo(true);
    }

    @Tag("isAgain test")
    @Test
    @DisplayName("게임 종료후 종료 테스트")
    void isAgain_false_test() {
        String terminate = "2";
        InputStream in = new ByteArrayInputStream(terminate.getBytes());
        System.setIn(in);
        assertThat(GameManager.isAgain(true)).isEqualTo(false);
    }

    @Tag("isAgain test")
    @Test
    @DisplayName("게임 종료후 인풋 예외 테스트")
    void isAgain_exception_test() {
        String wrong_input = "rr";
        InputStream in = new ByteArrayInputStream(wrong_input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> GameManager.isAgain(true))
            .isInstanceOf(IllegalArgumentException.class
            );
    }

    @Test
    @DisplayName("게임중 유저입력 read 테스트")
    void whileRunning_test() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(1, 3, 5));
        String userInputString = "135";
        InputStream in = new ByteArrayInputStream(userInputString.getBytes());
        System.setIn(in);
        assertThat(Input.whileRunning()).isEqualTo(answer);
    }

    @Tag("판정 결과 출력 테스트")
    @ParameterizedTest
    @DisplayName("각 판정별 결과 출력 테스트")
    @CsvSource(value = {"0:0,낫싱", "1:0,1스트라이크", "0:1,1볼", "1:1,1볼 1스트라이크"})
    void printResult_test(final String input, final String expected) {
        final String[] inputs = input.split(":");
        Output.printResult(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        assertEquals(expected, captor.toString().trim());
    }

    @Tag("판정 결과 출력 테스트")
    @Test
    @DisplayName("3스트라이크일 경우 결과 출력 테스트")
    void printResult_3_strike_test() {
        String answer = "3스트라이크"
            + System.lineSeparator()
            + "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
            + System.lineSeparator()
            + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        Output.printResult(3, 0);
        assertEquals(answer, captor.toString().trim());
    }

    @Tag("게임 시작 및 종료시 기본 출력 테스트")
    @Test
    @DisplayName("게임 시작시 멘트 출력 테스트")
    void printStartingMent_test() {
        Output.printStartingMent();
        String answer = "숫자 야구 게임을 시작합니다.";
        assertEquals(answer, captor.toString().trim());
    }

    @Tag("게임 시작 및 종료시 기본 출력 테스트")
    @Test
    @DisplayName("게임 종료시 멘트 출력 테스트")
    void printFinishingMent_test() {
        Output.printFinishingMent();
        String answer = "게임 종료";
        assertEquals(answer, captor.toString().trim());
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3:1:2:3,0/3", "1:2:3:1:2:4,0/2", "1:2:3:1:4:5,0/1", "1:2:3:4:5:6,0/0",
        "1:2:3:2:4:5,1/0", "1:2:3:2:3:4,2/0", "1:2:3:2:3:1,3/0", "1:2:3:1:3:4,1/1"})
    void judge_test(final String input, final String expected) {
        int ball = 0;
        int strike = 1;
        final String[] inputs = input.split(":");
        final String[] expectedsInString = expected.split("/");
        int[] expectedsInInteger = new int[2];
        List<Integer> userInput = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        for (int inputsindex = 0; inputsindex < 3; inputsindex++) {
            userInput.add(Integer.parseInt(inputs[inputsindex]));
        }
        for (int answerindex = 3; answerindex < 6; answerindex++) {
            answer.add(Integer.parseInt(inputs[answerindex]));
        }
        expectedsInInteger[ball] = Integer.parseInt(expectedsInString[ball]);
        expectedsInInteger[strike] = Integer.parseInt(expectedsInString[strike]);
        assertEquals(Referee.judge(userInput, answer)[0], expectedsInInteger[0]);
        assertEquals(Referee.judge(userInput, answer)[1], expectedsInInteger[1]);
    }

    @Tag("유저 인풋 예외 테스트")
    @Test
    @DisplayName("게임중 시도 인풋 테스트")
    void checkGuessingInput_test() {
        List<List<Integer>> exceptionCases = new ArrayList<>();
        List<Integer> smallerSize = new ArrayList<>(Arrays.asList(1));
        List<Integer> biggerSize = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> wrongInput = new ArrayList<>(Arrays.asList(0, 3, 2));
        List<Integer> duplicatedInput = new ArrayList<>(Arrays.asList(1, 1, 2));
        exceptionCases.add(smallerSize);
        exceptionCases.add(biggerSize);
        exceptionCases.add(wrongInput);
        exceptionCases.add(duplicatedInput);
        for (List<Integer> exceptions : exceptionCases) {
            assertThatThrownBy(() -> ExceptionChecker.checkGuessingInput(exceptions))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Tag("유저 인풋 예외 테스트")
    @Test
    @DisplayName("정답후 재시작용 인풋 예외 테스트")
    void checkAfterGameInput_test() {
        int wrongInput = 3;
        assertThatThrownBy(() -> ExceptionChecker.checkAfterGameInput(wrongInput))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
