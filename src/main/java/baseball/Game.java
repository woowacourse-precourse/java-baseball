package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.User.*;

public class Game {

    static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private Computer computer;
    private User user;
    private Referee referee;

    private List<Integer> computerNumbers;
    private List<Integer> userNumbers;

    public Game() {
        this.computer = new Computer();
        this.user = new User();
        this.referee = new Referee();
    }

    public void startGame() {
        System.out.println(START_MESSAGE);
        playGame();
    }

    public void playGame() {
        computerNumbers = computer.pickRandomNumbers();
        userNumbers = user.inputNumbers();

        while (!referee.judgeReferee(computerNumbers, userNumbers)) {
            userNumbers = user.inputNumbers();
        }
    }
}
