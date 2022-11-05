package baseball;

public class BaseballGame {
    private Player player;
    private Rule rule;
    private boolean continueGame;

    public BaseballGame() {
        player = new Player();
        rule = new Rule();
        System.out.println(Message.START.get());
    }
    public void start() {
        rule.generateAnswer();
        continueGame = true;
        do {
            System.out.print(Message.INPUT.get());
            player.setNumber();
            System.out.println(makeHint());
        } while (continueGame);
        System.out.println(Message.END.get());
    }

    private String makeHint() {
        if (rule.is3Strike(player.getNumber())) {
            continueGame = false;
        }
        rule.getTotalCount(player.getNumber());
        return rule.getHint();
    }



}
