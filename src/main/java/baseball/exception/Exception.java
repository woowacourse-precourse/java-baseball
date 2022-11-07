package baseball.exception;


public class Exception {

    public static void isOneOrTwo(int number) throws IllegalArgumentException {

        if (!(number == 1 || number == 2)) {
            throw new IllegalArgumentException("1 또는 2만 입력해주세요");
        }
    }
}
