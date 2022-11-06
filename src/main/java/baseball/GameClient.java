package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class GameClient {
    private final BaseballUtil baseballUtil;
    public GameClient() {
        this.baseballUtil = new BaseballUtil();
    }

    public boolean gameStart() {

        return true;
    }

    private void announceGameStart() {
        this.baseballUtil.printlnLine("숫자 야구 게임을 시작합니다.");
    }

    private void announceGameEnd() {

    }

    private int getUserInput() {
        return 0;
    }

}
