package game;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import member.Computer;
import member.User;

public class Game {
    private static final int STARTING_INDEX = 0;
    private static final int MAX_LENGTH_OF_NUMBER = 3;
    private final User user = new User();
    private final Computer computer = new Computer();
    private final Hint hint = new Hint();

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            initialize();
            play(computer.getNumbers(), user.getNumbers());
        } while (waiting());
    }

    private void initialize() {
        computer.clearNumbers();
        computer.setNumbers();
        user.clearNumbers();
        hint.clearHint();
    }

    private void play(List<Integer> computerNumbers, List<Integer> userNumbers) {

        while (!isThreeStrike()) {
            hint.clearHint();
            user.clearNumbers();
            user.inputNumber();

            checkBallAndStrike(computerNumbers, userNumbers);
            hint.print();
        }

        stop();
    }

    private void stop() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean waiting() {
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

    private void checkBallAndStrike(List<Integer> computerNumbers, List<Integer> userNumbers) {

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

    private boolean isThreeStrike() {

        if (hint.getStrike() == 3) {
            return true;
        }
        return false;
    }
}
