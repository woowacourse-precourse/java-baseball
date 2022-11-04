package baseball;

public class BaseballGame {
    public void playGame() {
        do {
            startGame();
        } while (reGame());
    }

    public void startGame() {
        Computer computer = new Computer();
        Result result;
        String randomBall = computer.makeRandomBall();

        do {
            result = Result.compareBall(getUserInputNumber(), randomBall);
            printResult(result);
        } while (!Result.isAllStriek);
    }

    private boolean reGame() {
        String doReGame = getUserInputRegame();

        return doReGame.equals("1");
    }
}
