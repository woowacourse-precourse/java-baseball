package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static baseball.Constant.*;

public class Player {
    public static String getPlayerAnswer() {
        System.out.print(INPUT_MESSAGE);
        String playerAnswerStr = Console.readLine();

        validateNumber(playerAnswerStr);
        return playerAnswerStr;
    }

    public static List<Integer> stringToIntegerList(String inputStr) {
        String[] inputStrArr = inputStr.split("");
        List<Integer> inputIntList = new ArrayList<>();
        for (int i = 0; i < inputStrArr.length; i++) {
            int tmp = Integer.parseInt(inputStrArr[i]);
            inputIntList.add(tmp);
        }
        return inputIntList;
    }

    public static boolean validateNumber(String playerAnswer) {
        checkLength(playerAnswer);
        checkDuplicate(playerAnswer);
        checkNumberOnly(playerAnswer);
        return true;
    }

    private static void checkLength(String playerAnswer) {
        if (playerAnswer.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    private static void checkDuplicate(String playerAnswer) {
        HashSet<String> playerAnswerSet = new HashSet<>();
        String[] tmpArr = playerAnswer.split("");
        for (int i = 0; i < playerAnswer.length(); i++) {
            playerAnswerSet.add(tmpArr[i]);
        }
        if (playerAnswer.length() != playerAnswerSet.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private static void checkNumberOnly(String playerAnswer) {
        String regExp = "^[1-9]+$";
        if (!playerAnswer.matches(regExp)) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }
}
