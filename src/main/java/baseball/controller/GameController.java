package baseball.controller;

import baseball.view.PickThreeDigitNumberView;
import baseball.view.SelectPlayGameAgain;
import baseball.view.TutorialView;
import baseball.view.View;

import java.util.regex.Pattern;

public class GameController {
    public void showTutorial() {
        View view = new TutorialView();
        view.show();
    }

    public String showPickThreeDigitNumber() {
        View view = new PickThreeDigitNumberView();
        view.show();

        return view.getResponse();
    }

    public boolean showSelectNumberResult(String input) {
        return false;
    }

    public String showSelectPlayGameAgain() {
        View view = new SelectPlayGameAgain();
        view.show();

        return view.getResponse();
    }

    public boolean getPlayGameAgainResult(String input) {
        return true;
    }

    public static boolean validateInput(String regex, String input) {
        return (Pattern.matches(regex, input));
    }
}