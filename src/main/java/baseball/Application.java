package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.repeatBaseBallGame();
        // TODO: 프로그램 구현
    }

    public static boolean checkTwoNumbersAreSame(int num1,int num2){
        if(num1 ==num2){
            return true;
        }
        return false;
    }




}
