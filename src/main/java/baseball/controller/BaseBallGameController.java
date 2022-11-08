package baseball.controller;

import baseball.service.BallCountService;
import baseball.util.ArgumentExceptionMessage;
import baseball.util.Constant;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

import static baseball.util.ArgumentException.isException;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/07
 */
public class BaseBallGameController {
    private final BallCountService ballCountService;

    public BaseBallGameController(BallCountService ballCountService) {
        this.ballCountService = ballCountService;
    }

    // 데이터 입력받아, 랜덤 숫자와 같은 형태로 형태변환
    public List<Integer> inputUserAnswer() {
        String input = Console.readLine();
        isException(!input.matches("[" + Constant.ANSWER_MIN_DIGIT + "-" + Constant.ANSWER_MAX_DIGIT + "]*"),
                ArgumentExceptionMessage.INPUT_NOT_INTEGER);
        isException(input.length() != Constant.LENGTH_OF_NUMBER,
                ArgumentExceptionMessage.INPUT_UNCONFORMABLE_LENGTH);
        return toIntegerList(input);
    }

    // ball count 계산
    public String calcBallCount(List<Integer> answer, List<Integer> userAnswer) {
        return ballCountService.calc(answer, userAnswer).toString();
    }

    // 게임 종료 여부 판단
    public boolean isFinish(List<Integer> answer, List<Integer> userAnswer) {
        return answer.equals(userAnswer);
    }

    // 게임 재시작 여부 판단
    public boolean isRestart() {
        int restartCommand = inputRestartCommand();
        isException(restartCommand != Constant.RESTART_NUMBER && restartCommand != Constant.STOP_NUMBER,
                ArgumentExceptionMessage.COMMAND_NOT_FOUND);
        return restartCommand == Constant.RESTART_NUMBER;
    }

    private int inputRestartCommand() {
        String input = Console.readLine();
        isException(input.length() != 1,
                ArgumentExceptionMessage.COMMAND_NOT_FOUND);
        isException(!Character.isDigit(input.charAt(0)),
                ArgumentExceptionMessage.COMMAND_NOT_FOUND);
        return  Integer.parseInt(input);
    }

    private List<Integer> toIntegerList(String input) {
        List<Integer> userAnswer = new ArrayList<>();
        for (String digit : input.split("")) {
            isException(userAnswer.contains(Integer.parseInt(digit)),
                    ArgumentExceptionMessage.INPUT_OVERLAP);
            userAnswer.add(Integer.parseInt(digit));
        }
        return userAnswer;
    }
}
