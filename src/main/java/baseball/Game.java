package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {
    private int strike;
    private int ball;
    private String flag;

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            playGame();
            success();
            continueChoice();
        } while (flag.equals("1"));
    }

    public void continueChoice() {
        flag = Console.readLine();
        if (!(flag.equals("1") || flag.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }

    public void playGame() {
        Computer c = new Computer();
        c.makeComputerSolution();
        init();
        while (strike != 3) {
            init();
            System.out.print("숫자를 입력해주세요 : ");
            User u = new User();
            u.inputUserAnswer();
            compare(c.solution, u.answer);
            if (strike != 3) {
                printResult();
            }
        }

    }

    public void init() {
        strike = 0;
        ball = 0;
    }

    public void compare(List<Integer> solution, List<Integer> answer) {
        countStrike(solution, answer);
        countBall(solution, answer);
    }

    public void success() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printResult() {
        if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike == 0 && ball > 0) {
            System.out.println(ball + "볼");
        } else if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
    }

    public void countStrike(List<Integer> solution, List<Integer> answer) {
        for (int i = 0; i < answer.size(); i++) {
            if (solution.get(i) == answer.get(i)) {
                strike++;
            }
        }
    }

    public void countBall(List<Integer> solution, List<Integer> answer) {
        for (int i = 0; i < answer.size(); i++) {
            if (solution.contains(answer.get(i)) && solution.get(i) != answer.get(i)) {
                ball++;
            }
        }
    }
}
