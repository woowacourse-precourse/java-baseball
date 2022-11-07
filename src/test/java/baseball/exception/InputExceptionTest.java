package baseball.exception;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class InputExceptionTest {
    @Test
    @DisplayName("check user's input if input string contains alphabet")
    void isProperLetter_Alphabet_Test() {
        String wrongUserInputAlphabet = "Z56";
        InputException inputException = new InputException();
        assertThat(inputException.isProperLetter(wrongUserInputAlphabet)).isFalse();
    }

    @Test
    @DisplayName("Check user's input if input string contains special symbols")
    public void isProperLetter_Symbol_Test(){
        String wrongUserInputSymbol = "[56";
        InputException inputException = new InputException();
        assertThat(inputException.isProperLetter(wrongUserInputSymbol)).isFalse();
    }
}
