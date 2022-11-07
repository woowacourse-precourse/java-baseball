package baseball;

public class Application {
    public static void main(String[] args) {
        boolean is3Strike = false;
        boolean isDone = false;

        ComputerBallNumber computerBallNumber = new ComputerBallNumber();
        computerBallNumber.getComputerBalls();
        ResultView.printStartGame();
        while (!is3Strike && !isDone) {
            String inputBallNumber = InputView.inputBallNumber();
            Balls balls = new Balls(inputBallNumber);
            UserBallNumber userBallNumber = new UserBallNumber(balls.numbers);
            CompareBallNumber compareBallNumber = new CompareBallNumber();
            ResultView.printResult(compareBallNumber.checkMatchBalls(userBallNumber.getUserBallNumber(), computerBallNumber.numbers));
            if (ResultView.determineStopOrNot(computerBallNumber)) {
                break;
            }
        }
    }
}
