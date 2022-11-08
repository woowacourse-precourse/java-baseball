package baseball;

public class PlayBaseBallGame {
    public void playGame() {
        PrintMessage message = new PrintMessage();
        InputNumber number = new InputNumber();
        BaseBallCount countBaseBall = new BaseBallCount();
        Exception exception = new Exception();

        message.printStartBaseballGame();
        number.inputComputerBaseballNumber();

        while (true) {
            message.printInputBaseballNumber();
            number.inputUserBaseballNumber();
            exception.checkInputException(number.userBaseBallNumber);
            countBaseBall.countBallNumber(number.computerBaseBallNumber, number.userBaseBallNumber);
            countBaseBall.countStrikeNumber(number.computerBaseBallNumber, number.userBaseBallNumber);
            message.printHint(countBaseBall.numberOfStrike, countBaseBall.numberOfBall);

            if (countBaseBall.numberOfStrike == 3) {
                message.printCorrectAnswer();
                message.printReGame();
                break;
            }
        }
    }

}
