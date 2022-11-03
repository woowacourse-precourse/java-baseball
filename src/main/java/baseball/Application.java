package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    static final int ANSWER_COUNT = 3;
    static final String RESTART = "1";
    static final String END = "2";
    static boolean isContinue = true;

    public static void main(String[] args) {
        PrintComment.printStartComment();
        Game game = new Game();
        do {
            PrintComment.printInputComment();
            String userInput = Console.readLine();
            GameState gameState = game.compareNumbers(userInput);
            PrintComment.printUserInput(userInput);
            PrintComment.printGameState(gameState);
            if (gameState.getStrike()!=ANSWER_COUNT) {
                continue;
            }
            PrintComment.printCorrectComment();
        } while(isContinue);
    }

    public static boolean isRestart(String num) {
        if (num.equals(RESTART)) {
            return true;
        }
        if (num.equals(END)) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
