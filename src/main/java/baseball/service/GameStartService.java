package baseball.service;

import baseball.repository.GameStartRepository;
import baseball.status.HintStatus;
import baseball.util.RandomUtil;
import baseball.util.UserUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.status.HintStatus.BALL;
import static baseball.status.HintStatus.STRIKE;
import static baseball.status.NumberStatus.MAX_NUMBER;
import static baseball.status.NumberStatus.MIN_NUMBER;

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
        if (strike == MAX_NUMBER.getNumber()) {
            result += HintStatus.ANSWER.getText();
        } else if (strike == MIN_NUMBER.getNumber() && ball == MIN_NUMBER.getNumber()) {
            result += HintStatus.NOTHING.getText();
        } else if (strike == MIN_NUMBER.getNumber() && !(ball == MIN_NUMBER.getNumber())) {
            result += ball + BALL.getText();
        } else if (!(strike == MIN_NUMBER.getNumber()) && ball == MIN_NUMBER.getNumber()) {
            result += strike + STRIKE.getText();
        } else {
            result += ball + BALL.getText() + " " + strike + STRIKE.getText();
        }

        return result;
    }

    public static void initBallAndStrike() {
        GameStartRepository.ball = MIN_NUMBER.getNumber();
        GameStartRepository.strike = MIN_NUMBER.getNumber();
    }

    private static void isStrike(List<String> computerNumber, List<String> userNumber) {
        for (int i = MIN_NUMBER.getNumber(); i < MAX_NUMBER.getNumber(); i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                GameStartRepository.strike++;
                GameStartRepository.ball--;
            }
        }
    }


    private static void isBall(List<String> computerNumber, List<String> userNumber) {
        for (int i = MIN_NUMBER.getNumber(); i < MAX_NUMBER.getNumber(); i++) {
            if (computerNumber.contains(userNumber.get(i))) {
                GameStartRepository.ball++;
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
