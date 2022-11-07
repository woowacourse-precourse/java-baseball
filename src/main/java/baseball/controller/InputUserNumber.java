package baseball.controller;

import java.util.ArrayList;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class InputUserNumber {
    private static InputView inputView = new InputView();
    public ArrayList<Integer> InputUserNumber(String userInput) {
        ArrayList<Integer> userNumList = new ArrayList<>();

        for (int i = 0; i < userInput.length(); i++) {
            userNumList.add(userInput.charAt(i) - '0');
        }

        return userNumList;
    }
}
