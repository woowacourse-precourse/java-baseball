package baseball;

import static baseball.Utils.isDistinct;
import static baseball.Utils.isNumeric;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class that handle the input of console.
 */
public class Input {

  /**
   * Scan input from console.
   * @return list of integer if input is validated.
   */
  public static List<Integer> answer() {
    System.out.print("숫자를 입력해주세요: ");
    String userInput = readLine();

    if (!validateAnswerFormat(userInput)) {
      throw new IllegalArgumentException();
    }

    return Arrays.stream(userInput.split(""))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  /**
   * Scan input from console to restart game.
   * @return true if input is 1, false if input is 2.
   * @exception IllegalArgumentException if input is not in 1 or 2.
   */
  public static boolean restart() {
    System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    String input = readLine();

    if (input.equals("1")) {
      return true;
    } else if (input.equals("2")) {
      return false;
    }

    throw new IllegalArgumentException();
  }

  /**
   * Verify string is the same format as the correct answer.
   * @param string the string to be checked.
   * @return true if string is a different number of three digits.
   */
  private static boolean validateAnswerFormat(String string) {
    return string.length() == 3
        && isNumeric(string)
        && isDistinct(string);
  }
}
