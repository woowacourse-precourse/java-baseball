package baseball;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/07
 */
public class BaseBallGame {
    private static final int LENGTH_OF_NUMBER = 3;
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String FINISH_MESSAGE = LENGTH_OF_NUMBER + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static void start() {
        System.out.println(START_MESSAGE);
        playGame();
        System.out.println(FINISH_MESSAGE);
    }

    private static void playGame() {
        List<Integer> answer = BaseBallGameUtil.createAnswerByLength(LENGTH_OF_NUMBER);
        List<Integer> userAnswer = List.of(0, 0, 0);
        while(!isFinished(answer,userAnswer)){
            System.out.print(INPUT_MESSAGE);
            userAnswer = BaseBallGameUtil.inputUserAnsweByLength(LENGTH_OF_NUMBER);
            System.out.println(BallCount.calc(answer, userAnswer));
        }
    }

    // 게임 종료 여부 판단
    private static boolean isFinished(List<Integer> answer, List<Integer> userAnswer) {
        return answer.equals(userAnswer);
    }
}
