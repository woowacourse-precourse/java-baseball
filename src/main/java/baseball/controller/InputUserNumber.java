package baseball.controller;

import java.util.ArrayList;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class InputUserNumber {
    private static InputView inputView = new InputView();
    public ArrayList<Integer> InputUserNumber() {
        inputView.InputUserNum();
        String userNum = Console.readLine();
        ArrayList<Integer> userNumList = new ArrayList<>();

        for (int i = 0; i < userNum.length(); i++) {
            userNumList.add(userNum.charAt(i) - '0');
        }

        return userNumList;
    }
}
