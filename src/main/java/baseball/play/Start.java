package baseball.play;

import baseball.computer.computerNumber;
import baseball.user.userNumber;

import java.util.List;

public class Start {

    private static final List<Integer> PLAYING = List.of(0);
    private static final List<Integer> RESTART = List.of(1);
    public static void gameStart(List<Integer> state, computerNumber computer , userNumber user){
        if(state == PLAYING){
            System.out.println("숫자 야구 게임을 시작합니다.");
        }
        if(state == RESTART){
            computer.setComputer();
        }
    }
}
