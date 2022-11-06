package baseball.controller;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class InputUserNumber {
    public ArrayList<Character> InputUserNumber() {
        String userNum = Console.readLine();
        ArrayList<Character> userNumList = new ArrayList<>();

        for (int i = 0; i < userNum.length(); i++) {
            userNumList.add(userNum.charAt(i));
        }

        return userNumList;
    }
}
