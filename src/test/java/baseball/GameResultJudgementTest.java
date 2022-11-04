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

  @Test
  @Order(1)
  @DisplayName("스트라이크 3 확인")
  void JudgeStrikeCount3() {
    assertEquals(3, judge.judgeStrike("123", "123"));
    assertEquals(3, judge.judgeStrike("456", "456"));
    assertEquals(3, judge.judgeStrike("789", "789"));
  }
}