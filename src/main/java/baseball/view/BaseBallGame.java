package baseball.view;

import baseball.controller.BaseBallGameController;
import baseball.util.Answer;
import baseball.util.Constant;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/08
 */
public class BaseBallGame {
    private final BaseBallGameController baseBallGameController;

    public BaseBallGame(BaseBallGameController baseBallGameController) {
        this.baseBallGameController = baseBallGameController;
    }

    // 게임 실행
    public void start() {
        System.out.println(Constant.START_MESSAGE);
        do {
            playGame();   // 게임 시작
        } while (isRestart());
    }

    // 게임 실행 1회
    private void playGame() {
        List<Integer> answer = Answer.create();
        List<Integer> userAnswer = List.of(0, 0, 0);
        while(!baseBallGameController.isFinish(answer,userAnswer)){
            System.out.print(Constant.INPUT_MESSAGE);
            userAnswer = baseBallGameController.inputUserAnswer();
            System.out.println(baseBallGameController.calcBallCount(answer, userAnswer));
        }
        System.out.println(Constant.FINISH_MESSAGE);
    }

    // 게임 재시작 여부 판단
    public boolean isRestart() {
        System.out.println(Constant.RESTART_COMMENT);
        return baseBallGameController.isRestart();
    }
}