package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public static String userNumberInput() {
        UserOutput.userNumInputMessage();
        String userNum = Console.readLine();
        InputError.userNumberInputExceptionCheck(userNum);
        return userNum;
    }

    public static String restartOrStop() {
        UserOutput.userChoiceReplayOrStopMessage();
        String choice = Console.readLine();
        InputError.replayOrStopExceptionCheck(choice);
        return choice;
    }
}
