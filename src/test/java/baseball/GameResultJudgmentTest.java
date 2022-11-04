package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameResultJudgmentTest {

  GameResultJudgmentTest judge;
  @BeforeEach
  void GameResultJudgmentCreate() {
    judge = new GameResultJudgmentTest();
  }
  @Test
  void GameResultJudgmentCreateWithMaxLen() {
    judge = new GameResultJudgmentTest(maxLen);
  }
}