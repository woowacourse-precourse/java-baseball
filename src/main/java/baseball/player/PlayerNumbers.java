package baseball.player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class PlayerNumbers {

    private final int DIGIT_LENGTH = 3;
    private final String CHECK_DIGIT_LENGTH = "숫자의 자릿수를 확인해주세요";
    private static final String NO_OVERLAP_NUMBER = "각 자리가 중복되지 않는 수를 입력해주세요";

    private final List<PlayerNumber> playerNumbers;

    private List<PlayerNumber> getPlayerNumbers() {
        return playerNumbers;
    }

    public PlayerNumbers(int inputNumbers) {
        List<PlayerNumber> playerNumbers = intToPlayerNumbers(inputNumbers);
        validateLength(playerNumbers, (Integer i) -> i == DIGIT_LENGTH);
        validateOverlap(playerNumbers);
        this.playerNumbers = playerNumbers;
    }

    private ArrayList<PlayerNumber> intToPlayerNumbers(int inputNumbers) {
        ArrayList<PlayerNumber> playerNumbers = new ArrayList<>();
        String inputNumbersString = String.valueOf(inputNumbers);
        String[] inputNumberSplit = inputNumbersString.split("");
        for (String inputNumber : inputNumberSplit) {
            int inputNumberInt = Integer.parseInt(inputNumber);
            playerNumbers.add(new PlayerNumber(inputNumberInt));
        }
        return playerNumbers;
    }

    private void validateLength(List<PlayerNumber> playerNumbers, Predicate<Integer> p) {
        int size = playerNumbers.size();
        if (!p.test(size)) {
            throw new IllegalArgumentException(CHECK_DIGIT_LENGTH);
        }
    }

    private void validateOverlap(List<PlayerNumber> playerNumbers) {
        LinkedList<PlayerNumber> linkedList = new LinkedList<>();
        for (PlayerNumber playerNumber : playerNumbers) {
            linkedList.add(playerNumber);
        }

        while (linkedList.size() != 0) {
            PlayerNumber pop = linkedList.pop();
            if (linkedList.contains(pop)) {
                throw new IllegalArgumentException(NO_OVERLAP_NUMBER);
            }
        }

    }

}


