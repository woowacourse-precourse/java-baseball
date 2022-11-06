package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        Game game = new Game();
        boolean continueProcess = true;
        while (continueProcess) {
            continueProcess = game.operate(Console.readLine());
        }
    }
}
