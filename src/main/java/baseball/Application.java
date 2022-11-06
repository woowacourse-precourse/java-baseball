package baseball;

import java.util.NoSuchElementException;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static Boolean isEnd = false;

    public static void main(String[] args) {
        isEnd = false;

        while (isEnd.equals(false)) {
            Game game = new Game();
            game.start();
            setIsEnd(getInput());
        }
    }

    private static String getInput() {
        try {
            return validateInput(Console.readLine());
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("입력값이 없습니다. 애플리케이션을 종료합니다.");
        }
    }

    private static String validateInput(String input) {
        final Pattern pattern = Pattern.compile("^[1-2]*$");
        if (!pattern.matcher(input).matches() || input.length() != 1) {
            throw new IllegalArgumentException("잘못된 입력값입니다. 애플리케이션을 종료합니다.");
        }
        return input;
    }

    private static void setIsEnd(String input) {
        if ("1".equals(input)) {
            isEnd = false;
        } else if ("2".equals(input)) {
            isEnd = true;
        } else {
            throw new IllegalArgumentException("잘못된 입력값입니다. 애플리케이션을 종료합니다.");
        }
    }
}
