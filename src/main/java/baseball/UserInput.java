package baseball;

import camp.nextstep.edu.missionutils.Console;


/**
 * 컴퓨터 번호를 맞추기 위한 입력(서로 다른 3자리)
 * 게임 종료 여부에 대한 입력(게임시작:1, 게임종료:2)
 */

public class UserInput {
    public static String userNumberInput() {
        UserOutput.userNumInputMessage();
        String userNum = Console.readLine();
        InputError.userNumberInputExceptionCheck(userNum);
        return userNum;
    }

    public static String replayOrStop() {
        UserOutput.userChoiceReplayOrStopMessage();
        String choice = Console.readLine();
        InputError.replayOrStopExceptionCheck(choice);
        return choice;
    }
}
