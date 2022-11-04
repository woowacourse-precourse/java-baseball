package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    private List<Integer> userNumber;
    private String inputUserNumber;

    public void setUserNumber() {
        this.userNumber = new ArrayList<>();
        this.inputUserNumber = Console.readLine();
        try {
            validateNumber();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return ;
        }
        for (char element : this.inputUserNumber.toCharArray()) {
            this.userNumber.add(element - '0');
        }
    }

    public void validateNumber() {
        if (!isValidScope()) {
            throw new IllegalArgumentException("1~9 사이의 수만 입력할 수 있습니다.");
        }
        if (!hasSameNumber()) {
            throw new IllegalArgumentException("중복되지 않는 수만 입력할 수 있습니다.");
        }
        if (this.inputUserNumber.length() != 3) {
            throw new IllegalArgumentException("세 자리의 수만 입력할 수 있습니다.");
        }
    }

    public boolean isValidScope() {
        return this.inputUserNumber.matches("^[1-9]{3}$");
    }

    public boolean hasSameNumber() {
        Set<Character> uniqueNumbers = new HashSet<>();
        for (char element : this.inputUserNumber.toCharArray()) {
            uniqueNumbers.add(element);
        }
        return uniqueNumbers.size() == 3;
    }

    public List<Integer> getUserNumber() {
        return this.userNumber;
    }
}
