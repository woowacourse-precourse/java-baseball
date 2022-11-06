package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private Computer computer;
    private User user;
    private int strike, ball;

    public GameService() {
    }

    public void startGame() throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            doTurn();
        } while (strike != 3);
        endGame();
    }

    public void initGame(int digit, int startRange, int endRange) {
        computer = new Computer(digit, startRange, endRange);
    }

    private void doTurn() throws IllegalArgumentException {
        strike = 0;
        ball = 0;
        pickUserNum();
        countScore();
    }

    private void pickUserNum() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        List<Integer> userNum = new ArrayList<>();
        for (char x : userInput.toCharArray()) {
            userNum.add(x - '0');
        }
        user = new User();
        if (!user.isValid(userNum)) {
            throw new IllegalArgumentException();
        }
        user.setUserNum(userNum);
    }

    private void countScore() throws IllegalArgumentException {
        List<Integer> computerNum = computer.getComputerNum();
        List<Integer> userNum = user.getUserNum();
        for (int com = 0; com < computerNum.size(); com++) {
            compareNum(computerNum, userNum, com);
        }
        printScore();
    }

    private void compareNum(List<Integer> computerNum, List<Integer> userNum, int com) {
        for (int user = 0; user < userNum.size(); user++) {
            if (computerNum.get(com) == userNum.get(user)) {
                compareIndex(com, user);
            }
        }
    }

    private void compareIndex(int com, int user) {
        if (com == user) {
            strike++;
        }
        if (com != user) {
            ball++;
        }
    }

    private void printScore() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strike == 0) {
            System.out.println(ball + "볼");
            return;
        }
        if (ball == 0) {
            System.out.println(strike + "스트라이크");
            return;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    private void endGame() throws IllegalArgumentException {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int userInput = Integer.parseInt(Console.readLine());
        if (userInput != 1 && userInput != 2) {
            throw new IllegalArgumentException();
        }
        if (userInput == 1) {
            startGame();
            return;
        }
        System.out.println("게임 종료");
    }


}
