package baseball.domain.game;

public class BaseballGame {
  private GameImpl baseball = new GameImpl();

  public BaseballGame(){
    baseball.GameInit();
    baseball.GameReady();

    while(baseball.GameFlag()){
      baseball.GameStart();
      baseball.GameScore();
      baseball.GameResult();

      if(baseball.isStrike()){
        baseball.GameContinuity();
      }
    }
  }
}
