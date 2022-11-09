package baseball.domain;

import java.util.List;

public class Referee {
    public String compare(List<Integer> computer, List<Integer> player) {
        // 몇 개의 숫자가 같은지 알아낸 뒤
        // 스트라이크의 갯수를 구해 뺀다.
        // 남은 수는 볼의 개수이다.
        final Judgment judgment = new Judgment();
        int correctCount = judgment.correctCount(computer, player);
        int strike = 0;

        for (int placeIndex=0; placeIndex<player.size(); placeIndex++) {
            if (judgment.hasPlace(computer, placeIndex, player.get(placeIndex))) {
                strike++;
            }
        }

        int ball = correctCount - strike;

        if(correctCount == 0) {
            return "낫싱";
        }

        return ball +"볼 " +strike +"스트라이크";
    }
}
