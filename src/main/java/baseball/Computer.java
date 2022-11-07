package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.Number.threeDigitsToNumList;

public class Computer {
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
        if (result.get(0) == 0 && result.get(1) == 0) {
            System.out.println("낫싱");
            return true;
        }

        if (result.get(0) != 0) {
            System.out.print(result.get(0) + "볼");
        }
        if (result.get(1) != 0) {
            if (result.get(0) != 0) {
                System.out.print(" ");
            }
            System.out.println(result.get(1) + "스트라이크");

            if (result.get(1) == 3) {
                return false;
            }
            return true;
        }

        System.out.println();
        return true;
    }
}
