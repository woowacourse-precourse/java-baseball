package baseball.service;

import baseball.repository.GameStartRepository;
import baseball.util.RandomUtil;
import baseball.util.UserUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameStartService {
    public static void saveUserNumber() {
        String userNumberString = UserUtil.getUserNumberString();
        List<String> userNumberList = transferToList(userNumberString);
        GameStartRepository.saveUserNumber(userNumberList);
    }

    private static List<String> transferToList(String userNumberString) {
        List<String> userNumberList = new ArrayList<>(Arrays.asList(userNumberString.split("")));
        return userNumberList;
    }


    public static void saveComputerNumber() {
        List<String> computerNumberList = RandomUtil.getComputerNumberList();
        GameStartRepository.saveComputerNumber(computerNumberList);
    }

    public static String compareNumber() {
        List<String> computerNumber = GameStartRepository.lastComputerNumberList;
        List<String> userNumber = GameStartRepository.lastUserNumberList;
        isBall(computerNumber, userNumber);
        isStrike(computerNumber, userNumber);
        String HINT = getHint();

        return HINT;
    }

    private static String getHint() {
        int ball = GameStartRepository.ball;
        int strike = GameStartRepository.strike;
        String result = "";
        if (strike == 3) {
            result += "3스트라이크";
            return result;
        } else if (strike == 0 && ball == 0) {
            result += "낫싱";

        } else {
            if (strike == 0) {
                result += ball + "볼";
            } else if (ball == 0) {
                result += strike + "스트라이크";
            } else {
                result += ball + "볼 " + strike + "스트라이크";
            }
        }
        return result;
    }

    private static void isStrike(List<String> computerNumber, List<String> userNumber) {
        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                GameStartRepository.strike += 1;
                GameStartRepository.ball -= 1;
            }
        }
    }


    private static void isBall(List<String> computerNumber, List<String> userNumber) {
        for (int i = 0; i < 3; i++) {
            if (computerNumber.contains(userNumber.get(i))) {
                GameStartRepository.ball += 1;
            }
        }
    }


}
