package Views;

import Utils.Messages;

import java.util.Map;

public class OutputView {
    public static final OutputView OUTPUT_VIEW = new OutputView();

    public void PrintGameStartMessage() { //게임 시작 문구 출력
        System.out.println(Messages.GAME_START_MESSAGE);
    }

    public void PrintInputNumber() {
        System.out.println(Messages.NUMBER_INPUT_MESSAGE);
    }

    public void PrintBall(Map<String, Integer> result) {
        System.out.print(result.get("ball") + "볼 ");
    }

    public void PrintStrike(Map<String, Integer> result) {
        System.out.println(result.get("strike") + "스트라이크");
    }

    public void PrintNothing() {
        System.out.println("낫싱");
    }

    public void PrintRestartGame() {
        System.out.println(Messages.END_MESSAGE);
        System.out.println(Messages.YES_OR_NO_MESSAGE);
    }

}
























