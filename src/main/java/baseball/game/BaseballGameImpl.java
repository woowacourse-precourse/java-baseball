package baseball.game;

public class BaseballGameImpl {
  private GameImpl baseball = new GameImpl();

  public BaseballGameImpl(){
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
