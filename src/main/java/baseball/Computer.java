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
        HintMap.put("스트라이크", 0);
        HintMap.put("볼", 0);
    }
    public static List<Integer> makeAnswer(){
        List<Integer> Answer = new ArrayList<>();
        while(Answer.size() < 3){
            addRandomNumber(Answer);
        }
        return Answer;
    }

    public static void isStrikeOrBall(int AnswerNum, int num){
        if(AnswerNum == num){
            HintMap.replace("스트라이크", HintMap.get("스트라이크")+1);
        }
        else{
            HintMap.replace("볼", HintMap.get("볼")+1);
        }
    }

    public static void checkPlayerAnswer(int AnswerNum, int num){
        if (Answer.contains(num)) {
            isStrikeOrBall(AnswerNum, num);
        }
    }

    public static void makeHintMap(List<Integer> list){
        for(int i = 0; i < list.size(); i++){
            checkPlayerAnswer(Answer.get(i), list.get(i));
        }
    }
}

