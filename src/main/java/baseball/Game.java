package baseball;

import java.util.ArrayList;

public class Game {

    public static void play() {
        Computer computer = new Computer(new ArrayList<>());
        computer.random3NumberOutput();

        Player player = new Player(new ArrayList<>());
        player.player3NumberInput();

        Integer ballCount = 0;
        Integer strikeCount = 0;

        strikeCount = strike(computer, player, strikeCount);
        ballCount = ball(computer, player, ballCount);

        resultOutput(ballCount, strikeCount);
    }

    private static void resultOutput(Integer ballCount, Integer strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        } else if (ballCount == 0 && strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (strikeCount == 0 && ballCount > 0) {
            System.out.println(ballCount + "볼");
        } else {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    private static Integer ball(Computer computer, Player player, int ballCount) {

        for (int numericComparisonIndex = 0; numericComparisonIndex < 3; numericComparisonIndex++) {
            if (!computer.computerNumber.get(numericComparisonIndex).equals(player.playerNumber.get(numericComparisonIndex))) {
                ballCount = getBallCount(computer, player, ballCount, numericComparisonIndex);
            }
        }

        return ballCount;
    }

    private static int getBallCount(Computer computer, Player player, Integer ballCount, int numericComparisonIndex) {

        for (int playerNumberIndex = 0; playerNumberIndex < 3; playerNumberIndex++) {
            if (String.valueOf(computer.computerNumber.get(numericComparisonIndex)).contains(String.valueOf(player.playerNumber.get(playerNumberIndex)))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private static Integer strike(Computer computer, Player player, Integer strikeCount) {

        for (int numericComparisonIndex = 0; numericComparisonIndex < 3; numericComparisonIndex++) {
            if (computer.computerNumber.get(numericComparisonIndex).equals(player.playerNumber.get(numericComparisonIndex))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }
}
