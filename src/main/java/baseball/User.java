package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String OPTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INVALID_NUMBER_INPUT = "잘못된 숫자 입력입니다.";
    private static final String INVALID_OPTION_INPUT = "잘못된 옵션 입력입니다.";

    private User() {}

    
    // check is getGameNumber is validable
    // illegal values -> IllegalArgumentException
    
    public static String getGameNumber() {
        System.out.print(INPUT_MESSAGE);
        String number = Console.readLine();

        if (!isValidNumber(number)) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT);
        }

        return number;
    }
    
    // get new game : 1
    // end : 2
    // else : IllegalArgumentException 
    public static int getGameOption() {
        System.out.println(OPTION_MESSAGE);
        int option = Integer.parseInt(Console.readLine());

        if (!isValidOption(option)) {
            throw new IllegalArgumentException(INVALID_OPTION_INPUT);
        }

        return option;
    }

    // return option is 1 or 2
    private static boolean isValidOption(int option) {
        return option == 1 || option == 2;
    }

    
    
   
    //check 
    private static boolean isValidNumber(String number) {
        return isLengthThree(number) && !isDuplicate(number) && isValidRange(number);
    }

    // check is it 3 digit
    private static boolean isLengthThree(String number) {
        return number.length() == 3;
    }

    // check is it duplicate
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

    // check is numer in 1 ~ 9
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