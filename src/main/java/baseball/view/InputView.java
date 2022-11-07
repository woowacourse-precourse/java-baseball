package baseball.view;
import static baseball.message.ExceptionMessage.*;

import java.util.Optional;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

  public String[] inputNumbers(){
    String inputString = read();
    checkDigit(inputString);
    return splitInput(inputString);
  }

  public String read() {
    return Optional
        .ofNullable(Console.readLine())
        .orElseThrow(() ->
                         new IllegalArgumentException(NULL_INPUT.getErrorMessage()));
  }

  public String[] splitInput(String inputString){
    return inputString.split("");
  }

  public void checkDigit(String inputString){
    if(!Pattern.compile("^[1-9]$").matcher(inputString).matches()){
      throw new IllegalArgumentException(INCORRECT_INPUT.getErrorMessage());
    }
  }

}
