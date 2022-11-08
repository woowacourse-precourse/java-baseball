package baseball;

import baseball.Players.Computer;
import baseball.Validation.Validation;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
            result = computer.getRandomNumbersList();

            assertThat(result).hasSize(3);
        }
    }

    @Test
    void 랜덤숫자_3개_중복확인() {
        List<Integer> result;

        for (int i = 0; i < 10; i++) {
            result = computer.getRandomNumbersList();

            assertThat(result).doesNotHaveDuplicates();
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
