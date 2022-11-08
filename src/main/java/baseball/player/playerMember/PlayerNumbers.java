package baseball.player.playerMember;

import baseball.uitls.Hints;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class PlayerNumbers {

    private final int DIGIT_LENGTH = 3;
    private final String CHECK_DIGIT_LENGTH = "숫자의 자릿수를 확인해주세요";
    private static final String NO_OVERLAP_NUMBER = "각 자리가 중복되지 않는 수를 입력해주세요";
    private static final int HINT_INITIAL_VALUE = 0;
    private static final int BALL_INDEX = 0;
    private static final int STRIKE_INDEX = 1;


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

    public Hints makeHints(PlayerNumbers playerNumbers) {
        List<Integer> hints = new ArrayList<>(List.of(HINT_INITIAL_VALUE, HINT_INITIAL_VALUE));

        List<PlayerNumber> containPlayerNumber = filterContainPlayerNumber(playerNumbers);
        List<PlayerNumber> basePlayerNumber = this.playerNumbers;
        List<PlayerNumber> comparePlayerNumber = playerNumbers.getPlayerNumbers();

        for (PlayerNumber containNumber : containPlayerNumber) {
            if (basePlayerNumber.indexOf(containNumber)
                    == comparePlayerNumber.indexOf(containNumber)) {
                hints.set(STRIKE_INDEX, hints.get(STRIKE_INDEX) + 1);
            } else {
                hints.set(BALL_INDEX, hints.get(BALL_INDEX) + 1);
            }
        }

        return new Hints(hints);
    }
    private List<PlayerNumber> filterContainPlayerNumber(PlayerNumbers playerNumbers) {
        ArrayList<PlayerNumber> filteredPlayerNumber = new ArrayList<>();
        List<PlayerNumber> basePlayerNumber = this.playerNumbers;

        for (PlayerNumber p : playerNumbers.getPlayerNumbers()) {
            if (basePlayerNumber.contains(p)) {
                filteredPlayerNumber.add(p);
            }
        }

        return filteredPlayerNumber;
    }

}


