package baseball.controller;

import baseball.view.*;

import java.util.regex.Pattern;

public class GameController {
    public void showTutorial() {
        View view = new TutorialView();
        view.show();
    }

    public String showPickThreeDigitNumber() {
        View view = new PickThreeDigitNumberView();
        view.show();

        return view.getResponseToString();
    }

    public boolean showSelectNumberResult(String input) {
        validateInput("^[1-9]{3}", "중복되는 숫자가 없고 0이 아닌 3자리의 숫자를 입력해주세요.");

        View view = new SelectNumberResult(input);
        view.show();

        return view.getResponseToBoolean();
    }

    public String showSelectPlayGameAgain() {
        View view = new SelectPlayGameAgain();
        view.show();

        return view.getResponseToString();
    }

    public boolean getPlayGameAgainResult(String input) {
        return true;
    }

    public static boolean validateInput(String regex, String input) {
        return (Pattern.matches(regex, input));
    }
}