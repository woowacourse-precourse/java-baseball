package baseball.domain;

import java.util.List;

public class Judgement {
    public int correctCount(List<Integer> computer, List<Integer> player){
        int result = 0;
        for(int i = 0; i < player.size(); i++){
            int playerNumber = player.get(i);
            if(computer.contains(playerNumber)){
                result++;
            }
        }
        return result;
    }

    public boolean hasPlace(List<Integer> computer, int placeIndex, int number){
        return computer.get(placeIndex) == number;
//        if (computer.get(placeIndex) == number) {
//            return true;
//        }
//        return false;
    }
}
