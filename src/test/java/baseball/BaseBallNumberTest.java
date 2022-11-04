package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallNumberTest {

  @Test
  @DisplayName("validate number size_empty")
  void validateSizeEmpty() {
    Assertions.assertThatThrownBy(()->{
      BaseBallNumber baseBallNumber = new BaseBallNumber(Collections.emptyList());
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("validate number size_less")
  void validateSizeLess() {
    Assertions.assertThatThrownBy(()->{
      BaseBallNumber baseBallNumber = new BaseBallNumber(List.of('1', '2'));
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("validate number size_more")
  void validateSizeMore() {
    Assertions.assertThatThrownBy(()->{
      BaseBallNumber baseBallNumber = new BaseBallNumber(List.of('1', '2', '3', '4'));
    }).isInstanceOf(IllegalArgumentException.class);
  }


  @Test
  @DisplayName("validate number duplicate_two")
  void validateDuplicateTwo() {
    Assertions.assertThatThrownBy(()->{
      BaseBallNumber baseBallNumber = new BaseBallNumber(List.of('1', '1', '2'));
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("validate number duplicate_three")
  void validateDuplicateThree() {
    Assertions.assertThatThrownBy(()->{
      BaseBallNumber baseBallNumber = new BaseBallNumber(List.of('1', '1', '1'));
    }).isInstanceOf(IllegalArgumentException.class);
  }

}