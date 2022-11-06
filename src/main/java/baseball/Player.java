package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private List<Integer> playerNumber;

    public Player() {
    }

    public void setNumber() {
        String input = Console.readLine();
        playerNumber = new ArrayList<>(isValid(input));
    }

    private Set<Integer> isValid(String number) throws IllegalArgumentException {
        if (!is3NumbersFrom1To9(number)) {
            throw new IllegalArgumentException();
        }
        LinkedHashSet<Integer> validInput = new LinkedHashSet<>();
        for (char c : number.toCharArray()) {
            validInput.add(Character.getNumericValue(c));
        }
        if (validInput.size() < 3) {
            throw new IllegalArgumentException();
        }
        return validInput;
    }

    private boolean is3NumbersFrom1To9(String number) {
        return number.matches("[1-9]{3}");
    }

    public List<Integer> getNumber() {
        return playerNumber;
    }
}
