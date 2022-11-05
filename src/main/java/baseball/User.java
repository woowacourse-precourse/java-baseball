package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static String number;

    public User() {
        number = setGameNumber();
    }

    /*
    * 3자리이고, 중복이 없으며 1 ~ 9 사이의 숫자로 이루어진 문자열 반환
    * 유효하지 않은 입력에 대해 IllegalArgumentException 던짐
    *
    * @return String
    * */
    public static String setGameNumber() {
        String number = Console.readLine();

        if (!isValidNumber(number)) {
            throw new IllegalArgumentException();
        }

        return number;
    }

    /*
    * 3자리인지, 중복이 없는지, 1 ~ 9로 이루어졌는지 확인
    *
    * @return boolean
    * */
    private static boolean isValidNumber(String number) {
        return isLengthThree(number) && !isDuplicate(number) && isValidRange(number);
    }

    /*
    * 3자리로 이루어졌는지 확인
    *
    * @return boolean
    * */
    private static boolean isLengthThree(String number) {
        return number.length() == 3;
    }

    /*
    * 중복 여부이 있는지 확인
    *
    * @return boolean
    * */
    private static boolean isDuplicate(String number) {
        boolean[] isContain = new boolean[10];

        for (int index = 0; index < 3; index++) {
            int currentNumber = number.charAt(index) - '0';
            if (isContain[currentNumber]) {
                return true;
            }
            isContain[currentNumber] = true;
        }

        return false;
    }

    /*
    * 1 ~ 9로 이루어졌는지 확인
    *
    * @return boolean
    * */
    private static boolean isValidRange(String number) {
        for (int index = 0; index < 3; index++) {
            int currentNumber = number.charAt(index) - '0';
            if (currentNumber < 1 || currentNumber > 9) {
                return false;
            }
        }
        return true;
    }
}
