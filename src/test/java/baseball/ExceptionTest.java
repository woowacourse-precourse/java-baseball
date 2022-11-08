package baseball;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExceptionTest {

    @DisplayName("입력값 길이 예외처리")
    @Test
    void isInputLengthThree() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            String[] inputArray = {"1","2","3","4"};
            CheckException.validateInputLength(inputArray);
        });
    }

}
