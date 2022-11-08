package baseball.controller;

import baseball.util.ArgumentExceptionMessage;
import baseball.util.Constant;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/07
 */
public class BaseBallGameController {
    // TODO: 데이터 입력받아, 랜덤 숫자와 같은 형태로 형태변환
    public static List<Integer> inputUserAnswer() {
        String input = Console.readLine();
        if (input.length() != Constant.LENGTH_OF_NUMBER) {
            throw new IllegalArgumentException(ArgumentExceptionMessage.INPUT_UNCONFORMABLE_LENGTH.getMessage());   // 입력받은 값의 길이가 요구사항과 다른 경우
        }
        return toIntegerList(input);
    }

    public static boolean isRestart() {
        // TODO: 게임 재시작 여부 판단
        System.out.println(Constant.RESTART_COMMENT);
        int restartCommand = Integer.parseInt(Console.readLine());
        if (restartCommand != Constant.RESTART_NUMBER && restartCommand != Constant.STOP_NUMBER) {
            throw new IllegalArgumentException(ArgumentExceptionMessage.COMMAND_NOT_FOUND.getMessage());   // 예외 처리
        }
        return restartCommand == Constant.RESTART_NUMBER;
    }

    private static List<Integer> toIntegerList(String input) {
        List<Integer> userAnswer = new ArrayList<>();
        for (String digit : input.split("")) {
            if (!Character.isDigit(digit.charAt(0))) {
                throw new IllegalArgumentException(ArgumentExceptionMessage.INPUT_NOT_INTEGER.getMessage());   // 입력받은 값이 숫자가 아닌 경우
            }
            if(userAnswer.contains(Integer.parseInt(digit))) {
                throw new IllegalArgumentException(ArgumentExceptionMessage.INPUT_OVERLAP.getMessage());   // 입력받은 값에 중복되는 값이 존재하는 경우
            }
            userAnswer.add(Integer.parseInt(digit));
        }
        return userAnswer;
    }
}
