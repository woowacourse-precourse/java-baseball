package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Computer computer = new Computer(new ArrayList<>());
        computer.random3NumberOutput();

        Player player = new Player(new ArrayList<>());
        player.player3NumberInput();

        List ballIndex = new ArrayList<Integer>();
        int ballCount = 0;
        List strikeIndex = new ArrayList<Integer>();
        int strikeCount = 0;

        strike(computer, player, strikeIndex, strikeCount);

    }

    private static void strike(Computer computer, Player player, List strikeIndex, int strikeCount) {
        for(int numericComparisonIndex = 0; numericComparisonIndex < 3; numericComparisonIndex++) {
            if(computer.computerNumber.get(numericComparisonIndex) == player.playerNumber.get(numericComparisonIndex)) {
                strikeCount++;
                strikeIndex.add(numericComparisonIndex);
            }
        }
    }
}
