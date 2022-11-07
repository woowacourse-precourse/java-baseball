package baseball.utils;

public class Validation {
    public static void checkInputNumber(String userList) {
        checkRange(userList);
        checkSameNumber(userList);
    }

    public static void checkRange(String userList) {
        if (userList.length() != 3)
            throw new IllegalArgumentException("문자의 길이가 다릅니다.");
        if (!userList.matches("[1-9][1-9][1-9]"))
            throw new IllegalArgumentException("숫자를 입력해주세요.");
    }

    public static void checkSameNumber(String userList) {
        if (userList.charAt(0) == userList.charAt(1) || userList.charAt(0) == userList.charAt(2) || userList.charAt(1) == userList.charAt(2))
            throw new IllegalArgumentException("같은 숫자를 입력하였습니다.");
    }

    public static void checkRetryRange(String number) {
        if (!(number.equals("1") || number.equals("2")))
            throw new IllegalArgumentException("입력으로 1,2를 입력해주세요.");
    }
}
