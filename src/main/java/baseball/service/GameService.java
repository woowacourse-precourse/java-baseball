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

    private void initGame() {
        computer = new Computer();
        System.out.println("숫자 야구 게임을 시작합니다.");
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
            for (int user = 0; user < userNum.size(); user++) {
                if (computerNum.get(com) != userNum.get(user)) {
                    continue;
                }
                if (com != user) {
                    ball++;
                    continue;
                }
                strike++;
            }
        }
        printScore();
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


}
