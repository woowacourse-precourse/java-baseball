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
    @Test
    @DisplayName("Check for exception when length of input string is not 3")
    public void isProperLength_Test(){
        String wrongLengthUserInput="67";
        InputException inputException = new InputException();

        assertThat(inputException.isProperLength(wrongLengthUserInput)).isFalse();
    }
    @Test
    @DisplayName("Check for exception when input string contains zero")
    public void containZero_Test(){
        String userInputContainZero="054";
        InputException inputException = new InputException();

        assertThat(inputException.containZero(userInputContainZero)).isTrue();
    }
    @Test
    @DisplayName("Check for excpetion when input string contains redundant number")
    public void isDuplicate_Test(){
        String duplicateInput="656";
        InputException inputException = new InputException();

        assertThat(inputException.isDuplicate(duplicateInput)).isTrue();
    }
}
