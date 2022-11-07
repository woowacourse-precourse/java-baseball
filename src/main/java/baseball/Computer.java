package baseball;

import java.util.*;
import static baseball.Function.*;

public class Computer {
    protected static List<Integer> Answer;

    public Computer() {
        this.Answer = makeAnswer();
    }

    public static List<Integer> makeAnswer(){
        List<Integer> Answer = new ArrayList<>();
        while(Answer.size() < 3){
            addRandomNumber(Answer);
        }
        return Answer;
    }

    public static boolean hasSameNumber(List<Integer> list) {
        List<Boolean> checkList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            checkList.add(Answer.contains(list.get(i)));
        }
        return checkTrue(checkList);
    }
}

