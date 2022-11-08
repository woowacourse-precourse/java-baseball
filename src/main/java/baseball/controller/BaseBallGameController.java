package baseball.controller;

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
    // TODO: 데이터 입력받아, 랜덤 숫자와 같은 형태로 형태변환
    public static List<Integer> inputUserAnswer() {
        String input = Console.readLine();
        isException(input.length() != Constant.LENGTH_OF_NUMBER,
                ArgumentExceptionMessage.INPUT_UNCONFORMABLE_LENGTH);
        return toIntegerList(input);
    }

    public static boolean isRestart() {
        // TODO: 게임 재시작 여부 판단
        System.out.println(Constant.RESTART_COMMENT);
        int restartCommand = Integer.parseInt(Console.readLine());
        isException(restartCommand != Constant.RESTART_NUMBER && restartCommand != Constant.STOP_NUMBER,
                ArgumentExceptionMessage.COMMAND_NOT_FOUND);
        return restartCommand == Constant.RESTART_NUMBER;
    }

    private static List<Integer> toIntegerList(String input) {
        List<Integer> userAnswer = new ArrayList<>();
        for (String digit : input.split("")) {
            isException(!Character.isDigit(digit.charAt(0)),
                    ArgumentExceptionMessage.INPUT_NOT_INTEGER);
            isException(userAnswer.contains(Integer.parseInt(digit)),
                    ArgumentExceptionMessage.INPUT_OVERLAP);
            userAnswer.add(Integer.parseInt(digit));
        }
        return userAnswer;
    }
}
