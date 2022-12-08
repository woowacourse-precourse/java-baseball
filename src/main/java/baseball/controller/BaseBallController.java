package baseball.controller;

import baseball.BaseBallGenerator;
import baseball.RandomNumberGenerator;
import baseball.domain.Answer;
import baseball.domain.Computer;
import baseball.domain.Judge;
import baseball.domain.ScoreBoard;
import baseball.utils.BaseBallStatus;
import baseball.view.InputView;
import baseball.view.OutputView;

import static baseball.utils.BaseBallStatus.BASEBALL_DEFAULT_SIZE;

public class BaseBallController {


    private final InputView inputView;
    private final OutputView outputView;
    private final Computer computer;
    private final RandomNumberGenerator numberGenerator;

    private Answer answer;
    private Judge judge;

    public BaseBallController() {
        inputView = new InputView();
        outputView = new OutputView();
        numberGenerator = new BaseBallGenerator();
        computer = new Computer(numberGenerator);
    }

    private void init() {
        Answer generate = computer.generate();
        judge = new Judge(generate);
    }

    public void play() {
        init();
        progressing();

        int restartFlag = inputView.getRestartFlag();
        endProgress(restartFlag);
    }

    private void endProgress(int restartFlag) {
        if (BaseBallStatus.isRestart(restartFlag)) {
            play();
        }
    }

    private void progressing() {
        ScoreBoard scoreBoard;
        do {
            Answer gussNumber = inputView.getInputNumber();
            scoreBoard = judge.getScoreBoard(gussNumber);
            outputView.baseBallResult(scoreBoard);
        }
        while (!isEnd(scoreBoard));
    }

    private boolean isEnd(ScoreBoard scoreBoard) {
        return scoreBoard.getStrike() == BASEBALL_DEFAULT_SIZE.getCode();
    }
}
