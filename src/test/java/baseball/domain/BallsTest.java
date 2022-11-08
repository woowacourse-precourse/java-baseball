package baseball.domain;

import static baseball.message.ExceptionMessage.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallsTest {

  @Test
  @DisplayName("3자리수 아닌 경우 예외 처리 테스트")
  void 숫자_개수_테스트(){
    List<Integer> notThreeBalls = new ArrayList<>(Arrays.asList(1, 2));
    Exception exception = assertThrows(IllegalArgumentException.class,()-> new Balls(notThreeBalls));
    assertEquals(exception.getMessage(), INCORRECT_BALL_SIZE.getErrorMessage());
  }

  @Test
  @DisplayName("숫자가 중복 될 경우 예외 처리 테스트")
  void 중복_숫자_테스트(){
    List<Integer> notThreeBalls = new ArrayList<>(Arrays.asList(2, 2, 4));
    Exception exception = assertThrows(IllegalArgumentException.class,()-> new Balls(notThreeBalls));
    assertEquals(exception.getMessage(), DUPLICATE_NUMBER.getErrorMessage());
  }



}
