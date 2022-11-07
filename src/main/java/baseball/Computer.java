package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.Number.threeDigitsToNumList;

public class Computer {
    private static final int EMPTY_COUNT = 0;
    private static final int STRIKE_COUNT = 3;

    public static List<Integer> calcResult(int opponentNum, int playerNum) {
        List<Integer> opponentList = threeDigitsToNumList(opponentNum);
        List<Integer> playerList = threeDigitsToNumList(playerNum);

        int ballCount = 0;
        int strikeCount = 0;
        for (int index = 0; index < 3; index++) {
            if (playerList.get(index).equals(opponentList.get(index))) {
                strikeCount++;
                continue;
            }
            if (opponentList.contains(playerList.get(index))) {
                ballCount++;
            }
        }

        List<Integer> result = new ArrayList<>(2);
        result.add(ballCount);
        result.add(strikeCount);

        return result;
    }

    public static boolean printResult(List<Integer> result) {
        if (result.get(0) == EMPTY_COUNT && result.get(1) == EMPTY_COUNT) {
            System.out.println("낫싱");
            return true;
        }

        if (result.get(0) != EMPTY_COUNT) {
            System.out.print(result.get(0) + "볼");
        }
        if (result.get(1) != EMPTY_COUNT) {
            if (result.get(0) != EMPTY_COUNT) {
                System.out.print(" ");
            }
            System.out.println(result.get(1) + "스트라이크");

            if (result.get(1) == STRIKE_COUNT) {
                return false;
            }
            return true;
        }

        System.out.println();

        return true;
    }
}
