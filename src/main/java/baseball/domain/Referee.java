package baseball.domain;

import java.util.List;

public class Referee {
    public String compare(List<Integer> computer, List<Integer> player){
        final Judgement judgement = new Judgement();
        int correctCount = judgement.correctCount(computer, player);

        int strike = 0;
        for (int placeIndex = 0; placeIndex < player.size(); placeIndex++) {
            if(judgement.hasPlace(player, placeIndex, player.get(placeIndex))){
                strike++;
            }
        }
        int ball = correctCount - strike;

        return ball + "볼 " + strike + " 스트라이크";
    }
}
