package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String OPTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INVALID_NUMBER_INPUT = "잘못된 숫자 입력입니다.";
    private static final String INVALID_OPTION_INPUT = "잘못된 옵션 입력입니다.";

    private User() {}

    /*
    * 3자리이고, 중복이 없으며 1 ~ 9 사이의 숫자로 이루어진 문자열 반환
    * 유효하지 않은 입력에 대해 IllegalArgumentException 던짐
    *
    * @return void
    * */
    public static String getGameNumber() {
        System.out.print(INPUT_MESSAGE);
        String number = Console.readLine();

        if (!isValidNumber(number)) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT);
        }

        return number;
    }

    /*
    * 게임 새 시작 : 1, 종료 : 2를 입력
    * 1, 2가 아닌 값인 경우 IllegalArgumentException 던짐
    *
    * @return void
    * */
    public static int getGameOption() {
        System.out.println(OPTION_MESSAGE);
        int option = Integer.parseInt(Console.readLine());

        if (!isValidOption(option)) {
            throw new IllegalArgumentException(INVALID_OPTION_INPUT);
        }

        return option;
    }

    /*
    * 주어진 인자가 1 또는 2인지 반환
    *
    * @return boolean
    * */
    private static boolean isValidOption(int option) {
        return option == 1 || option == 2;
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
