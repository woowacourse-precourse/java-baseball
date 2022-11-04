package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameService {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String RESTART = "1";
    private static final String QUIT = "2";
    private static final int THREE_STRIKE = 3;

    private final InputBallNumber inputBallNumber;
    private final RandomBallNumber randomBallNumber;

    public GameService(InputBallNumber inputBallNumber, RandomBallNumber randomBallNumber) {
        this.inputBallNumber = inputBallNumber;
        this.randomBallNumber = randomBallNumber;
    }

    public Result checkStrikeAndBall() {
        String randomNumber = randomBallNumber.createRandomNumber();
        String inputNumber = inputBallNumber.inputBallNumber();

        int strike = 0;
        int ball = 0;
        for (int ballNumber = 0; ballNumber < inputNumber.length(); ballNumber++) {
            if (isEqualNumber(randomNumber, inputNumber, ballNumber)) {
                strike++;
                continue;
            }
            if (existNumber(randomNumber, inputNumber, ballNumber)) {
                ball++;
            }
        }
        return new Result(strike, ball);
    }

    private boolean existNumber(String randomNumber, String inputNumber, int ballNumber) {
        return randomNumber.contains(inputNumber.substring(ballNumber, ballNumber + 1));
    }

    private boolean isEqualNumber(String randomNumber, String inputNumber, int ballNumber) {
        return inputNumber.charAt(ballNumber) == randomNumber.charAt(ballNumber);
    }

    public void printResult(Result result) {
        int strike = result.getStrike();
        int ball = result.getBall();

        isThreeStrike(strike);
        isStrikeAndBall(strike, ball);
        isOnlyBall(strike, ball);
        isOnlyStrike(strike, ball);
        isNothing(strike, ball);
    }

    public void reenterOrEndGame(Result result) {
        int strike = result.getStrike();
        if (strike == THREE_STRIKE) {
            restartOrQuitGame();
        }
        if (strike != THREE_STRIKE) {
            playGame();
        }
    }

    public void playGame() {
        Result strikeAndBall = checkStrikeAndBall();
        printResult(strikeAndBall);
        reenterOrEndGame(strikeAndBall);
    }

    private void isOnlyStrike(int strike, int ball) {
        if (strike < 3 && strike > 0 && ball == 0) {
            System.out.println(strike + STRIKE);
        }
    }

    private void isNothing(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING);
        }
    }

    private void isOnlyBall(int strike, int ball) {
        if (strike == 0 && ball != 0) {
            System.out.println(ball + BALL);
        }
    }

    private void isStrikeAndBall(int strike, int ball) {
        if (strike != 0 && ball != 0) {
            System.out.println(ball + BALL + " " + strike + STRIKE);
        }
    }

    private void isThreeStrike(int strike) {
        if (strike == 3) {
            System.out.println(strike + STRIKE);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private void restartOrQuitGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String num = Console.readLine();
        isNotRestartAndQuit(num);
        isRestartGame(num);
    }

    private void isRestartGame(String num) {
        if (num.equals(RESTART)) {
            randomBallNumber.clearRandomNumber();
            playGame();
        }
    }

    private void isNotRestartAndQuit(String num) {
        if (!num.equals(RESTART) && !num.equals(QUIT)) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요");
        }
    }
}
