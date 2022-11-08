package baseball.game;

public interface Game {

  public void GameInit();

  public void GameReady();

  public void GameStart();

  public void GameScore();

  public void GameResult();

  public void GameContinuity();

  public boolean GameFlag();

  public boolean isStrike();
}
