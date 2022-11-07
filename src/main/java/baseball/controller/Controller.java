package baseball.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import baseball.exception.InputException;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int INPUT_LENGTH = 3;
    private static final char ZERO_CHARACTER = '0';
    private static final String RESTART_VALUE = "1";
    private static final String QUIT_VALUE = "2";

    Computer computer;
    Player player;

    private boolean done;
    private String input;

    private void initGame() {
        computer = new Computer(drawRandomNumbers(MIN_NUMBER, MAX_NUMBER, INPUT_LENGTH));
    }

    private List<Integer> drawRandomNumbers(int start, int end, int numLength) {
        Set<Integer> tempRandomNum = new HashSet<>();
        while (tempRandomNum.size() < numLength) {
            tempRandomNum.add(Randoms.pickNumberInRange(start, end));
        }
        return new ArrayList<>(tempRandomNum);
    }

    private void inputPlayer() {
        player = new Player(new ArrayList<>());
        input = Console.readLine();
        InputException.inputArgumentCheck(input, INPUT_LENGTH);
        for (int i = 0; i < input.length(); i++) {
            int number = input.charAt(i) - ZERO_CHARACTER;
            this.player.add(number);
        }
    }

    private void computeScore() {
        computer.initCount();
        for (int playerIndex = 0; playerIndex < INPUT_LENGTH; playerIndex++) {
            int playerNumber = player.getNumber(playerIndex);
            int computerIndex = computer.getIndex(playerNumber);
            counting(playerIndex, computerIndex);
        }
    }

    private void counting(int playerIndex, int computerIndex) {
        if (playerIndex == computerIndex) {
            computer.incStrikeCount();
            return;
        }
        if (computerIndex > -1) {
            computer.incBallCount();
        }
    }

    private boolean isCorrectAnswer() {
        OutputView.printResult(computer.getStrikeCount(), computer.getBallCount());
        if (computer.getStrikeCount() == INPUT_LENGTH) {
            OutputView.printSuccess();
            return true;
        }
        return false;
    }

    private boolean isQuit() {
        InputView.printAskReStart();
        input = Console.readLine();
        InputException.inputRestartOrQuit(input, RESTART_VALUE, QUIT_VALUE);
        return input.equals(QUIT_VALUE);
    }

    private void run() {
        initGame();
        done = false;
        while (!done) {
            InputView.printInputNumber();
            inputPlayer();
            computeScore();
            done = isCorrectAnswer();
        }
    }

    public void game() {
        InputView.printGameStart();
        done = false;
        while (!done) {
            run();
            done = isQuit();
        }
    }
}