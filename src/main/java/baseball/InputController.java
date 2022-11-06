package baseball;

import java.util.List;

public interface InputController {

    boolean checkValid(String userInput);

    List<Integer> convertToIntegerList(String userInput);
}
