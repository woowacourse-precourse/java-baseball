package baseball;

import java.util.List;

public class Game {
    private static final String START_SENTENCE = "숫자 야구 게임을 시작합니다.";

    private List<Integer> computer;

    public void startGame() {
        System.out.println(START_SENTENCE);

        setComputer();
    }

    private void setComputer() {
        Number number = new Number();
        this.computer = number.getComputerNumber();
    }
}
