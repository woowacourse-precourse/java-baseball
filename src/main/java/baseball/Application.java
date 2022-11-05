package baseball;

import baseball.participant.Player;
import baseball.service.BaseballGameConsole;

public class Application {
    public static void main(String[] args) {
        BaseballGameConsole gameConsole = new BaseballGameConsole();
        Player codesver = new Player("codesver");
        gameConsole.playGameWithPlayer(codesver);
    }
}
