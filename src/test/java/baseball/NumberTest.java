package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberTest {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private static final int CNT_NUMBER = 3;
    private static final String ANSWER_LENGTH_ERR_MESSAGE = "숫자의 자리수가 올바르지 않습니다.";
    private static final String ANSWER_DUPLICATION_ERR_MESSAGE = "중복된 수가 포함되어 있습니다.";
    private static final String ANSWER_RANGE_ERR_MESSAGE = "범위를 벗어난 수가 포함되어 있습니다.";
    private static final String ANSWER_DATATYPE_ERR_MESSAGE = "숫자가 아닌 문자가 포함되어 있습니다.";

    Number number;

    @BeforeEach
    void createNumber() {
        number = new Number();
    }

    @Test
    void 컴퓨터_숫자_갯수_검증() {
        List<Integer> computerNumbers = number.generateRandomNumber();
        int computerNumbersSize = computerNumbers.size();
        Assertions.assertThat(computerNumbersSize).isEqualTo(CNT_NUMBER);
    }

    @Test
    void 컴퓨터_숫자_범위_검증() {
        List<Integer> computerNumbers = number.generateRandomNumber();
        boolean computerNumbersRange = computerNumbers.stream().allMatch(num -> num >= MIN_RANGE && num <= MAX_RANGE);
        Assertions.assertThat(computerNumbersRange).isTrue();
    }

    @Test
    void 컴퓨터_숫자_중복_검사() {
        List<Integer> computerNumbers = number.generateRandomNumber();
        int uniqueComputerNumbers = computerNumbers.stream().distinct().collect(Collectors.toList()).size();
        Assertions.assertThat(uniqueComputerNumbers).isEqualTo(3);
    }

    @Test
    void 사용자_입력_유효성_검사() {
        String answer = "123";
        boolean available = number.isValidAnswer(answer);
        Assertions.assertThat(available).isTrue();
    }

    @Test
    void 사용자_입력_유효성_검사_자리수_초과_케이스() {
        String answer = "1234";

        assertThatThrownBy(() -> number.isValidAnswer(answer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ANSWER_LENGTH_ERR_MESSAGE);
    }

    @Test
    void 사용자_입력_유효성_검사_중복_케이스() {
        String answer = "122";

        assertThatThrownBy(() -> number.isValidAnswer(answer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ANSWER_DUPLICATION_ERR_MESSAGE);
    }

    @Test
    void 사용자_입력_유효성_검사_범위_위반_케이스() {
        String answer = "120";

        assertThatThrownBy(() -> number.isValidAnswer(answer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ANSWER_RANGE_ERR_MESSAGE);
    }

    @Test
    void 사용자_입력_유효성_검사_자료형_위반_케이스() {
        String answer = "1S9";

        assertThatThrownBy(() -> number.isValidAnswer(answer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ANSWER_DATATYPE_ERR_MESSAGE);
    }
}