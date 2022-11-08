package baseball;

import baseball.baseball.BaseballGame;
import baseball.baseball.RandomBaseballGame;

public class Application {
    public static void main(String[] args) {
        RandomBaseballGame randomBaseballGame = new RandomBaseballGame(new BaseballGame());
        GameConsole gameConsole = new GameConsole();

        ConsoleRandomBaseballGame consoleGame = new ConsoleRandomBaseballGame(randomBaseballGame, gameConsole);

        consoleGame.play();
    }
}
