package baseball.controller;

public class BaseBallGame {
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private boolean repeatFlag;

    public BaseBallGame() {
        this.repeatFlag = true;
    }

    public void startGame() {
        System.out.println(START_GAME);
        repeatGame();
    }

    public void repeatGame() {
        while (repeatFlag == true) {
            createNewGame();
        }
    }

    private boolean createNewGame() {
        // TODO: Random 한 세 자리 숫자를 생성한다.
        // TODO: 정답을 추측하는 기능
        // TODO: 계속해서 게임을 할건지 물어 보는 기능
        // TODO: 대답에 따라 게임을 계속할지 판단하는 기능
    }
}
