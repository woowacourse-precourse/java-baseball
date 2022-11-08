package baseball.controller;

import baseball.domain.ComputerNumber;
import baseball.domain.MyNumber;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
  private final MyNumber myNumber;
  private final ComputerNumber computerNumber;
  private final Exception exception;
  private final Judgement judgement;

  public BaseballGame() {
    myNumber = new MyNumber();
    computerNumber = new ComputerNumber();
    exception = new Exception();
    judgement = new Judgement();
    View.printGameStart();
  }

  public void gameStart() {
    computerNumber.setComputerNumber();
    View.printInputMyNumber();
    do {
      String inputMyNumbers = Console.readLine();
      if (exception.isValidMyInput(inputMyNumbers)) {
        myNumber.setMyNumber(inputMyNumbers);
      }
      judgement.judgeStrikeAndBall(myNumber.getMyNumber(), computerNumber.getComputerNumber());
    } while (!judgement.isThreeStrike());

    View.printEndGame();
    String inputRestartOrExitNumber = Console.readLine();
    if (exception.isValidRestartOrExitNumber(inputRestartOrExitNumber)) {
      gameStart();
    }
  }
}
