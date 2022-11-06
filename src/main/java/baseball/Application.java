package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        boolean play = true;
        while(play){
            play = BaseBallGame.playBaseBallGame();
        }
        return;
    }
}
