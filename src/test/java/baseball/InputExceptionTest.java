package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputExceptionTest extends NsTest {
    @Test
    void 추측할_숫자_입력_오류_1_한자리_수() {
        Exception exception = new Exception();

        List<Integer> guess_case = List.of(1);

        assertThatThrownBy(() -> exception.chkUserGuessInputValid(guess_case))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 추측할_숫자_입력_오류_2_두자리_수() {
        Exception exception = new Exception();

        List<Integer> guess_case = List.of(1,2);

        assertThatThrownBy(() -> exception.chkUserGuessInputValid(guess_case))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 추측할_숫자_입력_오류_3_네자리_수() {
        Exception exception = new Exception();

        List<Integer> guess_case = List.of(1,2,3,4);

        assertThatThrownBy(() -> exception.chkUserGuessInputValid(guess_case))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 추측할_숫자_입력_오류_4_네자리_수_이상() {
        Exception exception = new Exception();

        List<Integer> guess_case = List.of(1,2,3,4,5,6,7,8);

        assertThatThrownBy(() -> exception.chkUserGuessInputValid(guess_case))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 추측할_숫자_입력_오류_중복된_값_존재() {
        Exception exception = new Exception();

        List<Integer> guess_case = List.of(1,1,2);

        assertThatThrownBy(() -> exception.chkUserGuessInputValid(guess_case))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
