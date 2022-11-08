package baseball.exception.errors;

public class UserNumberException {
    public void exception(int input) {
        if (String.valueOf(input).length() != 3) {
            throw new IllegalArgumentException("입력된 숫자가 3자리가 아닙니다.");
        }
        if(String.valueOf(input).contains("0")){
            throw new IllegalArgumentException("입력된 숫자가 1에서 9 사이 숫자가 아닙니다.");
        }
    }
}
