package baseball.controller;

import baseball.model.BaseballRule;
import baseball.model.ComputerNums;
import baseball.model.UserNums;
import baseball.view.SystemOutputView;
import baseball.view.SystemInputView;

public class BaseballGameController {

    public void Start() {
        do {
            gameStart();
        } while (confirmUserFinalInput());
    }

    private static void gameStart() {
        ComputerNums computerNums = new ComputerNums(BaseballRule.num_length);
        boolean allStrike;
        do {
            BaseballCountController baseballCountController = new BaseballCountController(computerNums.getNumbers(), new UserNums(SystemInputView.startInput()).getNumbers());
            SystemOutputView systemOutputView = new SystemOutputView(baseballCountController);
            systemOutputView.printOutputMessage();
            allStrike = AllStrike(baseballCountController);
        } while (!allStrike);
        SystemOutputView.allStrikeMessage();
    }

    private static boolean confirmUserFinalInput() {
        String userfinalinput = SystemInputView.endInput();
        if (gameEnd(userfinalinput)) {
            return true;
        }
        if (gameRe(userfinalinput)) {
            return false;
        }
        throw new IllegalArgumentException("1이나 2가 아닙니다.");

    }

    private static boolean gameEnd(String userfinalinput) {
        return userfinalinput.equals("1");
    }

    private static boolean gameRe(String userfinalinput) {
        return userfinalinput.equals("2");
    }

    private static boolean AllStrike(BaseballCountController baseballCountController) {
        return baseballCountController.getStrikecount() == BaseballRule.num_length;
    }


}
