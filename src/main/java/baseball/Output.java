package baseball;

import java.util.List;

public class Output {
    private final Hint hint;

    public Output() {
        hint = new Hint();
    }

    public static void askRestart() {
        System.out.println(Message.RESTART.getMessage());
    }

    public static void getNumber() {
        System.out.println(Message.INPUT_ASK.getMessage());
    }

    public void giveHint(String content) {
        System.out.println(content);
    }

    public static void endGame() {
        System.out.println(Message.SELECT_END.getMessage());
    }
}
