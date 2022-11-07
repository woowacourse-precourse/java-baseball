package baseball;

import baseball.game.AfterPlayer;
import baseball.game.Player;
import camp.nextstep.edu.missionutils.Console;

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
        AfterPlayer afterPlayer = new AfterPlayer();
        return isRestartOrFinish(afterPlayer.getCONTINUE_NUMBER());
    }
}
