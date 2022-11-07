package baseball;

public class InputNumberExceptionChecker {
    // 3글자가 아닐 때
    public boolean isValidLength(String number) {
        if (number.length() != 3) {
            // 여기서 안내 메세지(GameMessage)도 출력해주면 좋을 듯?!
            return false;
        }
        return true;
    }
    // 모두 다른 수가 아닐 때
    public boolean

    // 재시작 여부를 물었을 때, 1과 2가 아닌 다른 숫자를 입력했을 때

    // 위의 세 개 중 하나라도 만족하지 않음을 확인하는 메서드 (총평?)
}
