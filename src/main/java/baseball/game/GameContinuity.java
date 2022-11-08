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

  public void printGameContinuityMessage(){
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    System.out.println("게임을 새로 시작하려면 1, 종료하면 2를 입력하세요.");
  }

  public void continuityInput(){
    Integer input = new Input().toInt();
    if(!input.equals(RESTART) && !input.equals(CLOSE)){
      throw new IllegalArgumentException("invalid user input");
    }

    this.continuity = input.equals(RESTART);
  }

}
