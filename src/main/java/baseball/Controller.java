package baseball;

import java.util.*;

public class Controller {
    private static final int LENGTH = 3;

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    private static final Map<String, Integer> scoreMap = new HashMap<>();
    private static List<Integer> computerNumberList;
//    private static Map<Integer, Integer> playerNumberMap;
    private static List<Integer> playerNumberList;

    public static Map<String, Integer> calcScore(Computer computer, Player player){
        computerNumberList = computer.getComputer();
        playerNumberList = player.getPlayerInputList();

        scoreMap.clear();

        calcStrike();
        calcBall();
        calcNothing();

        validateNothing();
        validateScoreCount();

        return scoreMap;
    }

    public static void calcNothing(){
        Set<String> keySet = scoreMap.keySet();
        if(keySet.size() == 0){
            increaseScore(NOTHING);
        }
    }

    public static void calcStrike(){
        for(int i = 0; i < LENGTH; i++){
            if(playerNumberList.get(i).equals(computerNumberList.get(i))){
                increaseScore(STRIKE);
            }
        }
    }

    public static void calcBall(){
        for(Integer computerNumber : computerNumberList){
            if(playerNumberList.contains(computerNumber) &&
                    playerNumberList.indexOf(computerNumber) != computerNumberList.indexOf(computerNumber)){
                increaseScore(BALL);
            }
        }
    }


    public static void increaseScore(String key){
        if(scoreMap.containsKey(key)){
            Integer score = scoreMap.get(key);
            scoreMap.put(key, score + 1);
        }else{
            scoreMap.put(key, 1);
        }

    }


    public static void validateScoreCount(){
        Set<String> keySet = scoreMap.keySet();
        Iterator<String> it = keySet.iterator();

        while(it.hasNext()){
            String key = it.next();
            Integer value = scoreMap.get(key);
            if(value > LENGTH){
                throw new IllegalArgumentException(key + "의 카운트는 최대 + " + LENGTH + "입니다.");
            }
        }
    }

    public static void validateNothing(){
        Set<String> keySet = scoreMap.keySet();
        if(keySet.size() > 1 && keySet.contains(NOTHING)){
            throw new IllegalArgumentException(NOTHING + "이면서 다른 결과값도 가지고 있습니다.");
        }
    }
}
