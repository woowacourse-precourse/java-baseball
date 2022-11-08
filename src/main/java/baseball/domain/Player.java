package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Player {

    public String getInput() {
        return Console.readLine();
    }

    public List<Integer> StringToList(String input) {

        List<Integer> playerInputList = new ArrayList<>();

        if (checkWrongInput(input)) throw new IllegalStateException("잘못된 입력입니다.");

        for (char inputOfDigit : input.toCharArray()) playerInputList.add(inputOfDigit-'0');

        return playerInputList;
    }


    public boolean checkWrongInput(String input) {
        if (input.length() != 3) return true;

        HashSet<String> duplicateCheckSet = new HashSet<>(List.of(input.split("")));
        if (duplicateCheckSet.size() != 3) return true;

        for (char inputOfDigit : input.toCharArray()) if (!Character.isDigit(inputOfDigit)) return true;

        return false;
    }
}
