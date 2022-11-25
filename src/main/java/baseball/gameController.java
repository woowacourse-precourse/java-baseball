package baseball;

import java.util.List;

public class gameController {

    public void run() {
        Game game = new Game();
        game.setComputerNumber();
        IO.printStartMSG();

        while (game.runState) {
            IO.printNumberInputMSG();
            game.setUserNumber(IO.userInput());
            game.calculateBallAndStrikeResult();

            List<Integer> result = game.result;
            IO.printResult(result.get(0), result.get(1));

            if (result.get(1) == 3) {
                IO.printClearMSG();
                IO.printRestartMSG();
                game.retry(IO.retryInput());
            }
        }
    }
}
