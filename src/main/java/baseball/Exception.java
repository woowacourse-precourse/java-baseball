package baseball;

public class Exception {

    public void createNumberInputException(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력한 수의 갯수가 옳지 않습니다.");
        }

        if (input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2) || input.charAt(0) == input.charAt(2)) {
            throw new IllegalArgumentException("중복된 수가 존재합니다.");
        }

        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur < '1' || cur > '9') throw new IllegalArgumentException("수의 범위가 알맞지 않습니다.");
        }
    }

    public void restartException(int selectNext) {
        if (selectNext != 1 && selectNext != 2) {
            throw new IllegalArgumentException("1 혹은 2를 입력해야합니다.");
        }
    }

}
