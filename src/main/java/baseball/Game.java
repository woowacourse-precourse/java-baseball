package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Game {
    static final int INPUT_LENGTH = 3;
    static final String BALL = "볼";
    static final String STRIKE = "스트라이크";
    List<Integer> computerNumber;
    List<Integer> playerNumber;

    public Game(){
        computerNumber = getComputerNumber();
    }

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

    public int checkBall(List<Integer> playerNumber) {
        int ballCount = 0;
        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (computerNumber.contains(playerNumber.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public int checkStrike(List<Integer> playerNumber) {
        int strikeCount = 0;
        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (computerNumber.get(i) == playerNumber.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int[] checkNumber(List<Integer> playerNumber) {
        int ballCount = checkBall(playerNumber);
        int strikeCount = checkStrike(playerNumber);
        ballCount -= strikeCount;
        return new int[]{ballCount, strikeCount};
    }
}
