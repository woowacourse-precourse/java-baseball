package baseball;

public class Stadium {
    Computer computer = new Computer();
    User user = new User();
    Referee referee = new Referee();

    protected void playGame() {
        computer.createAnswerNumber();
        referee.clearBallCount();
        while (referee.strike != 3) {
            user.scanUserNumber();
            referee.calculateBallCount(computer.computerNumber, user.userNumber);
            referee.printBallCount(referee.strike, referee.ball);
        }
        computer.printRestartMessage();
        computer.restartOrNot();
    }
}