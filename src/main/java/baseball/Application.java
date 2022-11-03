package baseball;

public class Application {
    public static void main(String[] args) {
        final int NUMBER_LENGTH = 3;
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void checkRetryInputException(String retry) throws IllegalArgumentException{
        if (!(retry.equals("1") || retry.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }
}
