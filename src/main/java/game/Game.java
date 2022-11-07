package game;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final int STARTING_INDEX = 0;
    private static final int MAX_LENGTH_OF_NUMBER = 3;

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {

        } while (waiting());
    }

    public boolean waiting() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int waitingInput = Integer.parseInt(Console.readLine());

        if (waitingInput == 1) {
            return true;
        }
        if (waitingInput == 2) {
            return false;
        }

        throw new IllegalArgumentException("잘못된 값을 입력하였습니다. 게임 종료");
    }

    public void checkBallAndStrike(List<Integer> computerNumbers, List<Integer> userNumbers) {

        for (int i = STARTING_INDEX; i < MAX_LENGTH_OF_NUMBER; i++) {

            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                hint.incrementStrike();
                continue;
            }

            if (computerNumbers.contains(userNumbers.get(i))) {
                hint.incrementBall();
            }
        }
    }


}
