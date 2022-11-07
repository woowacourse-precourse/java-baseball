package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        /*
         * ===============
         * 숫자 야구 게임
         * 서로 다른 수 3가지의 수를 맞추는 게임
         * ================================================
         * 컴퓨터가 랜덤으로 숫자를 뽑는다.
         * 플레이어가 유추한 3자리의 답을 알려주면서 플레이어가 맞혀한다.
         * 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
         * 사용자가 값을 잘못 입력하면 IllegalArgumentException을 발생시킨 후 에플리케이션은 종료되어야한다.
         * */

    }

}

class Game {

    private static List<Integer> gameAnswer;

    Game() {
        gameAnswer = getGameRandomNumber();
    }

    public static List<Integer> getGameAnswer() {
        return gameAnswer;
    }


    public List<Integer> getGameRandomNumber() {

        // 3개의 무작위 난수를 중복 없이 뽑는다.
        List<Integer> gameRandomNumber = new ArrayList<>();
        while (gameRandomNumber.size() < 3) {
            int randomNumber = getRandomNumber();
            // Random Number가 list 원소에 포함되어 있지 않다면, 추가한다.
            if (!gameRandomNumber.contains(randomNumber)) {
                gameRandomNumber.add(randomNumber);
            }
        }

        return gameRandomNumber;
    }

    public int getRandomNumber() {
        // 1 ~ 9 범위의 난수를 return하는 함수.
        return pickNumberInRange(1, 9);
    }

}

