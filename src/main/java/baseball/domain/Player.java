package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Player {

    private List<Integer> inputNumbers() {
        return new ArrayList<>();
    }

    public boolean checkWrongInput(String input) {
        if (input.length() != 3) return true;

        HashSet<String> duplicateCheckSet = new HashSet<>(List.of(input.split("")));
        if (duplicateCheckSet.size() != 3) return true;

        return false;
    }
}
