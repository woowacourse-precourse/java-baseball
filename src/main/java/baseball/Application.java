package baseball;

import baseball.gamer.Gamer;
import baseball.gamer.User;
import baseball.problemmaker.Computer;
import baseball.problemmaker.ProblemMaker;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseballGame baseballGame = initBaseBallGame();
        startGame(baseballGame);
    }

    private static void startGame(BaseballGame baseballGame) {
        baseballGame.start();

        if (!baseballGame.isFinished()) {
            baseballGame = initBaseBallGame();
            startGame(baseballGame);
        }
    }

    private static BaseballGame initBaseBallGame() {
        Numbers randomNumbers = Numbers.createRandomNumbers();
        ProblemMaker problemMaker = new Computer(randomNumbers);

        Numbers selectedNumbers = Numbers.createInputNumbers();
        Gamer gamer = new User(selectedNumbers);

        return new BaseballGame(problemMaker, gamer);
    }
}
