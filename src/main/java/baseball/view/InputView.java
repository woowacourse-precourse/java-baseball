package baseball.view;
import static baseball.message.ExceptionMessage.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

  public static List<Integer> inputNumbers(){
    String inputString = read();
    checkDigit(inputString);
    return convertStringToIntegerList(splitInput(inputString));
  }

  public static String read() {
    return Optional
        .ofNullable(Console.readLine())
        .orElseThrow(() ->
                         new IllegalArgumentException(NULL_INPUT.getErrorMessage()));
  }

  private static List<Integer> convertStringToIntegerList(String[] inputArray){
    return Arrays
        .stream(inputArray)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  public static String[] splitInput(String inputString){
    return inputString.split("");
  }

  public static void checkDigit(String inputString){
    if(!Pattern.compile("^[1-9]$").matcher(inputString).matches()){
      throw new IllegalArgumentException(INCORRECT_INPUT.getErrorMessage());
    }
  }

}
