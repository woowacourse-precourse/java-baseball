package baseball.domain.game;

import baseball.utils.Input;

public class GameContinuity {
  public static final String STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
  public static final String GAME_CONTINUITY_MESSAGE = "게임을 새로 시작하려면 1, 종료하면 2를 입력하세요.";
  public static final String USER_INPUT_ERROR_MESSAGE = "게임 지속 여부에 관련해서는 1과 2만 입력해야합니다.";

  public final Integer RESTART = 1;
  public final Integer CLOSE = 2;

  private Boolean continuity = false;

  public GameContinuity(){
    printGameContinuityMessage();
    userInputForGameContinuity();
  }

  public GameContinuity(Integer input) {
    validateUserInput(input);
    this.continuity = input.equals(RESTART);
  }

  public void printGameContinuityMessage(){
    System.out.println(STRIKE_MESSAGE);
    System.out.println(GAME_CONTINUITY_MESSAGE);
  }

  public void userInputForGameContinuity(){
    Integer input = new Input().toInt();
    validateUserInput(input);
    this.continuity = input.equals(RESTART);
  }

  public void validateUserInput(Integer input) {
    if(!input.equals(RESTART) && !input.equals(CLOSE)){
      throw new IllegalArgumentException(USER_INPUT_ERROR_MESSAGE);
    }
  }

  public Boolean getContinuity() {
    return this.continuity;
  }
}
