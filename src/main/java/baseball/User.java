package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String userInput() {
        String userInput = readLine();

        return validUserInput(userInput);
    }

    public String restartOrStopInput() {
        return readLine();
    }

    public List<Integer> userInputToList(String userInputNumber) {

        List<Integer> userInputArr = new ArrayList<>();

        String[] split = userInputNumber.split("");

        for (String s : split) {
            userInputArr.add(Integer.valueOf(s));
        }

        return userInputArr;
    }

    public int validRestartOrEndInput(String userInput) {
        if (userInput.equals("1")) {
            return 1;
        }

        if (userInput.equals("2")) {
            return 2;
        }

        throw new IllegalArgumentException("1 또는 2 의 값만 입력이 가능합니다.");

    }

    public String validUserInput(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("숫자는 세자리 수만 입력 가능합니다.");
        }

        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) == ' ') {
                throw new IllegalArgumentException("공백은 입력할수 없습니다.");
            }

            if (userInput.charAt(i) == '0') {
                throw new IllegalArgumentException("0은 입력할수 없습니다.");
            }
        }

        for (int i = 1; i < userInput.length(); i++) {
            if (userInput.charAt(i - 1) == userInput.charAt(i)) {
                throw new IllegalArgumentException("이미 입력한 숫자는 입력할수 없습니다.");
            }
        }

        return userInput;
    }

}
