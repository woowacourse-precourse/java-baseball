package baseball.domain.score;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameResultTest {

  private Result board;

  @Test
  @DisplayName("점수 결과가 낫싱일 경우")
  void print_nothing(){
    board = new Result(0,0);
    assertEquals("낫싱", board.getResults());
  }

  @Test
  @DisplayName("점수 결과가 3스트라이크일 경우")
  void print_3_strike(){
    board = new Result(3,0);
    assertEquals("3스트라이크", board.getResults());
  }

  @Test
  @DisplayName("점수 결과가 1볼 2스트라이크일 경우")
  void print_1_ball_2_strike(){
    board = new Result(2,1);
    assertEquals("1볼 2스트라이크", board.getResults());
  }

  @Test
  @DisplayName("점수 결과가 2볼 2스트라이크일 경우")
  void print_2_ball_2_strike(){
    board = new Result(2,2);
    assertEquals("2볼 2스트라이크", board.getResults());
  }

  @Test
  @DisplayName("점수 결과가 3볼 2스트라이크일 경우")
  void print_3_ball_2_strike(){
    board = new Result(2,3);
    assertEquals("3볼 2스트라이크", board.getResults());
  }
}