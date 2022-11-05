package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class User {

    private final List<Integer> verifiedValueList = new ArrayList<>();

    public void guessComputerNumbers() {
        List<Character> unverifiedValueList;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String userEnteredValues = reader.readLine();

            checkEnteredValuesOverlap(userEnteredValues);
            checkEnteredValuesLength(userEnteredValues);

            unverifiedValueList = userEnteredValues.chars()
                    .mapToObj(value -> (char) value)
                    .collect(Collectors.toList());

            for (Character enteredValue : unverifiedValueList) {
                checkEnteredValueIsNum(enteredValue);
                verifiedValueList.add(Integer.parseInt(enteredValue.toString()));
            }

        } catch (IOException e) {
            throw new UncheckedIOException(e);
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

}
