package baseball.objects;

import baseball.view.View;
import baseball.view.service.ViewService;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    private final Computer computer = new Computer(new NumberGenerator());
    private final Referee referee = new Referee(new Rule());
    private final Player player = new Player();

    public boolean start() {
        computer.giveNumbersToReferee(referee);

        boolean isFinished = false;
        while (!isFinished) {
            View.pushNumber();
            savePlayerNumber(player, referee);
            ViewService responseView = referee.answerNumber();
            isFinished = responseView.check();
        }

        return restart();
    }

    private void savePlayerNumber(Player player, Referee referee) {
        player.sayNumbers(pushNumber());
        player.giveNumbersToReferee(referee);
    }

    private boolean restart() {
        return Integer.valueOf(pushNumber()).equals(1);
    }

    private String pushNumber() {
        return Console.readLine();
    }
}
