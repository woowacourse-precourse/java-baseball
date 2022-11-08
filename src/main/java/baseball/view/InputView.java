package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.constants.Message.*;

public class InputView {

  public static String getUserNumber() {
    System.out.println(INPUT_NUMBER_MESSAGE);
    return Console.readLine();
  }

  public static String getRestartStatus() {
    System.out.println(ASK_RESTART_MESSAGE);
    return Console.readLine();
  }

}
