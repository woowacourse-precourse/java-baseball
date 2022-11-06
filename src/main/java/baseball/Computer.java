package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Computer {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int LENGTH = 3;

    static List<Integer> computer = new ArrayList<>();

    public Computer(){
        computer.clear();

    }

    public void init(){
        while (computer.size() < LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }


    public static Map<String, Integer> calcScore(Player player){
        List<Boolean> visit = new ArrayList<>();
        for(int i = 0; i < LENGTH; i++){
            visit.add(false);
        }


        List<Integer> playerInputList = player.getPlayerInputList();
        Map<String, Integer> result = new HashMap<>();

        // 스트라이크 계산
        for(int i = 0; i < LENGTH; i++){
            if(playerInputList.get(i).equals(computer.get(i))){
                if(result.containsKey("스트라이크")){

                    result.put("스트라이크", result.get("스트라이크") + 1);

                }else {
                    result.put("스트라이크", 1);
                }
                visit.set(i, true);
            }
        }


        for(int i = 0; i < LENGTH; i++){
            if(!visit.get(i)){
                if(computer.contains(playerInputList.get(i))){
                    if(result.containsKey("볼")){

                        result.put("볼", result.get("볼") + 1);

                    }else {
                        result.put("볼", 1);
                    }
                    visit.set(i, true);
                }
            }
        }

        if(!visit.contains(true)){
            result.put("낫싱", 0);
        }

        return result;
    }

    @Override
    public String toString() {
        Iterator<Integer> it = computer.iterator();

        String s = "";
        while(it.hasNext()){
            s += it.next() + ", ";
        }

        return s;
    }
}
