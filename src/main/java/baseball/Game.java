package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Game {
    static final int INPUT_LENGTH = 3;

    public List<Integer> getComputerNumber() {
        List<Integer> computerNumber = new ArrayList<Integer>();
        while (computerNumber.size() < INPUT_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public List<Integer> getPlayerNumber() throws IllegalArgumentException {
        List<Integer> playerNumber = new ArrayList<Integer>();
        String input = Console.readLine();
        if (input.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < input.length(); i++) {
            playerNumber.add(Integer.valueOf(String.valueOf(input.charAt(i))));
        }
        if (playerNumber.size() != playerNumber.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
        return playerNumber;
    }





}
