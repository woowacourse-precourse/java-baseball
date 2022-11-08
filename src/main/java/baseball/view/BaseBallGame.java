package baseball.view;

import baseball.controller.BaseBallGameController;
import baseball.model.BallCount;
import baseball.service.BallCountService;
import baseball.util.Answer;
import baseball.util.Constant;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/08
 */
public class BaseBallGame {
    // TODO: 게임 실행부 작성
    public void start() {
        List<Integer> answer = Answer.create();
        List<Integer> userAnswer;
        do {
            // TODO: 게임 로직 작성
            System.out.println(Constant.INPUT_MESSAGE);
            userAnswer = BaseBallGameController.inputUserAnswer();
            BallCount ballCount = BallCountService.calc(answer, userAnswer);
            System.out.println(ballCount.toString());
            // TODO: 게임 진행 중 콘솔로 출력되는 Comment 출력
        } while(!isFinished(answer, userAnswer));
        System.out.println(Constant.FINISH_MESSAGE);
    }

    // TODO: 게임 종료 여부 판단
    private boolean isFinished(List<Integer> answer, List<Integer> userAnswer) {
        // TODO: input data와 answer가 같은지 비교
        return answer.equals(userAnswer);
    }

    public boolean isRestart() {
        return BaseBallGameController.isRestart();
    }
}