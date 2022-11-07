package baseball;

import baseball.dto.BallCount;
import baseball.gamer.Gamer;
import baseball.problemmaker.ProblemMaker;

public class BaseballGame {

    private final ProblemMaker problemMaker;
    private final Gamer gamer;

    private boolean isFinished;

    public BaseballGame(ProblemMaker problemMaker, Gamer gamer) {
        this.problemMaker = problemMaker;
        this.gamer = gamer;
        this.isFinished = false;
    }

    public void start() {
        BallCount ballCount = problemMaker.findBallCount(gamer.getNumbers());
        problemMaker.printHintOfBallCount(ballCount);
        boolean isFinishedCurrentGame = problemMaker.isFinishedCurrentGame(ballCount);

        while (!isFinishedCurrentGame) {
            Numbers gamerNumbers = gamer.changeNumbers();
            ballCount = problemMaker.findBallCount(gamerNumbers);

            problemMaker.printHintOfBallCount(ballCount);
            isFinishedCurrentGame = problemMaker.isFinishedCurrentGame(ballCount);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        isFinished = gamer.chooseToFinishGame();
    }

    public boolean isFinished() {
        return isFinished;
    }
}
