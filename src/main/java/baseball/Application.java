package baseball;
public class Application {
    public static void main(String[] args) {
        ComputerBallNumber computerBallNumber = new ComputerBallNumber();
        computerBallNumber.getComputerBalls();
        ResultView.printStartGame();
        while (true) {
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
