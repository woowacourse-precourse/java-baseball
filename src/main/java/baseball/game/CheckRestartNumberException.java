package baseball.game;

public class CheckRestartNumberException {

    public void checkException(String number) {
        try {
            wrongNumberException(number);
        }
        catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static void wrongNumberException(String number) throws Exception {
        if (!number.equals(1) && !number.equals(2)) {
            throw new Exception("1과 2가 아닌 다른 번호가 입력되었습니다.");
        }
    }
}
