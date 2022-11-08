package baseball;

public class PlayBaseBallGame {
    public void playGame() {
        PrintMessage message = new PrintMessage();
        InputNumber number = new InputNumber();
        BaseBallCount countBaseBall = new BaseBallCount();

        message.printStartBaseballGame();
        number.inputComputerBaseballNumber();

        while (true) {
            message.printInputBaseballNumber();
            number.inputUserBaseballNumber();
            countBaseBall.countBallNumber(number.computerBaseBallNumber, number.userBaseBallNumber);
            countBaseBall.countStrikeNumber(number.computerBaseBallNumber, number.userBaseBallNumber);
            message.printHint(countBaseBall.numberOfStrik, countBaseBall.numberOfBall);

            if (countBaseBall.numberOfStrik == 3) {
                message.printCorrectAnswer();
                message.printReGame();
                break;
            }
        }
    }

}
