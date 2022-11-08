package baseball;

import java.util.List;

public class Game {
    private static final int MAX_STRIKE = 3;
    private static final Computer computer = new Computer();
    private static final Player player = new Player();
    private boolean isGameEnd = false;
    private int strike = 0;
    private int ball = 0;

    public void start() {
        while (!isGameEnd) {
            initGame();
            while (strike != MAX_STRIKE) {
                player.initNumbers();
                // 컴퓨터와 플레이어 수 비교
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            // 게임 다시 시작 or 완전 종료 선택
        }
    }

    private void initGame() {
        computer.initNumbers();
        isGameEnd = false;
        strike = 0;
        ball = 0;
    }

    private void checkComputerAndPlayer() {
        strike = checkStrike(computer.getNumbers(), player.getNumbers());
        ball = checkBall(computer.getNumbers(), player.getNumbers());
        // 결과에 대한 출력
    }

    private int checkStrike(List<Integer> computers, List<Integer> players) {
        int count = 0;
        for (int i = 0; i < computers.size(); i++) {
            if (computers.get(i).equals(players.get(i))) {
                count++;
            }
        }
        return count;
    }

    private int checkBall(List<Integer> computers, List<Integer> players) {
        int count = 0;
        for (int i = 0; i < computers.size(); i++) {
            if (computers.contains(players.get(i)) && !computers.get(i).equals(players.get(i))) {
                count++;
            }
        }
        return count;
    }

    private void resultPrint() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
            return;
        }
        if (strike == 0) {
            System.out.printf("%d볼\n", ball);
            return;
        }
        System.out.printf("%d볼 %d스트라이크\n", ball, strike);
    }
}
