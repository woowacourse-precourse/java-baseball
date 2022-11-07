package baseball.controller;

import java.util.ArrayList;
import baseball.view.InputView;

public class InputUserNumber {
    private static InputView inputView = new InputView();
    private static HandleException handleException = new HandleException();
    public ArrayList<Integer> InputUserNumber(String userInput) {
        handleException.UserInputNumberException(userInput);

        ArrayList<Integer> userNumList = new ArrayList<>();

        for (int i = 0; i < userInput.length(); i++) {
            userNumList.add(userInput.charAt(i) - '0');
        }

        return userNumList;
    }
}
