package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        boolean continueProcess = true;
        while (continueProcess) {
            continueProcess = baseballGame.operate(Console.readLine());
        }
    }
}
