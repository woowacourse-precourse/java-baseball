package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MakeThreeDigitNumberTest {

    @Test
    @DisplayName("컴퓨터가 랜덤으로 뽑은 수는 예외를 발생시키지 않는다.")
    void computerSelectedNumber() {
        MakeThreeDigitNumber makeThreeDigitNumber = new MakeThreeDigitNumber();
        // given
        ArrayList<String> computerSelectedNumber = makeThreeDigitNumber.computerSelectedNumber();
        // when,then
        assertDoesNotThrow(() -> PlayerInputValueExceptions.allInputValueException(computerSelectedNumber));
    }

}
