package baseball.view;

import static baseball.message.ExceptionMessage.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
  InputView inputView = new InputView();
  @Test
  @DisplayName("입력값이 숫자인지 검증 테스트")
  void 입력값_숫자_검증_테스트(){
    Exception exception = assertThrows(IllegalArgumentException.class,()-> inputView.checkDigit("a"));
    assertEquals(exception.getMessage(), INCORRECT_INPUT.getErrorMessage());
  }

  @Test
  @DisplayName("입력값 1~9까지의 숫자 여부 테스트")
  void 숫자_범위_테스트(){
    Exception exception = assertThrows(IllegalArgumentException.class,()-> inputView.checkDigit("102"));
    assertEquals(exception.getMessage(), INCORRECT_INPUT.getErrorMessage());
  }

  @Test
  @DisplayName("게임 재시작 입력 테스트")
  void 재시작_입력값_테스트(){
    Exception exception = assertThrows(IllegalArgumentException.class,()-> inputView.validateMenu("3"));
    assertEquals(exception.getMessage(), INCORRECT_MENU_NUMBER.getErrorMessage());
  }

}
