package baseball;

public class InputNumberExceptionChecker {
    // 3글자가 아닐 때
    public boolean isValidLength(String number) {
        if (number.length() != 3) {
            // 여기서 안내 메세지(GameMessage)도 출력해주면 좋을 듯?! => 통합으로 받으려면 안되겠다
            return false;
        } else {
            return true;
        }
    }

    // 모두 다른 수가 아닐 때
    public boolean hasDifferentNumberElement(String number) {
        if (number.charAt(0) == number.charAt(1)
                || number.charAt(1) == number.charAt(2)
                || number.charAt(2) == number.charAt((0))) {
            return false;
        } else {
            return true;
        }
    }

    // 재시작 여부를 물었을 때, 1과 2가 아닌 다른 숫자를 입력했을 때
    public boolean isValidRestartNumber(int restartNumber) {
        if (restartNumber != 1 || restartNumber != 2) {
            return false;
        } else {
            return true;
        }
    }

    // 숫자에 0이 들어갔는지 확인하는 메서드
    public boolean hasZero(String number) {
        if (number.charAt(0) == 0
                || number.charAt(1) == 0
                || number.charAt(2) == 0) {
            return false;
        } else {
            return true;
        }
    }

    // 위의 세 개 중 하나라도 만족하지 않음을 확인하는 메서드 (총평?)

}
