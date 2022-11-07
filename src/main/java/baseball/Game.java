package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final int END_STRIKE_COUNT = 3;

    public List<Integer> setComputersRandomAnswer() {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int addNumber = getRandomIntegerExcludeInList(answer);
            answer.add(addNumber);
        }

        return answer;
    }

    public boolean getGameResultOfJudge(List<Integer> result) {
        int ballCount = result.get(0);
        int strikeCount = result.get(1);

        if (strikeCount == END_STRIKE_COUNT) {
            System.out.println("게임 종료");
            return true;
        }

        if( ballCount == 0 && strikeCount == 0){
            System.out.println("낫싱");
            return false;
        }

        if(ballCount != 0){
            System.out.print(ballCount + " 볼 ");
        }
        if(strikeCount != 0){
            System.out.print(strikeCount + " 스트라이크");
        }
        System.out.println();

        return false;
    }

    private int getRandomIntegerExcludeInList(List<Integer> answer) {
        int number;

        do {
            number = Randoms.pickNumberInRange(1, 9);
        } while (answer.contains(number));

        return number;
    }
}
