package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final int END_STRIKE_COUNT = 3;

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public List<Integer> setComputersRandomAnswer() {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < 3; i++){
            int addNumber = ListUtil.getRandomIntegerExcludeInList(answer);
            answer.add(addNumber);
        }
        return answer;
    }

    public boolean getGameResultOfJudge(List<Integer> ballStrikeCount) {
    }

    public boolean isPlayingNewGame() {
    }
}
