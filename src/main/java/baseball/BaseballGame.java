package baseball;

public class BaseballGame {
    private Player player;
    private Rule rule;
    private boolean continueGame;

    public BaseballGame() {
        player = new Player();
        rule = new Rule();
        System.out.print(Message.START.get());
    }
    public void start() {
        rule.generateAnswer();
        continueGame = true;
        do {
            System.out.print(Message.INPUT.get());
            player.setNumber();
            System.out.print(makeHint());
        } while (continueGame);
        System.out.print(Message.END.get());
    }

    private String makeHint() {
        if (rule.is3Strike(player.getNumber())) {
            continueGame = false;
        }
        rule.getTotalCount(player.getNumber());
        return rule.getHint();
    }



}
