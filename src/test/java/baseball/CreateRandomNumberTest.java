package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class CreateRandomNumberTest {

  @Test
  void numberMaker() {
    //길이 검사
    String testNumber = CreateRandomNumber.numberMaker();
    assertThat(testNumber.length()).isEqualTo(3);

  }
}