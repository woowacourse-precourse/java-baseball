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
<<<<<<< HEAD
            int ballCounts = result.get(0);
            int strikeCounts = result.get(1);
            IO.printResult(ballCounts, strikeCounts);

            if (strikeCounts == 3) {
=======
            IO.printResult(result.get(0), result.get(1));

            if (result.get(1) == 3) {
>>>>>>> d8ee934 ([Refactoring] All-new)
                IO.printClearMSG();
                IO.printRestartMSG();
                game.retry(IO.retryInput());
            }
        }
    }
<<<<<<< HEAD

=======
>>>>>>> d8ee934 ([Refactoring] All-new)
}
