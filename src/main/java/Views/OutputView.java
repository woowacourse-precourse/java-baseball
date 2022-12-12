package Views;

import Utils.Messages;

public class OutputView {
    public static final OutputView OUTPUT_VIEW = new OutputView();

    public void PrintGameStartMessage() { //게임 시작 문구 출력
        System.out.println(Messages.GAME_START_MESSAGE);
    }

    public void PrintInputNumber() {
        System.out.println(Messages.NUMBER_INPUT_MESSAGE);
    }
}
























