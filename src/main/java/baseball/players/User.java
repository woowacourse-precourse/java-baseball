package baseball.players;


import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class User implements Player {

    @Override
    public String generateNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        input = input.replaceAll(" ", "");
        checkError(input);
        return input;
    }

    private void checkError(String userNumbers) throws IllegalArgumentException {

        final String REGEX = "[0-9]+";
        int length = userNumbers.length();

        if (!(length == 3)) {
            throw new IllegalArgumentException("숫자를 3개 입력해주세요.");
        } else if (!userNumbers.matches(REGEX)) {
            throw new IllegalArgumentException("문자는 입력할 수 없습니다.");
        }

        Set<Character> duplicateCheck = new HashSet<>();

        for (char x : userNumbers.toCharArray()) {
            duplicateCheck.add(x);
        }
        if (!(duplicateCheck.size() == 3))
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
    }

}
