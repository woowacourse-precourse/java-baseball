package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Set;

public class Application {
    static final Set<String> CONTROL_NUMBER = Set.of("1", "2");

    public static void main(String[] args) {
        PrintComment.printStartComment();
        Game game = new Game();
        do {
            PrintComment.printInputComment();
            String userInput = Console.readLine();
            GameState gameState = game.compareNumbers(userInput);
        } while(true);
    }

    public static boolean validUserInputControl(String num) {
        if (!CONTROL_NUMBER.contains(num)) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
