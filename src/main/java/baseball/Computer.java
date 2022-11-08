package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Computer {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int LENGTH = 3;

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    static List<Integer> computer = new ArrayList<>();

    public void selectUniqueNumbers(){

        computer.clear();

        while (computer.size() < LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }


    public Map<String, Integer> getScoreMap(Player player){
        List<Boolean> visit = new ArrayList<>();
        for(int i = 0; i < LENGTH; i++){
            visit.add(false);
        }

        Map<String, Integer> resultMap = new HashMap<>();

        Map<Integer, Integer> playerInputMap = player.getPlayerInputMap();

        // 스트라이크 계산
        for(int i = 0; i < LENGTH; i++){
            if(playerInputMap.get(i).equals(computer.get(i))){
                if(resultMap.containsKey(STRIKE)){

                    resultMap.put(STRIKE, resultMap.get(STRIKE) + 1);

                }else {
                    resultMap.put(STRIKE, 1);
                }
                visit.set(i, true);
            }
        }


        for(int i = 0; i < LENGTH; i++){
            if(!visit.get(i)){
                if(computer.contains(playerInputMap.get(i))){
                    if(resultMap.containsKey(BALL)){

                        resultMap.put(BALL, resultMap.get(BALL) + 1);

                    }else {
                        resultMap.put(BALL, 1);
                    }
                    visit.set(i, true);
                }
            }
        }

        if(!visit.contains(true)){
            resultMap.put(NOTHING, 0);
        }

        validateScoreCount(resultMap);
        validateNothing(resultMap);
        return resultMap;
    }


    public void validateScoreCount(Map<String, Integer> scoreMap){
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

    public void validateNothing(Map<String, Integer> scoreMap){
        Set<String> keySet = scoreMap.keySet();
        if(keySet.size() > 1 && keySet.contains(NOTHING)){
            throw new IllegalArgumentException(NOTHING + "이면서 다른 결과값도 가지고 있습니다.");
        }
    }


    //    @Override
//    public String toString() {
//        Iterator<Integer> it = computer.iterator();
//
//        String s = "";
//        while(it.hasNext()){
//            s += it.next() + ", ";
//        }
//        return s;
//    }

}
