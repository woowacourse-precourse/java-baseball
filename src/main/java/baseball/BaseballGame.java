package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballGame {
    private Player player;
    private Rule rule;
    private boolean wrongAnswer;

    public BaseballGame() {
        player = new Player();
        rule = new Rule();
        rule.print(Message.START.get());
    }
    public void start() {
        rule.generateAnswer();
        wrongAnswer = true;
        do {
            rule.print(Message.INPUT.get());
            player.setNumber();
            rule.print(makeHint());
        } while (wrongAnswer);
        rule.print(Message.END.get());
    }

    private String makeHint() {
        if (rule.gameSet(player.getNumber())) {
            wrongAnswer = false;
        }
        rule.getTotalCount(player.getNumber());
        return rule.getHint();
    }



}
