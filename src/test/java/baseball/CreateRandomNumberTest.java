package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;

class CreateRandomNumberTest {

//  @BeforeEach //얘가 모든 테스트 전에 한번씩 쓰고싶은데 어케 끌어오지...
//  void setNumber() {
//    String testNumber = CreateRandomNumber.numberMaker();
//  }
  @Test
  void numberMaker_길이_테스트() {
    String testNumber = CreateRandomNumber.numberMaker();
    Assertions.assertThat(testNumber.length()).isEqualTo(3);
  }
  @Test
  void numberMaker_1_9_사이의_수_테스트() {
    // 1 ~ 9 숫자 검사
    String testNumber = CreateRandomNumber.numberMaker();
    for (int i = 0; i < testNumber.length(); i++) {
      Assertions.assertThat(testNumber.charAt(i)).isBetween('1', '9');
    }
  }
  @Test
  void numberMaker_중복_검사() {
    // 중복 검사
    String testNumber = CreateRandomNumber.numberMaker();
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < testNumber.length(); i++) {
      set.add(testNumber.charAt(i));
    }
    Assertions.assertThat(testNumber.length()).isEqualTo(set.size());
  }
}