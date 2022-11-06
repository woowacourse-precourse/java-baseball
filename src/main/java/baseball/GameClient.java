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
        this.baseballUtil.printlnLine("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        this.baseballUtil.printlnLine("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }

    private int getUserInput() {
        return this.userInputValidation(this.baseballUtil.readLineInt());
    }

    private int userInputValidation(int user_input) {
        if (!(user_input == 1 || user_input == 2)) {
            throw new IllegalStateException();
        }

        return user_input;
    }
}
