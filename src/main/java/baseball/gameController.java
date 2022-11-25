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
            int ballCounts = result.get(0);
            int strikeCounts = result.get(1);
            IO.printResult(ballCounts, strikeCounts);

            if (strikeCounts == 3) {
                IO.printClearMSG();
                IO.printRestartMSG();
                game.retry(IO.retryInput());
            }
        }
    }

}
