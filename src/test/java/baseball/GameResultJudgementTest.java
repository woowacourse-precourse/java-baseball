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

  void assertBall(String input, String answer, int expected) {
    assertEquals(expected, judge.judgeBall(input, answer));
  }
  @Test
  @Order(4)
  @DisplayName("볼 3 확인")
  void JudgeBallCount3() {
    assertBall("123", "312", 3);
    assertBall("456", "645", 3);
    assertBall("789", "978", 3);
  }
  @Test
  @Order(5)
  @DisplayName("볼 2 확인")
  void JudgeBallCount2() {
    assertBall("123", "412", 2);
    assertBall("456", "265", 2);
    assertBall("789", "198", 2);
  }
  @Test
  @Order(6)
  @DisplayName("볼 1 확인")
  void JudgeBallCount1() {
    assertBall("123", "981", 1);
    assertBall("456", "786", 1);
    assertBall("789", "217", 1);
  }
  @Test
  @Order(7)
  @DisplayName("볼 0 확인")
  void JudgeBallCount0() {
    assertBall("123", "123", 0);
    assertBall("789", "762", 0);
    assertBall("789", "289", 0);
  }
}