package baseball.domain;

import baseball.utils.Constants;
import baseball.utils.Exceptions;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class User {
    public static void checkUserInput(String str){
        Exceptions.checkNumSize(str);
        Exceptions.isNumber(str);
    }

    public static int charToInt(char ch){
        int num = ch-'0';
        return num;
    }

    public static ArrayList<Integer> makeUserList() {
        ArrayList<Integer> UserNumber = new ArrayList<>();
        String str = Console.readLine();
        checkUserInput(str);
        for (int i = 0; i < Constants.INPUT_SIZE; i++) {
            UserNumber.add(charToInt(str.charAt(i)));
        }
        Exceptions.checkSameNum(UserNumber);
        return UserNumber;
    }
}
