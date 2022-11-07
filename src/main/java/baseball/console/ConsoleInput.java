package baseball.console;

import baseball.dto.GameInputNumber;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput {

  public GameInputNumber inputNumber(){
    final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    System.out.print(INPUT_NUMBER_MESSAGE);

    String inputString = Console.readLine();
    return new GameInputNumber(inputString);
  }
}
