package baseball;

import java.util.*;
import static baseball.Function.*;

public class Computer {
    protected static List<Integer> Answer;
    protected static String result;
    protected static HashMap<String, Integer> HintMap;

    public Computer() {
        this.Answer = makeAnswer();
    }

    public static void resetHintMap(){
        HintMap = new HashMap<>();
    }
    public static List<Integer> makeAnswer(){
        List<Integer> Answer = new ArrayList<>();
        while(Answer.size() < 3){
            addRandomNumber(Answer);
        }
        return Answer;
    }

//    public static boolean isNothing(List<Integer> list) {
//        List<Boolean> checkList = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            checkList.add(Answer.contains(list.get(i)));
//        }
//        return !checkTrue(checkList);
//    }
    public static boolean isNothing(int num){
        if (!Answer.contains(num)) {
            return true;
        }
        return false;
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

    public static void giveStrikeOrBall(List<Integer> list){
        HashMap<String ,Integer> StrikeOrBall = isStrikeOrBall(list);
        result = StrikeOrBall.get("볼") + "볼" + " " + StrikeOrBall.get("스트라이크") + "스트라이크";
        if(StrikeOrBall.get("스트라이크") == 0){
            result = StrikeOrBall.get("볼") + "볼";
        }
        if(StrikeOrBall.get("볼") == 0) {
            result = StrikeOrBall.get("스트라이크") + "스트라이크";
        }
    }

//    public static void giveResult(List<Integer> list){
//        if(isNothing(list)){
//            result = "낫싱";
//        }
//        else{
//            giveStrikeOrBall(list);
//        }
//        System.out.println(result);
//    }
}

