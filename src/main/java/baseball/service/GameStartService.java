package baseball.service;

import baseball.repository.GameStartRepository;
import baseball.status.HintStatus;
import baseball.status.NumberStatus;
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
        if (strike == NumberStatus.MAX_NUMBER.getNumber()) {
            result += HintStatus.ANSWER.getText();
        } else if (strike == NumberStatus.MIN_NUMBER.getNumber() && ball == NumberStatus.MIN_NUMBER.getNumber()) {
            result += HintStatus.NOTHING.getText();
        } else if (strike == NumberStatus.MIN_NUMBER.getNumber() && !(ball == NumberStatus.MIN_NUMBER.getNumber())) {
            result += ball + HintStatus.BALL.getText() + " " + strike + HintStatus.STRIKE.getText();
        } else if (!(strike == NumberStatus.MIN_NUMBER.getNumber()) && !(ball == NumberStatus.MIN_NUMBER.getNumber())) {
            result += ball + HintStatus.BALL.getText() + " " + strike + HintStatus.STRIKE.getText();
        } else {
            result += ball + HintStatus.BALL.getText() + " " + strike + HintStatus.STRIKE.getText();
        }

        return result;
    }

    public static void initBallAndStrike() {
        GameStartRepository.ball = NumberStatus.MIN_NUMBER.getNumber();
        GameStartRepository.strike = NumberStatus.MIN_NUMBER.getNumber();
    }

    private static void isStrike(List<String> computerNumber, List<String> userNumber) {
        for (int i = NumberStatus.MIN_NUMBER.getNumber(); i < NumberStatus.MAX_NUMBER.getNumber(); i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                GameStartRepository.strike ++;
                GameStartRepository.ball --;
            }
        }
    }


    private static void isBall(List<String> computerNumber, List<String> userNumber) {
        for (int i = NumberStatus.MIN_NUMBER.getNumber(); i < NumberStatus.MAX_NUMBER.getNumber(); i++) {
            if (computerNumber.contains(userNumber.get(i))) {
                GameStartRepository.ball ++;
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
