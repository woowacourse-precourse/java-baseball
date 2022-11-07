package baseball.domain;

import baseball.util.StringToArrayList;
import java.util.List;

public class NumberCounter {

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String WIN_CONDITION = "3스트라이크";

    public static void printResult(List<Integer> computerNumbers, String playerNumbers) {
        String result = getResult(computerNumbers, playerNumbers);
        System.out.println(result);
    }

    public static boolean isWin(List<Integer> computerNumbers, String playerNumbers) {
        return getResult(computerNumbers, playerNumbers).equals(WIN_CONDITION);
    }

    private static String getResult(List<Integer> computerNumbers, String playerNumbers) {
        int sameCount = getSameCount(computerNumbers, playerNumbers);
        int strikeCount = getStrikeCount(computerNumbers, playerNumbers);
        int ballCount = getBallCount(computerNumbers, playerNumbers);

        if (sameCount == 0) {
            return NOTHING;
        }

        if (strikeCount == 0) {
            return ballCount + BALL;
        }

        if (ballCount == 0) {
            return strikeCount + STRIKE;
        }

        return ballCount + BALL + " " + strikeCount + STRIKE;
    }

    private static int getBallCount(List<Integer> computerNumbers, String playerNumbers) {
        int sameCount = getSameCount(computerNumbers, playerNumbers);
        int strikeCount = getStrikeCount(computerNumbers, playerNumbers);

        return sameCount - strikeCount;
    }

    public static int getStrikeCount(List<Integer> computerNumbers, String playerNumbers) {
        List<Integer> playerNumbersArray = StringToArrayList.convert(playerNumbers);

        int strikeCount = 0;

        for (int i = 0; i < playerNumbersArray.size(); i++) {
            if (computerNumbers.get(i).equals(playerNumbersArray.get(i))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private static int getSameCount(List<Integer> computerNumbers, String playerNumbers) {
        List<Integer> playerNumbersArray = StringToArrayList.convert(playerNumbers);

        int sameCount = 0;

        for (Integer playerNumber : playerNumbersArray) {
            if (computerNumbers.contains(playerNumber)) {
                sameCount++;
            }
        }

        return sameCount;
    }

}
