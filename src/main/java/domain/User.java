package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class User {

    private List<Integer> verifiedValueList = new ArrayList<>();

    public void guessComputerNumbers(Scanner scanner) {
        List<Character> unverifiedValueList;

        String userEnteredValues = scanner.nextLine();

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

    private void checkEnteredValuesOverlap(String userEnteredValues) {
        Set<String> overlapCheckValue = new HashSet<>();

        for (int i = 0; i < userEnteredValues.length(); i++) {
            overlapCheckValue.add(String.valueOf(userEnteredValues.charAt(i)));
        }

        if (overlapCheckValue.size() != 3) {
            throw new IllegalArgumentException("중복되는 수는 입력할 수 없습니다.");
        }
    }

    private void checkEnteredValuesLength(String userEnteredValues) {
        if (userEnteredValues.length() != 3) {
            throw new IllegalArgumentException("세자리 숫자가 입력 되어야 합니다.");
        }
    }

    private void checkEnteredValueIsNum(Character enteredValue) {
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

    public int isEndGame(Scanner scanner) {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int exitCode = scanner.nextInt();
            if (exitCode == 1 || exitCode == 2) {
                return exitCode;
            }
            System.out.println("1 또는 2를 입력하세요.");
        }
    }

}
