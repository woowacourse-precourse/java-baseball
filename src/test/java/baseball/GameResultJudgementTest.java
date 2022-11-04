package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameResultJudgementTest {

  GameResultJudgement judge;
  @BeforeEach
  void GameResultJudgmentCreate() {
    judge = new GameResultJudgement();
  }
  @Test
  void GameResultJudgmentCreateWithMaxLen() {
    judge = new GameResultJudgement(3);
  }
}