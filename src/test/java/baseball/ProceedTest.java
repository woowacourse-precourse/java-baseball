package baseball;

import baseball.Utils.NumberListComparator;
import baseball.Validation.Validation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static baseball.Message.ErrorMessage.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProceedTest {
    static Validation validate;
    static NumberListComparator comparator;
    static ByteArrayOutputStream consoleOutput;

    @BeforeAll
    private static void initClasses() {
        validate = new Validation();
        comparator = new NumberListComparator();
        consoleOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOutput));
    }

    @Test
    void 결과메세지_테스트() {
        List<Integer> answer = List.of(1, 2, 3);
        comparator.setAnswerNumberListForComparing(answer);
        List<Integer> input;

        List<List<Integer>> inputList = List.of(
                List.of(1, 2, 9),
                List.of(3, 1, 2),
                List.of(1, 3, 2),
                List.of(4, 5, 6)
        );
        String[] expectedOutput = new String[]{
                "2스트라이크\n",
                "3볼\n",
                "2볼 1스트라이크\n",
                "낫싱\n"
        };

        for (int i = 0; i < 4; i++) {
            input = inputList.get(i);

            consoleOutput.reset();
            comparator.compareUserNumbersAndAnswer(input);

            assertThat(consoleOutput.toString()).isEqualTo(expectedOutput[i]);
        }

    }

    @Test
    void 입력값_에러메세지_체크() {
        List<String> testInput = List.of(
                "1234"
                , "556"
                , "7 8"
                , "9A1"
                , "102");

        List<String> errorMsg = List.of(
                OUT_OF_LENGTH.toMessage()
                , DUPLICATED_NUMBERS.toMessage()
                , BLANK_EXISTS.toMessage()
                , NOT_ALLOWED_CHARACTER.toMessage()
                , ZERO_EXISTS.toMessage());

        for (int index = 0; index < 5; index++) {
            final int i = index;

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> validate.checkUserInputNumbers(testInput.get(i)))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(errorMsg.get(i)));
        }

    }

}
