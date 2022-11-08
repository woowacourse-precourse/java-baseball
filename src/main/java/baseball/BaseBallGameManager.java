package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Objects;

public class BaseBallGameManager {

    static StrikeBallChecker strikeBallChecker;
    static String allStrike = RandomNumberProvider.MAX_SIZE_OF_LIST + ResponseMsg.STRIKE.getMsg();
    static String response = "";
    static int playableTimes = 1;
    static int triedTimes = 0;

    public static void start() {
        setup();
        System.out.println(ResponseMsg.GAME_INIT_MSG.getMsg());

        while (playableTimes > triedTimes) {
            System.out.print(ResponseMsg.NUMBER_INPUT_MSG.getMsg());
            response = matchAnswerWithValidInput();
            System.out.println(response);

            if (Objects.equals(response, allStrike)) {
                triedTimes++;
                System.out.println(ResponseMsg.GAME_COMPLETE_MSG.getMsg());
                System.out.println(ResponseMsg.GAME_RESTART_OR_STOP_MSG.getMsg());
                restartOrStop();
                setup();
            }
        }


    }

    private static void setup() {
        List<Integer> randomNums = RandomNumberProvider.generateRandomIntList();
        strikeBallChecker = new StrikeBallChecker(randomNums);
    }

    private static String matchAnswerWithValidInput() {
        String input = Console.readLine().strip();

        List<Integer> inputList = RequestController.validateAndGetIntList(input);
        return strikeBallChecker.matchAnswer(inputList);
    }

    private static void restartOrStop() {
        String input = Console.readLine().strip();
        playableTimes += RequestController.validateNumAndGetOneIfIsOne(input);
    }
}

