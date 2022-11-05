package baseball.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.channels.IllegalChannelGroupException;

class ValidatorTest {

    @Test
    void validateParseStringToInt_숫자로_바꿀_수_없는_문자열을_바꾸려고_할때_예외를_던지는지_테스트() {
        //given
        String playerInput = "12삼";
        //when
        //then
        Assertions.assertThatThrownBy(() -> {
                      try {
                          Integer.parseInt(playerInput);
                      } catch (NumberFormatException e) {
                          throw new IllegalArgumentException();
                      }
                  })
                  .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateParseStringToInt_숫자로_바꿀_수_있는_문자열을_바꾸려고_숫자로_잘_바뀌는지_테스트() {
        //given
        String playerInput = "123";
        //when
        //then
        Assertions.assertThat(Integer.parseInt(playerInput))
                  .isEqualTo(123);
    }


    @Test
    void validateInputLength_입력된_값의_길이가_3이_아닐때_예외를_던지는지_테스트() {
        //given
        String playerInput = "12";
        //when
        Assertions.assertThatThrownBy(() -> {
                      if (playerInput.length() == 3) {
                          return;
                      }
                      throw new IllegalChannelGroupException();
                  })
                  .isInstanceOf(IllegalArgumentException.class);
        //then
    }


    @Test
    void validateDuplication() {
    }
}