package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class CreateRandomNumberTest {

  @Test
  void numberMaker() {
    // 길이 검사
    String testNumber = CreateRandomNumber.numberMaker();
    assertThat(testNumber.length()).isEqualTo(3);

    // 중복 검사
    for (int i = 0; i < testNumber.length(); i++) {
      assertThat(testNumber.charAt(i)).isBetween('1', '9');
    }
  }
}