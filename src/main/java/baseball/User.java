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
        String input = Console.readLine();

        if (Utils.isValidUserInput(input)) {
            this.numbers = Utils.intToList(Integer.valueOf(input));
        } else {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }
}
