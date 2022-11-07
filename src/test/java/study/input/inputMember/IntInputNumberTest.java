package study.input.inputMember;

import baseball.input.inputMember.IntInputNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class IntInputNumberTest {

    @Test
    void 콘솔을_통해_입력받은_값_생성자를_통해_생성() {
        String stringNumber = "123";
        int intNumber = 123;

        assertThat(new IntInputNumber(stringNumber)
                            .getIntInputNumber())
                                .isEqualTo(intNumber);

    }
    @Test
    void 콘솔을_통해_입력받은_숫자가_아닌_값_생성자를_통해_생성() {
        String name = "김종준";
        String message = "숫자만 입력할 수 있습니다";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new IntInputNumber(name))
                .withMessage(message);
    }
}