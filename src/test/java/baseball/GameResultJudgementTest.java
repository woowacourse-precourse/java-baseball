package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class GameResultJudgementTest {

  GameResultJudgement judge;

  @BeforeEach
  void GameResultJudgmentCreate() {
    judge = new GameResultJudgement(3);
  }

  void assertStrike(String input, String answer, int expected) {
    assertEquals(expected, judge.judgeStrike(input, answer));
  }


  @Test
  @Order(1)
  @DisplayName("스트라이크 3 확인")
  void JudgeStrikeCount3() {
    assertStrike("123", "123", 3);
    assertStrike("456", "456", 3);
    assertStrike("789", "789", 3);
  }
  @Test
  @Order(2)
  @DisplayName("스트라이크 2 확인")
  void JudgeStrikeCount2() {
    assertStrike("123", "124", 2);
    assertStrike("456", "457", 2);
    assertStrike("789", "289", 2);
  }
  @Test
  @Order(3)
  @DisplayName("스트라이크 1 확인")
  void JudgeStrikeCount1() {
    assertStrike("123", "524", 1);
    assertStrike("456", "957", 1);
    assertStrike("789", "762", 1);
  }
}