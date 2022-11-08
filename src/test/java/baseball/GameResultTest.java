package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameResultTest {
  @Test
  void 두_숫자로_올바른_결과가_나오는가() {
    // given
    GameNumber answerGameNumber = new GameNumber();
    answerGameNumber.setGameNumberByString("123");
    GameNumber gameNumber1 = new GameNumber();
    gameNumber1.setGameNumberByString("456");
    GameNumber gameNumber2 = new GameNumber();
    gameNumber2.setGameNumberByString("231");
    GameNumber gameNumber3 = new GameNumber();
    gameNumber3.setGameNumberByString("132");
    GameNumber gameNumber4 = new GameNumber();
    gameNumber4.setGameNumberByString("123");

    // when
    GameResult gameResult1 = new GameResult();
    gameResult1.setResultByGameNumber(answerGameNumber, gameNumber1);
    GameResult gameResult2 = new GameResult();
    gameResult2.setResultByGameNumber(answerGameNumber, gameNumber2);
    GameResult gameResult3 = new GameResult();
    gameResult3.setResultByGameNumber(answerGameNumber, gameNumber3);
    GameResult gameResult4 = new GameResult();
    gameResult4.setResultByGameNumber(answerGameNumber, gameNumber4);

    // then
    assertEquals(gameResult1.getResultString(), "낫싱");
    assertEquals(gameResult2.getResultString(), "3볼 ");
    assertEquals(gameResult3.getResultString(), "2볼 1스트라이크");
    assertEquals(gameResult4.getResultString(), "3스트라이크");
  }
}
