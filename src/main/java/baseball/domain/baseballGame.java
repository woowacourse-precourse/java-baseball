package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class baseballGame {
    private List<Integer> computer;
    private Set<Integer> randomNumberSet;
    private int strikeCount;
    private int ballCount;

    public baseballGame() {
        computer = new ArrayList<>();
        strikeCount = 0;
        ballCount = 0;
    }

    public void createRandomNumber() {
        int randomNumber;
        while (computer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            addNumber(randomNumber);
        }
        randomNumberSet = new HashSet<>(computer);
    }

    private void addNumber(int number) {
        if (!computer.contains(number)) {
            computer.add(number);
        }
    }

    public void initCounts() {
        strikeCount = 0;
        ballCount = 0;
    }

    public void checkMatch(String inputNumber) {
        for (int i = 0; i < 3; i++) {
            countStrikeAndBall(inputNumber, i);
        }
    }

    private void countStrikeAndBall(String inputNumber, int index) {
        if ((inputNumber.charAt(index) - '0') == computer.get(index)) {
            strikeCount += 1;
            return;
        }
        if (randomNumberSet.contains((inputNumber.charAt(index) - '0'))) {
            ballCount += 1;
        }
    }

    public void getGameResult(User user) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strikeCount == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            user.inputRestart();
            checkRestart(user.getRestart());
            return;
        }
        if (ballCount > 0) {
            System.out.print(ballCount + "볼 ");
        }
        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크");
        }
        System.out.println();
    }

    private void checkRestart(int restart) {
        if (restart == 1) {
            resetGame();
            randomNumberSet = new HashSet<>(computer);
        }
    }

    private void resetGame() {
        computer.clear();
        createRandomNumber();
    }
}
