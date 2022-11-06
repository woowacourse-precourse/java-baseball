package baseball;

import baseball.Players.Computer;
import baseball.Validation.Validation;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.Message.ErrorMessage.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StartTest extends NsTest {

    static Computer computer;
    static Validation validate;

    @BeforeAll
    private static void initClasses() {
        computer = new Computer();
        validate = new Validation();
    }

    @Test
    void 랜덤숫자_3개_생성() {
        List<Integer> result;

        for (int i = 0; i < 10; i++) {
            result = computer.getRandomNumbers();

            assertThat(result).hasSize(3);
        }
    }

    @Test
    void 랜덤숫자_3개_중복확인() {
        List<Integer> result;

        for (int i = 0; i < 10; i++) {
            result = computer.getRandomNumbers();

            assertThat(result).doesNotHaveDuplicates();
        }
    }

    @Test
    void 입력값_에러메세지_체크() {
        List<String> testInput = List.of(
                "1234"
                , "556"
                , "7 8"
                , "9A1");

        List<String> errorMsg = List.of(
                OUT_OF_LENGTH.toMessage()
                , DUPLICATED_NUMBERS.toMessage()
                , BLANK_EXISTS.toMessage()
                , NOT_ALLOWED_CHARACTER.toMessage()
                , ZERO_EXISTS.toMessage());

        for (int index = 0; index < 5; index++) {
            final int i = index;

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> validate.check(testInput.get(i)))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(errorMsg.get(i)));
        }

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
