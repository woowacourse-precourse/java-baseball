package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.User.*;

public class Game {

    static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    static final String EXIT_MESSAGE = "게임을 종료합니다.";
    static final String RESTART_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    static final String RESTART_GAME = "1";
    static final String END_GAME = "2";

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
        askRestartOrExitGame();
    }

    public void playGame() {
        computerNumbers = computer.pickRandomNumbers();
        userNumbers = user.inputUserNumbers();

        while (!referee.judgeReferee(computerNumbers, userNumbers)) {
            userNumbers = user.inputUserNumbers();
        }
    }

    public void askRestartOrExitGame() {
        System.out.println(RESTART_OR_EXIT);
        String userInput = Console.readLine();

        if (userInput.equals(RESTART_GAME)) {
            startGame();
        } else if (userInput.equals(END_GAME)) {
            System.out.println(EXIT_MESSAGE);
        }
    }
}
