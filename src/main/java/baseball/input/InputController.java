package baseball.input;

import baseball.hint.Hint;
import java.util.List;

public interface InputController {

    boolean checkValidAnswer(String userInput);

    List<Integer> convertToIntegerList(String userInput);

    String convertHintToString(Hint hint);
}
