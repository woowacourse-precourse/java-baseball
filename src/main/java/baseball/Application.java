package baseball;

import baseball.objects.Computer;
import baseball.objects.Game;
import baseball.objects.Player;
import baseball.objects.Referee;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View.start();
        boolean isRestart;
        do {
            Game game = new Game(new Computer(), new Referee(), new Player());
            isRestart = game.start();

        } while (isRestart);
    }
}
