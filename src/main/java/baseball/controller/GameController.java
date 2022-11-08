package baseball.controller;

import baseball.service.GameService;
import baseball.view.*;
import java.util.regex.Pattern;

public class GameController {
    public void addComputerNumber() {
        GameService service = new GameService();
        service.addComputerNumber();
    }
    public void addComputerNumbersForTest() {
        GameService service = new GameService();

        service.addComputerNumber(135);
        service.addComputerNumber(589);
    }

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
        validateInput("^[1-9]{3}$", input);

        View view = new SelectNumberResultView(parseInt(input));
        view.show();

        return view.getResponseToBoolean();
    }

    public String showSelectPlayGameAgain() {
        View view = new SelectPlayGameAgainView();
        view.show();

        return view.getResponseToString();
    }

    public boolean getPlayGameAgainResult(String input) {
        validateInput("^[1-2]{1}$", input);

        View view = new PlayGameAgainResultView(parseInt(input));
        view.show();

        return view.getResponseToBoolean();
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