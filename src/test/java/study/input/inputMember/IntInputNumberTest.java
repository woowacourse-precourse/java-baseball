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
    
}