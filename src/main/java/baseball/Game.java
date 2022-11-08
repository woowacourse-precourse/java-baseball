package baseball;

import static baseball.Sentence.*;

public class Game {

    public static void playBall(Computer computer, Player player) {
        player.guessAnswer();
        computer.resetHintMap();
        computer.makeHintMap(player.Answer);
        computer.giveHint();
        askRestart(computer, player);
    }

    public static void askRestart(Computer computer, Player player) {
        if (computer.is3Strike()) {
            System.out.println(CONGRATURATION_3STRIKE);
            System.out.println(ASK_RESTART_OR_EXIT);
            player.responseRestart();
            decideRestart(computer, player);
        } else {
            playBall(computer, player);
        }
    }

    public static void decideRestart(Computer computer, Player player) {
        if (player.ResponseOfRestart.equals(OK)) {
            resetGame(computer, player);
            computer.makeAnswer();
            playBall(computer, player);
        } else if (player.ResponseOfRestart.equals(NO)) {
            System.out.println(GAMEOVER);
        }
    }

    public static void resetGame(Computer computer, Player player) {
        computer.resetAll();
        player.resetAll();
    }

    public static void start() {
        System.out.println(START_GAME);
        Computer computer = new Computer();
        Player player = new Player();
        computer.makeAnswer();
        playBall(computer, player);
    }
}
