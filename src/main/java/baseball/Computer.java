package baseball;

import java.util.*;
import static baseball.Function.*;

public class Computer {
    protected static List<Integer> Answer;
    protected static String result;

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

    public static boolean isNothing(List<Integer> list) {
        List<Boolean> checkList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            checkList.add(Answer.contains(list.get(i)));
        }
        return !checkTrue(checkList);
    }

    public static HashMap<String, Integer> isStrikeOrBall(List<Integer> list){
        HashMap<String ,Integer> StrikeOrBall = new HashMap<>();
        List<Boolean> checkList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            checkList.add(Answer.get(i) == list.get(i));
        }
        StrikeOrBall.put("스트라이크", Collections.frequency(checkList, true));
        StrikeOrBall.put("볼", Collections.frequency(checkList, false));

        return StrikeOrBall;
    }

}

