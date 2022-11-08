package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constant.*;
import static baseball.Notice.*;

public class NumberBaseBallGame {
    private static List<Character> targetNumList;
    private static Result ball = Result.BALL;
    private static Result strike = Result.STRIKE;
    private static Result nothing = Result.NOTHING;

    public static void playGame() {
        System.out.println(START_NOTICE);
        String restartResponse = GAME_RESTART_NUM;

        while (restartResponse.equals(GAME_RESTART_NUM)) {
            generateTargetNum();
            findTargetNum();

            System.out.println(RESTART_AND_STOP_NOTICE);
            restartResponse = Console.readLine();
            Validation.verifyRestartResponse(restartResponse);
        }
    }

    private static void findTargetNum() {
        do {
            Result.initAllFrequency();

            System.out.print(INPUT_NUM_NOTICE);
            String numAnswer = Console.readLine();
            Validation.verifyNumResponse(numAnswer);

            countScoreByNumResponse(numAnswer);
            printResultToString();
        } while (!strike.verifyThreeTimes());

        System.out.println(CORRECT_TARGET_NUMBER_NOTICE);
    }

    private static void printResultToString() {
        StringBuilder resultStr = new StringBuilder();
        for (Result result : Result.values()) {
            appendResult(result, resultStr);
        }

        System.out.println(resultStr);
    }

    private static void appendResult(Result result, StringBuilder resultStr) {
        if (result.equals(nothing) && result.verifyThreeTimes()) {
            resultStr.append(nothing.getName());
        } else if (result.verifyOccurrence()) {
            resultStr.append(result.getFrequency());
            resultStr.append(result.getName() + " ");
        }
    }

    private static void countScoreByNumResponse(String numResponse) {
        for (int i = 0; i < TARGET_NUM_SIZE; i++) {
            char curNum = numResponse.charAt(i);

            if (!targetNumList.contains(curNum)) {
                nothing.increaseFrequency();
                continue;
            } else if (targetNumList.get(i) == curNum) {
                strike.increaseFrequency();
                continue;
            }
            ball.increaseFrequency();
        }
    }

    private static void generateTargetNum() {
        targetNumList = new ArrayList<>();

        while (targetNumList.size() < TARGET_NUM_SIZE) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            char radonNumToChar = Character.forDigit(randomNum, RADIX);

            if (targetNumList.contains(radonNumToChar)) {
                continue;
            }
            targetNumList.add(radonNumToChar);
        }
    }
}
