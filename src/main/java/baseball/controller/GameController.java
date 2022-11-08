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
        validateInput("^[1-9]{3}", input);

        View view = new SelectNumberResult(parseInt(input));
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

    public static void validateInput(String regex, String input) {
        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException("조건에 맞게 입력해주세요.");
        }
    }

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}