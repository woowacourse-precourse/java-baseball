package baseball.players;


import java.util.HashSet;
import java.util.Set;

public class User {

    private String userNumbers;

    public User(String userNumbers) {
        userNumbers = userNumbers.replaceAll(" ", "");
        checkError(userNumbers);
        this.userNumbers = userNumbers;
    }

    public String getUserNumbers() {
        return userNumbers;
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
