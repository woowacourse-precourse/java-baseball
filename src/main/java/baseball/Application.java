package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static boolean game_over = false;

    public static void makeGame(List<Integer> computer){
        computer.clear();
        while (computer.size()<3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.print("숫자 야구 게임을 시작합니다.");
        System.out.println();
    }

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
