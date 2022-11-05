package baseball;

import java.util.List;

public class Compare {
    public int countContains(List<Integer> computer, List<Integer> player){
        int contains = 0;
        for(int i = 0 ; i < player.size(); i++){
            if(computer.contains(player.get(i))){
                contains += 1;
            }
        }
        return contains;
    }

    public int countStrike(List<Integer> computer, List<Integer> player){
        int strike = 0;
        for(int i= 0; i<player.size(); i++){
            if(computer.get(i) == player.get(i)){
                strike += 1;
            }
        }
        return strike;
    }
}
