package baseball;

import baseball.participant.Pitcher;
import baseball.service.BaseballGameConsole;

public class Application {
    public static void main(String[] args) {
        BaseballGameConsole gameConsole = new BaseballGameConsole();
        Pitcher codesver = new Pitcher("codesver");
        gameConsole.startWithPitcher(codesver);
    }
}
