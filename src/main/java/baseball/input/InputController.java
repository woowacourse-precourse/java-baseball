package baseball.input;

import java.util.List;

public interface InputController {

    boolean checkValidAnswer(String userInput);

    List<Integer> convertToIntegerList(String userInput);
}
