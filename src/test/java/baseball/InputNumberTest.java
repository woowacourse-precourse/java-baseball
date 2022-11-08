package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class InputNumberTest {


  @Test
  void inputNumber() {
    String userInput = "123";

    assertThat(InputNumber.InputNumber(userInput)).containsExactly(1, 2, 3);
  }

  @Test
  void checkUserInput() {
    String userInput1 = "123";
    String userInput2 = "1234";
    String userInput3 = "A23";

    assertThat(InputNumber.checkUserInput(userInput1)).isEqualTo(true);
    assertThat(InputNumber.checkUserInput(userInput2)).isEqualTo(false);
    assertThat(InputNumber.checkUserInput(userInput3)).isEqualTo(false);
  }
}