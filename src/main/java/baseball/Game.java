package baseball;

public class Game {
    private GameNumbers answer;

    public static void runWithRestarts() {
        GameInteractor.printGameStart();

        boolean restart = true;
        while (restart) {
            new Game().runSingleGame();
            restart = GameInteractor.promptUserForGameRestart();
        }
    }

    private void runSingleGame() {
        initalize();

        boolean gameFinished = false;
        while (!gameFinished) {
            GuessResult res = processGuess();
            if (res.isCorrect()) {
                gameFinished = true;
                GameInteractor.printGameFinishedBySuccess();
            }
        }
    }

    private void initalize() {
        answer = GameNumbers.ofRandom();
    }

    private GuessResult processGuess() {
        GuessResult res = evaluateGuess();
        GameInteractor.printGuessResult(res);
        return res;
    }

    private GuessResult evaluateGuess() {
        GameNumbers guess = GameInteractor.promptUserForNumbers();
        return answer.evaluate(guess);
    }
}