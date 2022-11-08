package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Game {

    public static List<Integer> computer;
    public static List<Integer> user;

    Game(int start){
        if(start == 0){
            System.out.println("숫자 야구 게임을 시작합니다.");
        }
        buildTarget();
    }

    public static void buildTarget(){
        computer = new ArrayList<Integer>();
        while(computer.size() < 3){
            int randNum = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randNum)){
                computer.add(randNum);
            }
        }
    }
}
