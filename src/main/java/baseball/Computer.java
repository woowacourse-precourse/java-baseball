package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Computer {
    protected static List<Integer> Answer;

    public Computer() {
        this.Answer = makeAnswer();
    }

    public static void addRandomNumber(List<Integer> list) {
        int randomNumber = Randoms.pickNumberInRange(1,9);
        if(!list.contains(randomNumber)){
            list.add(randomNumber);
        }
    }

    public static List<Integer> makeAnswer(){
        List<Integer> Answer = new ArrayList<>();
        while(Answer.size() < 3){
            addRandomNumber(Answer);
        }
        return Answer;
    }
}

