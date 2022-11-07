package baseball.View;

import baseball.Util.Constant;

public class Print {
    public void gameStart() {
        System.out.println(Constant.GAME_START);
    }

    public void inputMessage(String input) {
        String format = String.format(Constant.USER_INPUT, input);
        System.out.println(format);
    }

    public void hintMessage(String input) {
        System.out.println(input);
    }
}
