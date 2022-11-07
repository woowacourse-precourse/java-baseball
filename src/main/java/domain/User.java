package domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class User {

    private List<Integer> verifiedValueList = new ArrayList<>();
    private static final int INAPPROPRIATE_SIZE = 3;
    private static final int NUMBER_OF_DIGITS = 3;
    private static final int GAME_RESUME_CODE = 1;
    private static final int GAME_OVER_CODE = 2;

    public void guessComputerNumbers() {
        List<Character> unverifiedValueList;

        String userEnteredValues = Console.readLine();

        checkEnteredValuesLength(userEnteredValues);
        checkEnteredValuesOverlap(userEnteredValues);

        unverifiedValueList = userEnteredValues.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.toList());

        for (Character enteredValue : unverifiedValueList) {
            checkEnteredValueIsNum(enteredValue);
            verifiedValueList.add(Integer.parseInt(enteredValue.toString()));
        }
    }

    public void checkEnteredValuesOverlap(String userEnteredValues) {
        Set<String> overlapCheckValues = new HashSet<>();

        for (int i = 0; i < userEnteredValues.length(); i++) {
            overlapCheckValues.add(String.valueOf(userEnteredValues.charAt(i)));
        }

        if (overlapCheckValues.size() != INAPPROPRIATE_SIZE) {
            throw new IllegalArgumentException("중복되는 수는 입력할 수 없습니다.");
        }
    }

    public void checkEnteredValuesLength(String userEnteredValues) {
        if (userEnteredValues.length() != NUMBER_OF_DIGITS) {
            throw new IllegalArgumentException("세자리 숫자가 입력 되어야 합니다.");
        }
    }

    public void checkEnteredValueIsNum(Character enteredValue) {
        if (enteredValue < '1' || enteredValue > '9') {
            throw new IllegalArgumentException("1에서 9까지의 숫자가 아닌 값이 입력 되었습니다.");
        }
    }

    public List<Integer> getVerifiedValueList() {
        return verifiedValueList;
    }

    public void init() {
        this.verifiedValueList = new ArrayList<>();
    }

    public int isEndGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int exitCode = Integer.parseInt(Console.readLine());

        if (exitCode == GAME_RESUME_CODE || exitCode == GAME_OVER_CODE) {
            return exitCode;
        }

        throw new IllegalArgumentException("1 또는 2를 입력하세요.");
    }

}
