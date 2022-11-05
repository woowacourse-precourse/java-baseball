package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void enterInput() {
        System.out.print(Constants.ENTER_INPUT_MESSAGE);
        String input = Console.readLine();

        if (Utils.isValidUserAnswerInput(input)) {
            this.numbers = Utils.intToList(Integer.valueOf(input));
        } else {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_MESSAGE);
        }
    }

    public boolean enterRestartOrNot() {
        System.out.println(Constants.GAME_RESTART_SELECT_MESSAGE);
        String input = Console.readLine();

        if (Utils.isValidUserRestartInpit(input)) {
            if ("1".equals(input)) {
                return true;
            } else if ("2".equals(input)) {
                return false;
            }
        } else {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_MESSAGE);
        }
        return false;
    }
}
