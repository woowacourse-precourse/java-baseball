package baseball;

import baseball.game.Player;

public class AfterGame {
    private static final boolean RESTART = true;
    private static final boolean FINISH = false;

    public void outputQuest() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public boolean isRestartOrFinish(String input) {
        if (input.equals("1")) return RESTART;
        if (input.equals("2")) return FINISH;
        throw new IllegalArgumentException();
    }

    public boolean play() {
        outputQuest();
        Player player = new Player();
        player.setInputNumber();
        return isRestartOrFinish(player.getInputNumber());
    }
}
