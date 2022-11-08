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
