package baseball;

public class User {


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
