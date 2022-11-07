package baseball.console;

import baseball.dto.GameInputNumber;
import baseball.dto.InputSignal;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput {

  public GameInputNumber inputNumber(){
    final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    System.out.print(INPUT_NUMBER_MESSAGE);

    String inputString = Console.readLine();
    return new GameInputNumber(inputString);
  }

  public InputSignal inputSignal(){
    final String INPUT_SIGNAL_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    System.out.println(INPUT_SIGNAL_MESSAGE);

    String inputStr = Console.readLine();
    return new InputSignal(inputStr);
  }
}
