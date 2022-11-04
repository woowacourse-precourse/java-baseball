package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

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

    public String getUserInput() {
        return readLine();
    }

    public String getUserInputNumber() {
        System.out.print("숫자를 입력해 주세요 : ");

        return getUserInput();
    }

    public String getUserInputRegame() {
        System.out.println("재시작을 하려면 1을, 게임을 종료하려면 2를 눌러주세요. : ");

        return getUserInput();
    }
}
