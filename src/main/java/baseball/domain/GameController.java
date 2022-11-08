package baseball.domain;

import baseball.util.ListUtil;

import java.util.List;

public class GameController {
    private static GameController instance = null;
    private static Computer computer = null;
    private static User user = null;
    private static boolean keepPlaying;
    private static int strike;
    private static int ball;

    GameController() {
        this.computer = new Computer();
        this.user = new User();
    }

    private void initScore() {
        strike = 0;
        ball = 0;
    }

    public static GameController getInstance() {
        if (instance == null) instance = new GameController();
        // 재호출 시 종료 플래그 초기화
        instance.keepPlaying = true;
        return instance;
    }

    public void run() {
        // 종료 플래그가 나올 때까지 계속 실행
        while (getKeepPlaying()) {
            playGame();
            requestNewGame();
        }
    }

    private boolean getKeepPlaying() {
        return keepPlaying;
    }

    void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.initRandomNumbers();

        while (true) {
            boolean clearGame = isClear(user.inputUserAnswer(), computer.getBallCounts());
            printScore();
            initScore();
            if (clearGame) break;
        }

    }

    boolean isClear(List<Integer> input, List<Integer> computerNumbers) {
        if (input == null) return false;

        strike = ListUtil.countSameLocationValues(input, computerNumbers);
        ball = ListUtil.countDiffLocationValues(input, computerNumbers);

        if (strike == 3) return true;
        return false;
    }

    private void printScore() {
        if (ball == 0 && strike == 0) System.out.print("낫싱");
        if (ball != 0) System.out.print(ball + "볼 ");
        if (strike != 0) System.out.print(strike + "스트라이크");
        System.out.println();
        if (strike == 3) System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    void requestNewGame() {
        if (!user.inputKeepPlaying()) keepPlaying = false;
    }

    public Computer getComputer() {
        return computer;
    }
}
