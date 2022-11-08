package baseball.input;

import baseball.hint.Hint;
import java.util.List;

public interface InputController {
    
    List<Integer> convertToIntegerList(String userInput);

    String convertHintToString(Hint hint);
}
