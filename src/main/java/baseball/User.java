package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class User {

    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void enterInput() {
        System.out.print(Constants.ENTER_INPUT_MESSAGE);
        String input = Console.readLine();

        if (Utils.isValidUserAnswerInput(input)) {
            this.numbers = Utils.intToList(Integer.parseInt(input));
        } else {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_MESSAGE);
        }
    }

    public boolean enterRestartOrNot() {
        System.out.println(Constants.GAME_RESTART_SELECT_MESSAGE);
        String input = Console.readLine();

        if ("1".equals(input)) {
            return true;
        } else if ("2".equals(input)) {
            return false;
        } else {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_MESSAGE);
        }
    }
}
