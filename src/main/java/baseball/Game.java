package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Game {
    private final static Logger LOG = Logger.getGlobal();
    List<Integer> numberList = new ArrayList<>();
    Randoms Ran;

    public Game() {
        while (numberList.size() < 3){
            int term = Ran.pickNumberInRange(1, 9);
            if (!numberList.contains(term)){
                numberList.add(term);
            }
        }
    }
}
