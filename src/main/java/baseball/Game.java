package baseball;

import java.util.List;

public class Game {

    public void play(List<BallNumber> randomBallNumbers) {
        System.out.print("서로 다른 3자리 숫자를 입력해주세요. ");
        User user = new User();
        BallNumbers gameBallNumbers = new BallNumbers(randomBallNumbers);
        boolean keepGoing = false;
        while(!keepGoing) {
            BallNumbers userBallNumbers = new BallNumbers(user.createBallNumber());
            GameResult gameResult = userBallNumbers.compareToBallNumbers(gameBallNumbers);
            gameResult.makePrintMessageByGameResult();
            gameResult.print();
            keepGoing = gameResult.stop();
        }
    }

    public boolean restart() {
        User user = new User();
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return user.choiceRestartOrStop().equals("1");
    }
}
