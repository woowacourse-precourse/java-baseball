package baseball.exception;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class InputExceptionTest {
    @Test
    @DisplayName("check user's input if input string contains alphabet")
    void isNotProperLetter_Alphabet_Test() {
        String wrongUserInputAlphabet = "Z56";
        assertThat(InputException.isNotProperLetter(wrongUserInputAlphabet)).isTrue();
    }

    @Test
    @DisplayName("Check user's input if input string contains special symbols")
    public void isNotProperLetter_Symbol_Test(){
        String wrongUserInputSymbol = "[56";
        assertThat(InputException.isNotProperLetter(wrongUserInputSymbol)).isTrue();
    }
    @Test
    @DisplayName("Check for exception when length of input string is not 3")
    public void isNotProperLength_Test(){
        String wrongLengthUserInput="67";
        assertThat(InputException.isNotProperLength(wrongLengthUserInput)).isTrue();
    }
    @Test
    @DisplayName("Check for exception when input string contains zero")
    public void containZero_Test(){
        String userInputContainZero="054";
        assertThat(InputException.containZero(userInputContainZero)).isTrue();
    }
    @Test
    @DisplayName("Check for excpetion when input string contains redundant number")
    public void isDuplicate_Test(){
        String duplicateInput="656";
        assertThat(InputException.isDuplicate(duplicateInput)).isTrue();
    }
    @Test
    public void isWrongUserInput_Alphabet_Test(){
        String wrongUserInputAlphabet="05A";

        if(InputException.isNotProperLetter(wrongUserInputAlphabet)){
            assertThatThrownBy(() -> { throw new IllegalArgumentException(); }).isInstanceOf(IllegalArgumentException.class);
        }
    }
    @Test
    public void isWrongUserInput_Symbol_Test(){
        String wrongUserInputSymbol="05[";
        if(InputException.isNotProperLetter(wrongUserInputSymbol)){
            assertThatThrownBy(() -> { throw new IllegalArgumentException(); }).isInstanceOf(IllegalArgumentException.class);
        }
    }
    @Test
    public void isWrongUserInput_Length_Over_Three_Test(){
        String wrongLengthUserInput="0545";
        if(InputException.isNotProperLetter(wrongLengthUserInput)){
            assertThatThrownBy(() -> { throw new IllegalArgumentException(); }).isInstanceOf(IllegalArgumentException.class);
        }
    }@Test
    public void isWrongUserInput_Length_Under_Three_Test(){
        String wrongLengthUserInput="05";
        if(InputException.isNotProperLetter(wrongLengthUserInput)){
            assertThatThrownBy(() -> { throw new IllegalArgumentException(); }).isInstanceOf(IllegalArgumentException.class);
        }
    }
    @Test
    public void isWrongUserInput_Duplicate_Test(){
        String duplicateInput="455";
        if(InputException.isNotProperLetter(duplicateInput)){
            assertThatThrownBy(() -> { throw new IllegalArgumentException(); }).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
