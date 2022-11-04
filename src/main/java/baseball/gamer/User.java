package baseball.gamer;

import baseball.Numbers;
import camp.nextstep.edu.missionutils.Console;

public class User implements Gamer {

    private Numbers numbers;

    public User(Numbers numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean isFinishedGame() {
        String input = Console.readLine();
        validateInput(input.trim());

        return !input.equals("1");
    }

    private void validateInput(String input) {
        String expression = "^[1-2]+$";
        if (input.length() != 1 || !input.matches(expression)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 1이나 2를 입력해주세요.");
        }
    }

    @Override
    public Numbers changeNumbers() {
        Numbers numbers = Numbers.createInputNumbers();
        this.numbers = numbers;
        return numbers;
    }
}
