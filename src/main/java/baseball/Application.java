package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = new Computer();
        Round round = new Round(computer);
        while (true) {
            round.startNewRound();
            round.playRound();
        }

    }
}
