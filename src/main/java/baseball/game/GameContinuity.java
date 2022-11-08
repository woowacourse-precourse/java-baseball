package baseball.game;

import baseball.utils.Input;

public class GameContinuity {

  public final Integer RESTART = 1;
  public final Integer CLOSE = 2;

  private Boolean continuity = false;

  public GameContinuity(){
    printGameContinuityMessage();
    continuityInput();
  }
  
}
