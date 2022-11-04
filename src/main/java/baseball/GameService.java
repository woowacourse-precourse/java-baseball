package baseball;

public class GameService {

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
}
