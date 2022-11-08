package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    static final String START_MESSAGE = "숫자 야구 게임을 시작합니다";
    static final String NOTHING = "낫싱";
    static final String SOME_CORRECT = "%d볼 %d스트라이크\n";
    static final String ALL_CORRECT = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    static final int AGAIN_GAME = 1;
    static final int EXIT_GAME = 2;

    private Computer computer = new Computer();
    private User user = new User();
    private List<Integer> computerNumber;
    private List<Integer> userNumber;
    int strike = 0;
    int ball = 0;

    public void startGame() {
        System.out.println(START_MESSAGE);
        do {
            computerNumber = computer.makeComputerNumber();
            playGame();
            System.out.println(END_MESSAGE);
        } while (isFinish());
    }

    private void playGame() {
        do {
            resetCount();
            userNumber = user.getUserNumber();
            calculateCount(computerNumber, userNumber);
            printMessage(strike, ball);
        } while (this.strike != 3);
    }

    void calculateCount(List<Integer> computerNum, List<Integer> userNum) {
        String computerNumString = computerNum.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        String userNumberString = userNum.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        for (int i = 0; i < Computer.NUMBER_LENGTH; i++) {
            int idx = userNumberString.indexOf(computerNumString.charAt(i));

            if (idx == i) {
                this.strike++;
            } else if (idx != -1) {
                this.ball++;
            }
        }
    }

    boolean isFinish() {
        String input = Console.readLine();
        int flag = Integer.parseInt(input);

        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
        if (flag == AGAIN_GAME) {
            return true;
        } else if (flag == EXIT_GAME) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    void printMessage(int strike, int ball) {
        if (strike == Computer.NUMBER_LENGTH) {
            System.out.println(ALL_CORRECT);
        } else if (strike == 0 && ball == 0) {
            System.out.println(NOTHING);
        } else {
            System.out.printf(SOME_CORRECT, ball, strike);
        }
    }

    private void resetCount() {
        this.strike = 0;
        this.ball = 0;
    }
}