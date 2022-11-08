package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static constants.GameConstant.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Computer {
    List<Integer> computerNumber;

    public void makeComputerNumber() {
        computerNumber = new ArrayList<>();
        while (computerNumber.size() < GAME_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUM, MAX_RANGE_NUM);
            addComputerNumber(computerNumber, randomNumber);
        }
    }

    private static void addComputerNumber(List<Integer> computerNumber, int randomNumber) {
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber);
        }
    }

    public boolean isNotThreeStrike(List<String> playerNumber) {
        List<Integer> intListPlayerNumber = getIntListPlayerNumber(playerNumber);
        return !computerNumber.equals(intListPlayerNumber);
    }

    private List<Integer> getIntListPlayerNumber(List<String> playerNumber) {
        return playerNumber.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void checkNumber(List<String> playerNumber) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            strikeCount += countStrike(computerNumber.get(i), playerNumber.get(i));
            ballCount += countBall(computerNumber.get(i).toString(), playerNumber, i);
        }
        String computerResult = getComputerResult(strikeCount, ballCount);
        System.out.println(computerResult);
    }

    private String getComputerResult(int strikeCount, int ballCount) {
        String computerResult;
        String ballMessage = getBallMessage(ballCount);
        String strikeMessage = getStrikeMessage(strikeCount);
        computerResult = getNothingMessage(strikeCount, ballCount);

        if (computerResult.equals("")) {
            computerResult = getBallAndStrikeMessage(ballMessage, strikeMessage);
        }
        return computerResult;
    }

    private String getNothingMessage(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return NOTHING_MESSAGE;
        }
        return "";
    }

    private String getBallAndStrikeMessage(String ballMessage, String strikeMessage) {
        if (!Objects.equals(ballMessage, "")) {
            return String.format("%s %s", ballMessage, strikeMessage);
        }
        return String.format("%s%s", ballMessage, strikeMessage);
    }

    private String getStrikeMessage(int strikeCount) {
        if (strikeCount > 0) {
            return String.format("%d%s", strikeCount, STRIKE_MESSAGE);
        }
        return "";
    }

    private String getBallMessage(int ballCount) {
        if (ballCount > 0) {
            return String.format("%d%s", ballCount, BALL_MESSAGE);
        }
        return "";
    }

    private int countStrike(Integer eachComputerNumber, String eachPlayerNumber) {
        if (eachComputerNumber == Integer.parseInt(eachPlayerNumber)) {
            return 1;
        }
        return 0;
    }

    private int countBall(String eachComputerNumber, List<String> playerNumber, int i) {
        if (playerNumber.contains(eachComputerNumber) && !eachComputerNumber.equals(playerNumber.get(i))) {
            return 1;
        }
        return 0;
    }
}
