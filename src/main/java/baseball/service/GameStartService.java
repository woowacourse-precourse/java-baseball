package baseball.service;

import baseball.repository.GameStartRepository;
import baseball.status.HintStatus;
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
        if (GameStartRepository.lastComputerNumberList == null || GameStartRepository.lastComputerNumberList.size() == 0) {
            List<String> computerNumberList = RandomUtil.getComputerNumberList();
            GameStartRepository.saveComputerNumber(computerNumberList);
        }
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
            result += "3" + HintStatus.STRIKE;
            return result;
        } else if (strike == 0 && ball == 0) {
            result += HintStatus.NOTHING;

        } else {
            if (strike == 0) {
                result += "" + ball + HintStatus.BALL;
            } else if (ball == 0) {
                result += "" + strike + HintStatus.STRIKE;
            } else {
                result += ""+ ball + HintStatus.BALL + strike + HintStatus.STRIKE;
            }
        }
        return result;
    }

    public static void initBallAndStrike() {
        GameStartRepository.ball = 0;
        GameStartRepository.strike = 0;
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


    public static String getUserInput() {
        return UserUtil.getUserInput();
    }

    public static void initGame() {
        initBallAndStrike();
        GameStartRepository.lastComputerNumberList.clear();
    }
}
