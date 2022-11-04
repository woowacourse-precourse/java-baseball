package baseball;

public class GameService {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

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
}
