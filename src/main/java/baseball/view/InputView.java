package baseball.view;
import static baseball.message.ExceptionMessage.*;
import static baseball.util.setting.MenuSetting.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

  public static List<Integer> inputNumbers(){
    String inputString = read();
    checkEmpty(inputString);
    checkDigit(inputString);
    return convertStringToIntegerList(splitInput(inputString));
  }

  public static int inputMenu(){
    String inputString = read();
    checkEmpty(inputString);
    checkDigit(inputString);
    validateMenu(inputString);
    return Integer.parseInt(inputString);
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

  public static void checkEmpty(String inputString){
    if(inputString.equals("")){
      throw new IllegalArgumentException(NULL_INPUT.getErrorMessage());
    }
  }

  public static void checkDigit(String inputString){
    if(!(Pattern.compile("^[1-9]*$").matcher(inputString).matches())){
      throw new IllegalArgumentException(INCORRECT_INPUT.getErrorMessage());
    }
  }

  public static void validateMenu(String inputString){
    if(!(Integer.parseInt(inputString) == RESTART_GAME.getMenuNumber()
        || Integer.parseInt(inputString) == END_GAME.getMenuNumber())){
      throw new IllegalArgumentException(INCORRECT_MENU_NUMBER.getErrorMessage());
    }
  }

}
