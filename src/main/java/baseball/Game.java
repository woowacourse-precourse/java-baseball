package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Integer> computer;

    public Game() {
        this.computer = initComputer();
    }

    private List<Integer> initComputer() {
        List<Integer> computer = new ArrayList<>();
        int randomNumber;

        while (computer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private List<Integer> inputToArrayList(String input) {
        List<Integer> player = new ArrayList<>();
        int number;

        for (int i = 0; i < input.length(); i++) {
            number = Character.getNumericValue(input.charAt(i));
            player.add(number);
        }

        return player;
    }

    private int getStrike(List<Integer> computer, List<Integer> player) {
        int strike = 0;

        for (int i = 0; i < player.size(); i++) {
            if (computer.get(i) == player.get(i)) {
                strike++;
            }
        }

        return strike;
    }
}
