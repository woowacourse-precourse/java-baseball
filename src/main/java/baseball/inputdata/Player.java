package baseball.inputdata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private static final String MESSAGE_TO_USER_INPUT = "숫자를 입력해주세요 : ";
    private static final int VALID_LENGTH_OF_USER_INPUT = 3;
    private static final String VALID_PLAYER_INPUT_PATTERN = "^[1-9]{3}$";


    public static String Input() {
        Scanner sc = new Scanner(System.in);
        String inputData = "";

        System.out.println(MESSAGE_TO_USER_INPUT);
        inputData = sc.next();

        return inputData;
    }

    public static void ExceptionProcess(String inputData) {
        if(inputData.length() != VALID_LENGTH_OF_USER_INPUT)
            throw new IllegalArgumentException();

        if(!inputData.matches(VALID_PLAYER_INPUT_PATTERN))
            throw new IllegalArgumentException();
    }
}
