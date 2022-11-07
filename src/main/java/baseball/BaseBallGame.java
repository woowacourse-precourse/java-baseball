package baseball;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/07
 */
public class BaseBallGame {
    // TODO: 게임 실행부 작성
    private static final int LENGTH_OF_NUMBER = 3;
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String FINISH_MESSAGE = LENGTH_OF_NUMBER + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public void start() {
        // TODO: 게임 진행시 처음에만 출력되는 Comment 출력
        System.out.println(START_MESSAGE);
        List<Integer> answer = BaseBallGameUtil.createAnswerByLength(LENGTH_OF_NUMBER);
        List<Integer> userAnswer;
        do {
            // TODO: 게임 로직 작성
            System.out.print(INPUT_MESSAGE);
            userAnswer = BaseBallGameUtil.inputUserAnswer();
            BallCount ballCount = new BallCount(answer, userAnswer);
            System.out.println(ballCount.toString());
            // TODO: 게임 진행 중 콘솔로 출력되는 Comment 출력
        } while(isFinished(answer, userAnswer));
        System.out.println(FINISH_MESSAGE);
    }

    // TODO: 게임 종료 여부 판단
    private boolean isFinished(List<Integer> answer, List<Integer> userAnswer) {
        // TODO: input data와 answer가 같은지 비교
        return !answer.equals(userAnswer);
    }
}
