package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;

public class User {
    public void inputNumber(String inputNumbers) {
        HashSet<Character> set = new HashSet<>();

        try {
            if (inputNumbers.length() != 3) {
                throw new IllegalArgumentException();
            }

            for (int i = 0; i < inputNumbers.length(); i++) {
                if (inputNumbers.charAt(i) < '1' || inputNumbers.charAt(i) > '9') {
                    throw new IllegalArgumentException();
                }
                if (set.contains(inputNumbers.charAt(i))) {
                    throw new IllegalArgumentException();
                }
                set.add(inputNumbers.charAt(i));
            }

        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값 입력됨");
        }
    }




}
