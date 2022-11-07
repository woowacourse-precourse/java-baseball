package game;

import camp.nextstep.edu.missionutils.Console;

public class Game {


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

}
