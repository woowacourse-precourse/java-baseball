package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;

class CreateRandomNumberTest {

  @Test
  void numberMaker() {
    String testNumber = CreateRandomNumber.numberMaker();

    // 길이 검사
    Assertions.assertThat(testNumber.length()).isEqualTo(3);

    // 1 ~ 9 숫자 검사
    for (int i = 0; i < testNumber.length(); i++) {
      Assertions.assertThat(testNumber.charAt(i)).isBetween('1', '9');
    }

    // 중복 검사
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < testNumber.length(); i++) {
      set.add(testNumber.charAt(i));
    }
    Assertions.assertThat(testNumber.length()).isEqualTo(set.size());
  }
}