package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CheckPlayerNumTest {
   CheckPlayerNum checkPlayerNum;

   @ParameterizedTest
   @ValueSource (strings = {"38", "sdf", "d", " "})
    void checkException(String input) {
       assertThatThrownBy(() -> {
           checkPlayerNum = new CheckPlayerNum();
           checkPlayerNum.setPlayerNumber(input);
       }).isInstanceOf(IllegalArgumentException.class);
   }
}
