package baseball;

import baseball.computer.computerNumber;
import baseball.play.Play;
import baseball.user.userNumber;

import java.util.*;

import static baseball.gamestates.restart.isRestart;
import static baseball.gamestates.stop.isStop;
import static baseball.play.GameStop.stop;
import static baseball.play.Play.play;
import static baseball.play.Restart.restart;
import static baseball.play.Start.gameStart;

public class Application {
    private static List<Integer> STATE;

    public static void main(String[] args) {

        computerNumber computer = new computerNumber();
        userNumber user = new userNumber();
        computer.setComputer();

        STATE = new ArrayList<>(List.of(0));

        while(!isStop(STATE)){
            gameStart(STATE,computer, user);
            STATE = play(computer,user);

            if(isRestart(STATE) ){
                restart(computer);
            }
            if(isStop(STATE)){
                stop();
                break;
            }
        }
    }
}
