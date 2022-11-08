package baseball.domain;

import baseball.util.ListUtil;

import java.util.List;

public class GameController {
    private static GameController instance = null;
    private static Computer computer = null;
    private static User user = null;
    private static boolean keepPlaying;

    GameController() {
        this.computer = new Computer();
        this.user = new User();
        this.keepPlaying = true;
    }

    public static GameController getInstance() {
        if (instance == null) instance = new GameController();
        // 재호출 시 종료 플래그 초기화
        instance.keepPlaying = true;
        return instance;
    }

    public void run() {
        // 종료 플래그가 나올 때까지 계속 실행
        while (keepPlaying) {
            playGame();
            requestNewGame();
        }
    }

    void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.clearRandomNumbers();
        if (!computer.isReady()) computer.initRandomNumbers();
        computer.getCounts();
        List<Integer> answer = null;
        while (!isClear(answer)) answer = user.inputUserAnswer();

    }

    boolean isClear(List<Integer> input) {
        if (input == null) return false;

        int strike = ListUtil.countSameLocationValues(input, computer.getBallCounts());
        int ball = ListUtil.countDiffLocationValues(input, computer.getBallCounts());

        if (ball == 0 && strike == 0) System.out.print("낫싱");
        if (ball != 0) System.out.print(ball + "볼 ");
        if (strike != 0) System.out.print(strike + "스트라이크");
        System.out.println();
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    void requestNewGame() {
        if (user.inputKeepPlaying() == 2) keepPlaying = false;
    }
}
