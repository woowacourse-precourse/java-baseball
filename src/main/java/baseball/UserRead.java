package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserRead {
    String userReadCheck = Console.readLine();

    public void UserReadCheck() {
        if (!(userReadCheck.matches("(.*)[1-9](.*)"))) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }

        if (!(userReadCheck.length() == 3)) {
            throw new IllegalArgumentException("3자리 이하의 숫자만 입력해주세요.");
        }

        if (userReadCheck.contains("0")) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 허용됩니다.");
        }

        if (userReadCheck.charAt(0) == userReadCheck.charAt(1)) {
            throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
        }

        if (userReadCheck.charAt(0) == userReadCheck.charAt(2)) {
            throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
        }

        if (userReadCheck.charAt(1) == userReadCheck.charAt(2)) {
            throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
        }
    }

    public int userNumber() {
        int userNumber = Integer.parseInt(userReadCheck);
        return userNumber;
    }

}
