package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static boolean game_over = false;


    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();
        while(true){
            makeGame(computer);
            playgame(computer,user);
            wouldYouExitGame();
            if(game_over) break;
        }
    }
}
