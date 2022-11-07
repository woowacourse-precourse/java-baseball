package baseball.game;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> computers;

    private void pickNumbers(){
        computers = new ArrayList<>();

        while (computers.size() < 3){
            int num = Randoms.pickNumberInRange(1, 9);
            if (!computers.contains(num)){
                computers.add(num);
            }
        }
    }
}
