package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HintTest {

  @Test
  @DisplayName("힌트 제공 기능 테스트")
  void 힌트_스트라이크_볼(){
    Balls balls1 = new Balls(new ArrayList<>(Arrays.asList(1,4,5)));
    Balls balls2 = new Balls(new ArrayList<>(Arrays.asList(1,9,4)));
    Hint hint = new Hint();
    hint.countStrikeAndBall(balls1, balls2);
    assertEquals(hint.toString(), "1볼 1스트라이크");
  }

  @Test
  @DisplayName("3스트라이크 테스트")
  void 스트라이크_테스트(){
    Balls balls1 = new Balls(new ArrayList<>(Arrays.asList(1,4,5)));
    Balls balls2 = new Balls(new ArrayList<>(Arrays.asList(1,4,5)));
    Hint hint = new Hint();
    hint.countStrikeAndBall(balls1, balls2);
    assertEquals(hint.toString(), "3스트라이크");
  }

  @Test
  @DisplayName("낫싱 테스트")
  void 낫싱_테스트(){
    Balls balls1 = new Balls(new ArrayList<>(Arrays.asList(1,4,5)));
    Balls balls2 = new Balls(new ArrayList<>(Arrays.asList(2,3,6)));
    Hint hint = new Hint();
    hint.countStrikeAndBall(balls1, balls2);
    assertEquals(hint.toString(), "낫싱");
  }
}
