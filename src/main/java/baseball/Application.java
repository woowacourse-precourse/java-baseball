package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballGameConsole gameConsole = new BaseballGameConsole();
        Player codesver = new Player("codesver");
        gameConsole.playGame(codesver);
    }
}
