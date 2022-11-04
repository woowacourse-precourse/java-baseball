package baseball.players;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    List<Integer> userNumbers = new ArrayList<>();

    private void checkError(String num) throws IllegalArgumentException {
        final String REGEX = "[0-9]+";
        int length = num.length();

        if (!(length == 3)) {
            throw new IllegalArgumentException("숫자를 3개 입력해주세요.");
        } else if (num.matches(REGEX)) {
            throw new IllegalArgumentException("문자는 입력할 수 없습니다.");
        }

        Set<Character> duplicateCheck = new HashSet<>();

        for (char x : num.toCharArray()) {
            duplicateCheck.add(x);
        }
        if(!(duplicateCheck.size() == 3))
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");

    }

    public List<Integer> createUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String num = Console.readLine();
        num = num.replaceAll(" ", "");

        checkError(num);

        for (int i = 0; i < num.length(); i++) {
            userNumbers.add(Character.getNumericValue(num.charAt(i)));
        }

        return userNumbers;
    }
}
