package baseball.game;


import static org.assertj.core.api.Assertions.assertThat;

import baseball.dto.GameInputNumber;
import java.util.List;
import org.junit.jupiter.api.Test;

class BaseballGameTest {



  @Test
  void 스트라이크_갯수_테스트_1(){
    List<Integer> computerNumber = List.of(1,2,3);
    GameInputNumber userInput = new GameInputNumber("125");

    BaseballGame baseballGame = new BaseballGame(computerNumber);

    GameResult result = baseballGame.start(userInput);
    assertThat(result.getStrike()).isEqualTo(2);
  }

  @Test
  void 스트라이크_갯수_테스트_2(){
    List<Integer> computerNumber = List.of(1,2,3);
    GameInputNumber userInput = new GameInputNumber("312");

    BaseballGame baseballGame = new BaseballGame(computerNumber);

    GameResult result = baseballGame.start(userInput);
    assertThat(result.getStrike()).isEqualTo(0);
  }

  @Test
  void 스트라이크_볼_결과_확인(){
    List<Integer> computerNumber = List.of(1,2,3);
    GameInputNumber userInput = new GameInputNumber("321");

    BaseballGame baseballGame = new BaseballGame(computerNumber);
    GameResult result = baseballGame.start(userInput);

    assertThat(result.getStrike()).isEqualTo(1);
    assertThat(result.getBall()).isEqualTo(2);
  }
}